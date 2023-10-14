package com.valuedbnta.demo.Models;

import org.apache.catalina.User;

import java.util.List;

public class Chatbox {

 private User user;

    private List<SentPrompt> sentPrompts;

    private List<String> responses;

    public Chatbox() {
    }

    public Chatbox(User user, List<SentPrompt> sentPrompts, List<String> responses) {
        this.user = user;
        this.sentPrompts = sentPrompts;
        this.responses = responses;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<SentPrompt> getSentPrompts() {
        return sentPrompts;
    }

    public void setSentPrompts(List<SentPrompt> sentPrompts) {
        this.sentPrompts = sentPrompts;
    }

    public List<String> getResponses() {
        return responses;
    }

    public void setResponses(List<String> responses) {
        this.responses = responses;
    }
}
