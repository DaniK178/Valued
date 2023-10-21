package com.valuedbnta.demo.Services;

import com.valuedbnta.demo.Repositories.UserPromptRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PromptService {

private UserPromptRepository userPromptRepository;

private  List<String> storedPrompts = new ArrayList<>();

    public PromptService(UserPromptRepository promptRepository) {
        this.userPromptRepository = promptRepository;
    }

//    public void storeUserPrompt(String userPrompt) {
//        userPromptRepository.save(userPrompt);
//       // storedPrompts.add(userPrompt);
//    }
//
//    public List getStoredPrompts(){
//     return  userPromptRepository.findAll();
//    }


}
