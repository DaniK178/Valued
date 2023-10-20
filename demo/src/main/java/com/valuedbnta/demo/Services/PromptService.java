package com.valuedbnta.demo.Services;

import com.valuedbnta.demo.Models.SentPrompt;
import com.valuedbnta.demo.Repositories.UserPromptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PromptService {

    @Autowired
    private UserPromptRepository userPromptRepository;

//private  List<String> storedPrompts = new ArrayList<>();


    public void storeUserPrompt(SentPrompt userPrompt) {
        userPromptRepository.save(userPrompt);
       // storedPrompts.add(userPrompt);
    }

    //get  stored prompts by userid?
    public List getStoredPrompts(){
     return  userPromptRepository.findAll();
    }


}
