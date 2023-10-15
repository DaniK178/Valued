package com.valuedbnta.demo.controller;

import com.valuedbnta.demo.Models.Employee;
//import com.valuedbnta.demo.Services.PromptService;
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

    private String recommendationSetup;

    private PromptService promptService;

    //TO do - create a prompt to use for all recommendations:

    //this get mapping - takes in a prompt from the user - it return the chat gpt response
    //we need to add a default prompt for this - before chatgpt can ask questions
    //we dont
    @GetMapping("/chat")
    public String chat(@RequestParam ("prompt") String prompt){
        //this request need a model and prompt, we input the prompt from above, we can hard code the model but lets not do this

        promptService.storeUserPrompt(prompt);
        // get mapping endpoint to get social recommendations

        ChatGPTRequest request=new ChatGPTRequest(model, prompt);
       ChatGPTResponse chatGPTResponse = template.postForObject(apiURL,request,ChatGPTResponse.class);
       //this gets the content of the string
        return chatGPTResponse.getChoices().get(0).getMessage().getContent();
        //return prompt
    }
    //we could also return the entire object using ChatGPTResponse instead of String

    //ALL OF THESE METHODS BELOW NEED AN INPUT OF THE USERS SENT MESSAGES- to send to chat gpt to analyse
    //messages from a particular user will be saved to a database
    //maybe access the message by getting the user id - and retrieving the messsages from this

    // get mapping endpoint to get social recommendations


    @GetMapping("/get-social-recommendations")
    public String getAndSendStoredPrompts() {
        // Retrieve the stored prompts from our service/database
        List<String> storedPrompts = promptService.getStoredPrompts();
        String combinedPrompt = String.join("\n", storedPrompts);
        String socialRequest = "Hello, from now on you will be a workplace chatbox that is supportive and gives recommendations to the employe based on the prompts listed below, the recommendation must fall under these three categories: \"social\", \"learning and development\" and \"disability support\".\n" +
                "I will be the employee. Please list up to 7 social recommendations you would make from the following prompts. Display them in a numbered list " + combinedPrompt;
        ChatGPTRequest combinedPromptRequest = new ChatGPTRequest(model, socialRequest);
        ChatGPTResponse socialGPTResponse = template.postForObject(apiURL,combinedPromptRequest,ChatGPTResponse.class);

        // Make an API request to ChatGPT using the combined prompt
//        String gptResponse = makeChatGPTRequest(combinedPrompt);
//        return gptResponse;

        return socialGPTResponse.getChoices().get(0).getMessage().getContent();
    }


    //you are an workplace bot






//    @GetMapping("/chat/social")
//    public String socialRecommendations (@RequestParam (defaultValue = "Hello, from now on you will be a workplace chatbox that gives recommendations to the employee. From the conversations, the recommendation must fall under these three categories: \"social\", \"learning and development\" and \"disability support\".\n" +
//            "I will be the employee\n, If you are to give any recommendation in your response, please state that category it falls under at the start of the response by putting e.g.Social category or Disability support category. The conversations are listed below" + usersMessages) String prompt){
//        //this request need a model and prompt, we input the prompt from above, we can hard code the model but lets not do this
//        ChatGPTRequest request=new ChatGPTRequest(model, prompt);
//        ChatGPTResponse chatGPTResponse = template.postForObject(apiURL,request,ChatGPTResponse.class);
//        //this gets the content of the string
//        return chatGPTResponse.getChoices().get(0).getMessage().getContent();
//    }

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
