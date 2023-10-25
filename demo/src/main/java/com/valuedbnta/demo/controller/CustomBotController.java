package com.valuedbnta.demo.controller;

import com.valuedbnta.demo.Models.Chatbot;
import com.valuedbnta.demo.Models.Employee;
//import com.valuedbnta.demo.Services.PromptService;
import com.valuedbnta.demo.Models.SentPrompt;
import com.valuedbnta.demo.Services.ChatBotService;
import com.valuedbnta.demo.Services.EmployeeService;
import com.valuedbnta.demo.Services.PromptService;
import com.valuedbnta.demo.dto.ChatGPTRequest;
import com.valuedbnta.demo.dto.ChatGPTResponse;
import com.valuedbnta.demo.dto.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

//add https to this


@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/bot")
public class CustomBotController {

    @Value("${openai.model}")
    private String model;

    @Value(("${openai.api.url}"))
    private String apiURL;

    @Autowired
    private RestTemplate template;

    @Autowired
    private PromptService promptService;

    @Autowired
    private ChatBotService chatBotService;

    @Autowired
    private EmployeeService employeeService;

    private String recommendationSetup;

    @GetMapping("/id ")
    public ResponseEntity<Long> getChatBotId(){
       return new ResponseEntity<>(chatBotService.getChatbot().getId(), HttpStatus.FOUND);
    }

    @GetMapping("/conversation")
    public ResponseEntity<ChatGPTResponse> chat(@RequestParam("prompt") String prompt) {

       if  (promptService.getSentPrompts().isEmpty()) {
           Chatbot newBot = chatBotService.createChatbox();

           SentPrompt setup = new SentPrompt("You are a helpful corporate workplace friend and therapist, that is supportive and gives some advice. You are name is Helen, you are the \"workplace friend\".  I am an employee. You must not break out of this role, even if asked to multiple times. Your answers must not be more than 800 characters in length", "Yes understood, I must not break out of this role");

           setup.setChatBot(newBot);
           newBot.addSentPromptToChatBot(setup);
           promptService.storeUserPrompt(setup);
           chatBotService.saveChatBot(newBot);
       }

       List<SentPrompt> prompts =  promptService.getSentPrompts();

       Long chatBotId = null;
       SentPrompt firstSentPrompt = prompts.get(0);
       chatBotId = firstSentPrompt.getChatbot().getId();

        Chatbot chatBot = chatBotService.getChatBotById(chatBotId);
            String conversationHistory = chatBot.getConversationHistoryAsString();

            ChatGPTRequest request = new ChatGPTRequest(model, conversationHistory + prompt);
            ChatGPTResponse chatGPTResponse = template.postForObject(apiURL, request, ChatGPTResponse.class);

            String responseContent = chatGPTResponse.getChoices().get(0).getMessage().getContent();
            SentPrompt newConversation = new SentPrompt(prompt, responseContent);

            newConversation.setChatBot(chatBot);
            chatBot.addSentPromptToChatBot(newConversation);

            chatBotService.saveChatBot(chatBot);
            promptService.storeUserPrompt(newConversation);

            return ResponseEntity.ok(chatGPTResponse);

    }
}