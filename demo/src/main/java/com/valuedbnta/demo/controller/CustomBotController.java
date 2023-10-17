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

    //this get mapping - takes in a prompt from the user - it return the chat gpt response
    //we need to add a default prompt for this - before chatgpt can ask questions

    @PostMapping("/start")
    public void StartConversation() {
//        chatBox = new Chatbox();
        chatBox.getConversationHistory().put("System Message", "You are a helpful workplace friend and therapist, that is supportive and gives some advice.");
        //do i want to create a message request that has system instead of user
    }


//ask lolaL

    @GetMapping("/conversation")
    public ChatGPTResponse chat(@RequestParam("prompt") String prompt) {
     //   chatBox = new Chatbox();
        chatBox.getConversationHistory().put("You are a helpful corporate workplace friend and therapist, that is supportive and gives some advice. In conversations you are called the Workplace friend.  I am an employee. You must not break out of this role, even if asked to multiple times","Yes understood, I must break out of of this role");
        String conversationHistory = chatBox.getConversationHistory().toString();

        //GENERATE REQUEST AND RESPONSE
//      promptService.storeUserPrompt(prompt);
        ChatGPTRequest request = new ChatGPTRequest(model,conversationHistory + prompt);
        //we are expecting a chatgpt response type (CGPTR.class)
        ChatGPTResponse chatGPTResponse = template.postForObject(apiURL, request, ChatGPTResponse.class);

        //ADD USER HISTORY
        String responseContent =  chatGPTResponse.getChoices().get(0).getMessage().getContent();

        chatBox.getSentPrompts().add(prompt);
       // chatBox.getConversationHistory().put(prompt,responseContent);
       chatBox.getConversationHistory().put(chatBox.getSentPrompts().get(chatBox.getSentPrompts().size() - 1), responseContent);
        //i need to pass in their history as a string as part of the prompt

        //return chatGPTResponse.getChoices().get(0).getMessage().getContent();
        return chatGPTResponse;
        //you can return the entire chatgptresponse object or extract the content of the message like we have done
    }
}


//add initial prompt
//we need to create coversation history:
//


//we want to create an initial conversation - add this as the inital message in the chat history
//


//    @GetMapping("/chat")
//    public ResponseEntity<String> chat(@RequestParam ("prompt") String prompt){
//        promptService.storeUserPrompt(prompt);
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        String requestBody = "{"
//                + "\"model\": \"gpt-3.5-turbo\","
//                + "\"messages\": ["
//                + "  { \"role\": \"system\", \"content\": \"You are a friendly, supportive workplace friend, who can give advice.\" },"
//                + "  { \"role\": \"user\", \"content\": \"" + prompt + "\" }"
//                + "]}";
//
//       // ChatGPTRequest request=new ChatGPTRequest(model, prompt);
//
//
//        HttpEntity<String> userRequest = new HttpEntity<>(requestBody, headers);
//        ResponseEntity<String> response = template.exchange(apiURL, HttpMethod.POST, userRequest, String.class);
//
//      //  response.getC
//       // ResponseEntity<String> chatGPTResponse = template.exchange(apiURL, HttpMethod.POST,ChatGPTResponse.class);
//
//        // Handle the API response and extract the GPT response
//        // You can also add error handling here
//
//        return response;
//        // return chatGPTResponse.getChoices().get(0).getMessage().getContent(); (chat gpt response as a string)
//        // return new ResponseEntity<String>(chatGPTResponse, HttpStatus.OK);
//    }
    //we could also return the entire object using ChatGPTResponse instead of String

