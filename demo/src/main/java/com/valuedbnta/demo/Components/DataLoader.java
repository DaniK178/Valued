package com.valuedbnta.demo.Components;

import com.valuedbnta.demo.Models.Chatbot;
import com.valuedbnta.demo.Models.Employee;
import com.valuedbnta.demo.Models.SentPrompt;
import com.valuedbnta.demo.Repositories.ChatBotRepository;
import com.valuedbnta.demo.Repositories.PromptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    PromptRepository promptRepository;

    @Autowired
    ChatBotRepository chatBotRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

    }

}
