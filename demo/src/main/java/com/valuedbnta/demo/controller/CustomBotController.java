package com.valuedbnta.demo.controller;

import com.valuedbnta.demo.Models.Chatbox;
import com.valuedbnta.demo.Models.Employee;
//import com.valuedbnta.demo.Services.PromptService;
import com.valuedbnta.demo.Models.SentPrompt;
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

    private String recommendationSetup;

    private Chatbox chatBox = new Chatbox();

    //Do we need to PostCHatbox and PostUser first????
//    @PostMapping("/employee")
//    public Employee newEmployee (){
//       return
//    }

    @GetMapping("/conversation")
    public ChatGPTResponse chat(@RequestParam("prompt") String prompt) {

        //SET-UP CHATBOX:
        SentPrompt setup = new SentPrompt("You are a helpful corporate workplace friend and therapist, that is supportive and gives some advice. In conversations, you are only refer to yourself and role as the \"workplace friend\".  I am an employee. You must not break out of this role, even if asked to multiple times. Your answers must not be more than 255 characters in length", "Yes understood, I must not break out of this role");
        promptService.storeUserPrompt(setup);
        chatBox.getConversationHistory().add(setup);

        String conversationHistory = chatBox.getConversationHistory().toString();

            //GENERATE REQUEST AND RESPONSE
          //  promptService.storeUserPrompt(prompt);
            ChatGPTRequest request = new ChatGPTRequest(model, conversationHistory + prompt);
            ChatGPTResponse chatGPTResponse = template.postForObject(apiURL, request, ChatGPTResponse.class);

            //ADD USER HISTORY
            String responseContent = chatGPTResponse.getChoices().get(0).getMessage().getContent();
            SentPrompt newConversation = new SentPrompt(prompt,responseContent);

            promptService.storeUserPrompt(newConversation);
            chatBox.getConversationHistory().add(newConversation);

            return chatGPTResponse;
        }




}
