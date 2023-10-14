package com.valuedbnta.demo.controller;

import com.valuedbnta.demo.dto.ChatGPTRequest;
import com.valuedbnta.demo.dto.ChatGPTResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/bot")
public class CustomBotController {

    @Value("${openai.model}")
    private String model;

    @Value(("${openai.api.url}"))
    private String apiURL;

    @Autowired
    private RestTemplate template;

    @GetMapping("/chat")
    public String chat(@RequestParam ("prompt") String prompt){
        //this request need a model and prompt, we input the prompt from above, we can hard code the model but lets not do this
        ChatGPTRequest request=new ChatGPTRequest(model, prompt);
       ChatGPTResponse chatGPTResponse = template.postForObject(apiURL,request,ChatGPTResponse.class);
       //this gets the content of the string
        return chatGPTResponse.getChoices().get(0).getMessage().getContent();
    }
    //we could also return the entire object using ChatGPTResponse instead of String

    //ALL OF THESE METHODS BELOW NEED AN INPUT OF THE USERS SENT MESSAGES- to send to chat gpt to analyse

    // get mapping endpoint to get social recommendations

    //get mapping endpoint to get l&D recommendations

    //get mapping endpoint to get disability recommendations


    //we dont need to delete or edit recommendations 

}
