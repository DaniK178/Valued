package com.valuedbnta.demo.Services;

import com.valuedbnta.demo.Repositories.PromptRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PromptService {

private PromptRepository promptRepository;

    public PromptService(PromptRepository promptRepository) {
        this.promptRepository = promptRepository;
    }

    public List getStoredPrompts(){
     //   return

    }


}
