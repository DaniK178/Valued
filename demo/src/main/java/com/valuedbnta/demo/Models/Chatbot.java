package com.valuedbnta.demo.Models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity (name = "chatbot")
public class Chatbot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @OneToMany(mappedBy = "chatbot", fetch = FetchType.EAGER)
    private List<SentPrompt> conversationHistory;

    public Chatbot() {
        this.conversationHistory = new ArrayList<>();
    }

    public void addSentPromptToChatBot(SentPrompt sentPrompt){
        if (conversationHistory == null) {
            conversationHistory = new ArrayList<>();
        }
        conversationHistory.add(sentPrompt);
        sentPrompt.setChatBot(this); 
    }

    public List<SentPrompt> getConversationHistory() {
        return conversationHistory;
    }

    public Long getId() {
        return id;
    }

  

    public String getConversationHistoryAsString() {
        StringBuilder historyBuilder = new StringBuilder();

        for (SentPrompt sentPrompt : conversationHistory) {
            historyBuilder.append("").append(sentPrompt.getQuestion()).append("\n");
            historyBuilder.append("").append(sentPrompt.getResponse()).append("\n\n");
        }

        return historyBuilder.toString();
    }
}