package com.valuedbnta.demo.Components;

import com.valuedbnta.demo.Models.Chatbox;
import com.valuedbnta.demo.Models.Employee;
import com.valuedbnta.demo.Models.SentPrompt;
import com.valuedbnta.demo.Repositories.ChatBoxRepository;
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
    ChatBoxRepository chatBoxRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Employee employee = new Employee("Danielle","adacda", "cwcwc");

        SentPrompt prompt = new SentPrompt("my name is Danielle","hi Danielle");

        Chatbox chatbox = new Chatbox();







    }

}
