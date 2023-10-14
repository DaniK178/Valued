package com.valuedbnta.demo.Models;

import org.apache.catalina.User;

import java.util.List;

public class Chatbox {

 private User user;

    private List<Message> userMessages;

    private List<String> responses;

    public Chatbox() {
    }

    public Chatbox(User user, List<Message> userMessages, List<String> responses) {
        this.user = user;
        this.userMessages = userMessages;
        this.responses = responses;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Message> getUserMessages() {
        return userMessages;
    }

    public void setUserMessages(List<Message> userMessages) {
        this.userMessages = userMessages;
    }

    public List<String> getResponses() {
        return responses;
    }

    public void setResponses(List<String> responses) {
        this.responses = responses;
    }
}
