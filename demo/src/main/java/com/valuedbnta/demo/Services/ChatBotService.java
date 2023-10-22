package com.valuedbnta.demo.Services;

import com.valuedbnta.demo.Models.Chatbot;
import com.valuedbnta.demo.Models.SentPrompt;
import com.valuedbnta.demo.Repositories.ChatBotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatBotService {

    @Autowired
    ChatBotRepository chatBotRepository;
//store the


    public Chatbot createChatbox() {
        Chatbot chatbot = new Chatbot();
        return chatBotRepository.save(chatbot);
    }

    public Chatbot getChatBotById(Long chatBotId){
        return chatBotRepository.findById(chatBotId).orElse(null);
    }

    public Chatbot saveChatBot(Chatbot chatBot) {
        return chatBotRepository.save(chatBot);
    }
    public void saveConversation(SentPrompt sentPrompt){

    }
}


