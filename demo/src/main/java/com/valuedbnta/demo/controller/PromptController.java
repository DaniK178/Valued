package com.valuedbnta.demo.controller;

import com.valuedbnta.demo.Models.Employee;
import com.valuedbnta.demo.Models.SentPrompt;
import com.valuedbnta.demo.Services.PromptService;
import com.valuedbnta.demo.dto.ChatGPTRequest;
import com.valuedbnta.demo.dto.ChatGPTResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
    @RequestMapping("/bot")
    public class PromptController {

        @Value("${openai.model}")
        private String model;

        @Value(("${openai.api.url}"))
        private String apiURL;

        @Autowired
        private RestTemplate template;

        @Autowired
        private PromptService promptService;

    @GetMapping("/get-social-recommendations")
    public String getSocialRecommendations() {

        List<String> storedPrompts = promptService.getStoredPrompts();
        String socialRequest = "Hello, from now on you will be a workplace chatbox that is supportive and gives recommendations to the employee based on the prompts listed below, the recommendation must fall under these three categories: \"social\", \"learning and development\" and \"disability support\".\n" +
                "I will be the employee. Please list up to 7 social recommendations you would make from the following prompts. Your response should only contain these recommendations. Display them in a numbered list " + storedPrompts;
        ChatGPTRequest combinedPromptRequest = new ChatGPTRequest(model, socialRequest);
        ChatGPTResponse socialGPTResponse = template.postForObject(apiURL,combinedPromptRequest,ChatGPTResponse.class);

        return socialGPTResponse.getChoices().get(0).getMessage().getContent();
    }

    @GetMapping("/get-learning-recommendations")
    public String getLearningAndDevelopmentRecommendations() {
        List<String> storedPrompts = promptService.getStoredPrompts();
        String socialRequest = "Hello, from now on you will be a workplace chatbox that is supportive and gives recommendations to the employee based on the prompts listed below, the recommendation must fall under these three categories: \"social\", \"learning and development\" and \"disability support\".\n" +
                "I will be the employee. Please list up to 7 learning and development recommendations you would make from the following prompts. Your response should only contain these recommendations. Display them in a numbered list " + storedPrompts;
        ChatGPTRequest combinedPromptRequest = new ChatGPTRequest(model, socialRequest);
        ChatGPTResponse socialGPTResponse = template.postForObject(apiURL,combinedPromptRequest,ChatGPTResponse.class);

        return socialGPTResponse.getChoices().get(0).getMessage().getContent();
    }

    @GetMapping("/get-disability-recommendations")
    public String getDisabilityRecommendations(){
        List<String> storedPrompts = promptService.getStoredPrompts();
        String socialRequest = "Hello, from now on you will be a workplace chatbox that is supportive and gives recommendations to the employee based on the prompts listed below, the recommendation must fall under these three categories: \"social\", \"learning and development\" and \"disability support\".\n" +
                "I will be the employee. Please list up to 7 disability recommendations you would make from the following prompts. Your response should only contain these recommendations. Display them in a numbered list " + storedPrompts;
        ChatGPTRequest combinedPromptRequest = new ChatGPTRequest(model, socialRequest);
        ChatGPTResponse socialGPTResponse = template.postForObject(apiURL,combinedPromptRequest,ChatGPTResponse.class);

        return socialGPTResponse.getChoices().get(0).getMessage().getContent();
    }






}
