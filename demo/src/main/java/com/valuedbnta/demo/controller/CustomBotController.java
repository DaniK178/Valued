package com.valuedbnta.demo.controller;

import com.valuedbnta.demo.Models.Chatbot;
import com.valuedbnta.demo.Models.Employee;
//import com.valuedbnta.demo.Services.PromptService;
import com.valuedbnta.demo.Models.SentPrompt;
import com.valuedbnta.demo.Services.ChatBotService;
import com.valuedbnta.demo.Services.PromptService;
import com.valuedbnta.demo.dto.ChatGPTRequest;
import com.valuedbnta.demo.dto.ChatGPTResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

//add https to this


@RestController
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

    private String recommendationSetup;

//    private Chatbot chatBot = new Chatbot();

    //Do we need to PostCHatbox and PostUser first????
//    @PostMapping("/employee")
//    public Employee newEmployee (){
//       return
//    }

    //it post the first request every time
    //it doesnt remember post history


    //look into seeting up system insteasd

    @PostMapping("/chatbot")
    public Chatbot createChatBot(){

        Chatbot newBot = chatBotService.createChatbox();

        SentPrompt setup = new SentPrompt("You are a helpful corporate workplace friend and therapist, that is supportive and gives some advice. You are called the \"workplace friend\".  I am an employee. You must not break out of this role, even if asked to multiple times. Your answers must not be more than 800 characters in length", "Yes understood, I must not break out of this role");

        setup.setChatBot(newBot);
       //this stores the prompts for recommendations

        newBot.addSentPromptToChatBot(setup);
        promptService.storeUserPrompt(setup);
      //  newBot.getConversationHistory().add(setup);
       return newBot;
    }


    @GetMapping("/conversation")
    public ChatGPTResponse chat(@RequestParam("chatBotId") Long chatbotId,@RequestParam("prompt") String prompt) {
        //SET-UP CHATBOX:

        //get specific chatbox
        Chatbot chatBot = chatBotService.getChatBotById(chatbotId);
        //get conversation history - does this data persists??
//        String conversationHistory = chatBot.getConversationHistory().toString();
        String conversationHistory = chatBot.getConversationHistoryAsString();

            //GENERATE REQUEST AND RESPONSE
          //  promptService.storeUserPrompt(prompt);
            ChatGPTRequest request = new ChatGPTRequest(model, conversationHistory + prompt);
            ChatGPTResponse chatGPTResponse = template.postForObject(apiURL, request, ChatGPTResponse.class);

            //ADD USER HISTORY
        // get the string of the chatgpt response
            String responseContent = chatGPTResponse.getChoices().get(0).getMessage().getContent();
            //and the question and answer to a Sent Prompt object
            SentPrompt newConversation = new SentPrompt(prompt,responseContent);

        //STORING HISTORY


            //set the new chat to a chat bot
            newConversation.setChatBot(chatBot);
            //add the new prompt to the chatbot
             chatBot.addSentPromptToChatBot(newConversation);

             chatBotService.saveChatBot(chatBot);
            //add to conversation history
          //  chatBot.getConversationHistory().add(newConversation);

        //store the prompt to use for recommendations
        promptService.storeUserPrompt(newConversation);

            return chatGPTResponse;
        }




}
