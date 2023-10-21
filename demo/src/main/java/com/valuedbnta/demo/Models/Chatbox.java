package com.valuedbnta.demo.Models;

import org.apache.catalina.User;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Chatbox {

 private Employee employee;

    private List<String> sentPrompts;

    private List<String> responses;


    private HashMap<String, String> conversationHistory;

    public Chatbox() {
        this.sentPrompts = new ArrayList<>();
        this.responses = new ArrayList<>();
        this.conversationHistory = new HashMap<>();
    }


    public Chatbox(Employee employee) {
        this.employee = employee;
        this.sentPrompts = new ArrayList<>();
        this.responses = new ArrayList<>();
        this.conversationHistory = new HashMap<>();
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee user) {
        this.employee = user;
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

//    public void setUser(Employee user) {
//        this.user = user;
//        if (!user.getChatboxes().contains(this)) { // warning this may cause performance issues if you have a large data set since this operation is O(n)
//            user.getChatboxes().add(this);
//        }



    //i can make this set prompt in the future but it needs a date
}
