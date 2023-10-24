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
@CrossOrigin(origins = "http://localhost:3000")
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

    @GetMapping("/{userId}/conversation")
    public ResponseEntity<ChatGPTResponse> chat(@PathVariable Long userId, @RequestParam("prompt") String prompt) {
        //SET-UP CHATBOX:

        Employee employee = employeeService.getEmployeeById(userId);

       if  (employee.getSentPrompts().isEmpty()) {
           Chatbot newBot = chatBotService.createChatbox();

           SentPrompt setup = new SentPrompt("You are a helpful corporate workplace friend and therapist, that is supportive and gives some advice. You are called the \"workplace friend\".  I am an employee. You must not break out of this role, even if asked to multiple times. Your answers must not be more than 800 characters in length", "Yes understood, I must not break out of this role");

           //save to chatbot
           setup.setChatBot(newBot);
           newBot.addSentPromptToChatBot(setup);
           //save to employee
           setup.setEmployee(employee);
           employee.getSentPrompts().add(setup);
           //save to database
           promptService.storeUserPrompt(setup);
           employeeService.saveEmployee(employee);
       }

       List<SentPrompt> prompts =  promptService.getSentPromptsByEmployeeId(employee.getId());

       Long chatBotId = null;
       SentPrompt firstSentPrompt = prompts.get(0);
       chatBotId = firstSentPrompt.getChatbot().getId();

        Chatbot chatBot = chatBotService.getChatBotById(chatBotId);

        boolean hasUserAccess = chatBot.getConversationHistory().stream()
                .anyMatch(sentPrompt -> sentPrompt.getEmployee().getId().equals(userId));

        if (hasUserAccess) {
            String conversationHistory = chatBot.getConversationHistoryAsString();

            //GENERATE REQUEST AND RESPONSE
            ChatGPTRequest request = new ChatGPTRequest(model, conversationHistory + prompt);
            ChatGPTResponse chatGPTResponse = template.postForObject(apiURL, request, ChatGPTResponse.class);

            //ADD USER HISTORY
            String responseContent = chatGPTResponse.getChoices().get(0).getMessage().getContent();
            SentPrompt newConversation = new SentPrompt(prompt, responseContent);

            //STORING HISTORY
            newConversation.setChatBot(chatBot);
            chatBot.addSentPromptToChatBot(newConversation);

            //STORE TO USER ID
            newConversation.setEmployee(employee);
            employee.getSentPrompts().add(newConversation);

            //SAVE TO DATABASES
            employeeService.saveEmployee(employee);
            chatBotService.saveChatBot(chatBot);
            promptService.storeUserPrompt(newConversation);

            return ResponseEntity.ok(chatGPTResponse);
        } else {

            Message message = new Message("user", " Error, this may be because this user does not have access to this chatbot, please check the chatbot ID avaliable to yuo user:");
            ChatGPTResponse.Choice errorChoice =  new ChatGPTResponse.Choice(0,message);

            List<ChatGPTResponse.Choice> choices = new ArrayList<>();
            choices.add(errorChoice);

            ChatGPTResponse errorResponse = new ChatGPTResponse(choices);
            return new ResponseEntity<>(errorResponse, HttpStatus.FORBIDDEN);
        }

    }
}





//}
