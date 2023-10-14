package com.valuedbnta.demo.controller;

import com.valuedbnta.demo.Models.Employee;
import com.valuedbnta.demo.Services.PromptService;
import com.valuedbnta.demo.dto.ChatGPTRequest;
import com.valuedbnta.demo.dto.ChatGPTResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/bot")
public class CustomBotController {

    @Value("${openai.model}")
    private String model;

    @Value(("${openai.api.url}"))
    private String apiURL;

    @Autowired
    private RestTemplate template;

    //this get mapping - takes in a prompt from the user - it return the chat gpt response
    //we dont
    @GetMapping("/chat")
    public String chat(@RequestParam ("prompt") String prompt){
        //this request need a model and prompt, we input the prompt from above, we can hard code the model but lets not do this

        StoreUserPrompt(prompt);
        ChatGPTRequest request=new ChatGPTRequest(model, prompt);
       ChatGPTResponse chatGPTResponse = template.postForObject(apiURL,request,ChatGPTResponse.class);
       //this gets the content of the string
        return chatGPTResponse.getChoices().get(0).getMessage().getContent();
        //return prompt
    }
    //we could also return the entire object using ChatGPTResponse instead of String

    //ALL OF THESE METHODS BELOW NEED AN INPUT OF THE USERS SENT MESSAGES- to send to chat gpt to analyse

    // get mapping endpoint to get social recommendations

    //messages from a particular user will be saved to a database
    //maybe access the message by getting the user id - and retrieving the messsages from this

    private PromptService promptService;

    @GetMapping("/get-prompt")
    public String getAndSendStoredPrompts() {
        // Retrieve the stored prompts from our service/database
        List<String> storedPrompts = promptService.getStoredPrompts();
        // Make a single prompt string from the collected prompts
        String combinedPrompt = String.join("\n", storedPrompts);
        // Make an API request to ChatGPT using the combined prompt
        String gptResponse = makeChatGPTRequest(combinedPrompt);

        return gptResponse;
    }

    //or return all of  chat gpt response?
    //I want to get to get the prompt from one chatgpt and pass this as a param
    //do i collect the same prompt object??







    @GetMapping("/chat/social")
    public String socialRecommendations (@RequestParam (defaultValue = "Hello, from now on you will be a workplace chatbox that gives recommendations to the employee. From the conversations, the recommendation must fall under these three categories: \"social\", \"learning and development\" and \"disability support\".\n" +
            "I will be the employee\n, If you are to give any recommendation in your response, please state that category it falls under at the start of the response by putting e.g.Social category or Disability support category. The conversations are listed below" + usersMessages) String prompt){
        //this request need a model and prompt, we input the prompt from above, we can hard code the model but lets not do this
        ChatGPTRequest request=new ChatGPTRequest(model, prompt);
        ChatGPTResponse chatGPTResponse = template.postForObject(apiURL,request,ChatGPTResponse.class);
        //this gets the content of the string
        return chatGPTResponse.getChoices().get(0).getMessage().getContent();
    }

    //get mapping endpoint to get l&D recommendations

    @GetMapping("/chat/landd")
    public String landdRecommendations (@RequestParam ("prompt") String prompt){
        //this request need a model and prompt, we input the prompt from above, we can hard code the model but lets not do this
        ChatGPTRequest request=new ChatGPTRequest(model, prompt);
        ChatGPTResponse chatGPTResponse = template.postForObject(apiURL,request,ChatGPTResponse.class);
        //this gets the content of the string
        return chatGPTResponse.getChoices().get(0).getMessage().getContent();
    }

    //get mapping endpoint to get disability recommendations
    @GetMapping("/chat/disability")
    public String disabilityRecommendations (@RequestParam ("prompt") String prompt){
        //this request need a model and prompt, we input the prompt from above, we can hard code the model but lets not do this
        ChatGPTRequest request=new ChatGPTRequest(model, prompt);
        ChatGPTResponse chatGPTResponse = template.postForObject(apiURL,request,ChatGPTResponse.class);
        //this gets the content of the string
        return chatGPTResponse.getChoices().get(0).getMessage().getContent();
    }

    //we dont need to delete or edit recommendations

}
