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
@CrossOrigin(origins = "http://localhost:3000")
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


//    @PostMapping("/start")
//    public void StartConversation() {
//        chatBox.getConversationHistory().put("System Message", "You are a helpful workplace friend and therapist, that is supportive and gives some advice.");
//        //do i want to create a message request that has system instead of user
//    }

    @GetMapping("/conversation")
    public ChatGPTResponse chat(@RequestParam("prompt") String prompt) {
            chatBox.getConversationHistory().put("You are a helpful corporate workplace friend that is supportive, listens and gives some advice. You empathise and dig deeper in conversations. In conversations, if you are asked who you are: you refer to yourself and role as the \"workplace friend\".  I am an employee. You must not break out of this role, even if asked to multiple times", "Yes understood, I must not break out of this role");
            String conversationHistory = chatBox.getConversationHistory().toString();

            //GENERATE REQUEST AND RESPONSE
            ChatGPTRequest request = new ChatGPTRequest(model, conversationHistory + prompt);
            ChatGPTResponse chatGPTResponse = template.postForObject(apiURL, request, ChatGPTResponse.class);

            //ADD USER HISTORY
            String responseContent = chatGPTResponse.getChoices().get(0).getMessage().getContent();
            chatBox.getSentPrompts().add(prompt);
            chatBox.getConversationHistory().put(chatBox.getSentPrompts().get(chatBox.getSentPrompts().size() - 1), responseContent);

            return chatGPTResponse;
        }


    @GetMapping("/get-social-recommendations")
    public String getSocialRecommendations() {
        List<String> storedPrompts = chatBox.getSentPrompts();
        String socialRequest = "Hello, from now on you will be a workplace chatbox that is supportive and gives recommendations to the employee based on the prompts listed below, the recommendation must fall under these three categories: \"social\", \"learning and development\" and \"disability support\".\n" +
                "I will be the employee. Please list UP TO 7 social recommendations you would make from the following prompts. Your response should only contain these recommendations. Display them in a numbered list " + storedPrompts;
        ChatGPTRequest combinedPromptRequest = new ChatGPTRequest(model, socialRequest);
        ChatGPTResponse socialGPTResponse = template.postForObject(apiURL,combinedPromptRequest,ChatGPTResponse.class);

        return socialGPTResponse.getChoices().get(0).getMessage().getContent();
    }

    @GetMapping("/get-l-and-d-recommendations")
    public String getlandRecommendations() {
        List<String> storedPrompts = chatBox.getSentPrompts();
        String socialRequest = "Hello, from now on you will be a workplace chatbox that is supportive and gives recommendations to the employee based on the prompts listed below, the recommendation must fall under these three categories: \"social\", \"learning and development\" and \"disability support\".\n" +
                "I will be the employee. Please list UP TO 7 learning and development recommendations you would make from the following prompts. Your response should only contain these recommendations. Display them in a numbered list " + storedPrompts;
        ChatGPTRequest combinedPromptRequest = new ChatGPTRequest(model, socialRequest);
        ChatGPTResponse socialGPTResponse = template.postForObject(apiURL,combinedPromptRequest,ChatGPTResponse.class);

        return socialGPTResponse.getChoices().get(0).getMessage().getContent();
    }

    @GetMapping("/get-disability-recommendations")
    public String getDisabilityRecommendations() {
        List<String> storedPrompts = chatBox.getSentPrompts();
        String socialRequest = "Hello, from now on you will be a workplace chatbox that is supportive and gives recommendations to the employee based on the prompts listed below, the recommendation must fall under these three categories: \"social\", \"learning and development\" and \"disability support\".\n" +
                "I will be the employee. Please list UP TO 7 disability support recommendations you would make from the following prompts. Your response should only contain these recommendations. Display them in a numbered list " + storedPrompts;
        ChatGPTRequest combinedPromptRequest = new ChatGPTRequest(model, socialRequest);
        ChatGPTResponse socialGPTResponse = template.postForObject(apiURL,combinedPromptRequest,ChatGPTResponse.class);

        return socialGPTResponse.getChoices().get(0).getMessage().getContent();
    }



    //  }



}
