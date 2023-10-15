package com.valuedbnta.demo.Services;

import com.valuedbnta.demo.Repositories.PromptRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PromptService {

private PromptRepository promptRepository;

private  List<String> storedPrompts = new ArrayList<>();

    public PromptService(PromptRepository promptRepository) {
        this.promptRepository = promptRepository;
    }

    public void storeUserPrompt(String userPrompt) {
        // Add the user prompt to the list of prompts
        storedPrompts.add(userPrompt);
    }

    public List getStoredPrompts(){
     return  promptRepository.findAll();
    }


}
