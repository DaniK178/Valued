package com.valuedbnta.demo.Services;

import com.valuedbnta.demo.Models.SentPrompt;
import com.valuedbnta.demo.Repositories.PromptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PromptService {

    @Autowired
    private PromptRepository promptRepository;

//private  List<String> storedPrompts = new ArrayList<>();


    public void storeUserPrompt(SentPrompt userPrompt) {
        promptRepository.save(userPrompt);
       // storedPrompts.add(userPrompt);
    }

    //get  stored prompts by userid?
    public List<String> getStoredPrompts(){
     List<SentPrompt> sentPrompts =  promptRepository.findAll();
     List<String> storedPrompts = new ArrayList<>();
        for (SentPrompt prompt:  sentPrompts ) {
            storedPrompts.add(prompt.getQuestion() );
        }
        return storedPrompts;
    }

    public List<String> getStoredPromptsByEmployeeId(Long employeeId){
        List<SentPrompt> sentPrompts =  promptRepository.findByEmployeeId(employeeId);
        List<String> storedPrompts = new ArrayList<>();
        for (SentPrompt prompt:  sentPrompts ) {
            storedPrompts.add(prompt.getQuestion() );
        }
        return storedPrompts;
    }




    //get stored prompts by employeeId

    //i could filter out here or in the controller

}
