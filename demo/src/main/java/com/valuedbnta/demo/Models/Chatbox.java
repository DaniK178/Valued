package com.valuedbnta.demo.Models;

import org.apache.catalina.User;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Chatbox {

 private User user;

    private List<String> sentPrompts;

    private List<String> responses;


    private HashMap<String, String> conversationHistory;

    public Chatbox() {
        this.sentPrompts = new ArrayList<>();
        this.responses = new ArrayList<>();
        this.conversationHistory = new HashMap<>();
    }


    public Chatbox(User user) {
        this.user = user;
        this.sentPrompts = new ArrayList<>();
        this.responses = new ArrayList<>();
        this.conversationHistory = new HashMap<>();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<String> getSentPrompts() {
        if (sentPrompts == null) {
            sentPrompts = new ArrayList<>();
        }
        return sentPrompts;
    }

    public void setSentPrompts(List<String> sentPrompts) {
        this.sentPrompts = sentPrompts;
    }

    public List<String> getResponses() {
        return responses;
    }

    public void setResponses(List<String> responses) {
        this.responses = responses;
    }

    public HashMap<String, String> getConversationHistory() {
        return conversationHistory;
    }

    public void setConversationHistory(HashMap<String, String> conversationHistory) {
        this.conversationHistory = conversationHistory;
    }

    //i can make this set prompt in the future but it needs a date
}
