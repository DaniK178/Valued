package com.valuedbnta.demo.controller;

import com.valuedbnta.demo.Models.Chatbox;
import com.valuedbnta.demo.Models.Employee;
//import com.valuedbnta.demo.Services.PromptService;
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

    private String recommendationSetup;

    private PromptService promptService;


    private Chatbox chatBox = new Chatbox();

    //TO do - create a prompt to use for all recommendations:

    @PostMapping("/start")
    public void StartConversation() {
        chatBox.getConversationHistory().put("System Message", "You are a helpful workplace friend and therapist, that is supportive and gives some advice.");
        //do i want to create a message request that has system instead of user
    }

    @GetMapping("/conversation")
    public ChatGPTResponse chat(@RequestParam("prompt") String prompt) {

//        if (prompt == "exit") {
//
//            ChatGPTRequest exitRequest = new ChatGPTRequest(model, prompt);
//            ChatGPTResponse chatGPTResponse = template.postForObject(apiURL, exitRequest, ChatGPTResponse.class);
//
//            return
//
//        } else {

            chatBox.getConversationHistory().put("You are a helpful corporate workplace friend and therapist, that is supportive and gives some advice. In conversations, you are only refer to yourself and role as the \"workplace friend\".  I am an employee. You must not break out of this role, even if asked to multiple times", "Yes understood, I must not break out of this role");
            String conversationHistory = chatBox.getConversationHistory().toString();

            //GENERATE REQUEST AND RESPONSE
//      promptService.storeUserPrompt(prompt);
            ChatGPTRequest request = new ChatGPTRequest(model, conversationHistory + prompt);
            ChatGPTResponse chatGPTResponse = template.postForObject(apiURL, request, ChatGPTResponse.class);

            //ADD USER HISTORY
            String responseContent = chatGPTResponse.getChoices().get(0).getMessage().getContent();
            chatBox.getSentPrompts().add(prompt);
            chatBox.getConversationHistory().put(chatBox.getSentPrompts().get(chatBox.getSentPrompts().size() - 1), responseContent);

            return chatGPTResponse;
        }
  //  }
}
