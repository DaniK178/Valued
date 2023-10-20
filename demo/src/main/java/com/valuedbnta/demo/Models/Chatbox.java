package com.valuedbnta.demo.Models;

import jakarta.persistence.*;
import org.apache.catalina.User;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Entity (name = "chatbox")
public class Chatbox {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "chatbox")
    private List<SentPrompt> sentPrompts;

    private List<SentPrompt> conversationHistory;

    // private HashMap<SentPrompt, String> conversationHistory;
    // private List<String> responses;

    public Chatbox() {
        this.sentPrompts = new ArrayList<>();
        this.conversationHistory = new ArrayList<>();
//        this.conversationHistory = new HashMap<>();
    }


    public List<SentPrompt> getConversationHistory() {
        if (conversationHistory == null) {
            conversationHistory = new ArrayList<>();
        }
        return conversationHistory;
    }

    public void setConversationHistory(List<SentPrompt> conversationHistory) {
        this.conversationHistory = conversationHistory;
    }
}



//    public Chatbox() {
//        this.sentPrompts = new ArrayList<>();
//        this.responses = new ArrayList<>();
//        this.conversationHistory = new HashMap<>();
//    }

//    public List<SentPrompt> getSentPrompts() {
//        if (sentPrompts == null) {
//            sentPrompts = new ArrayList<>();
//        }
//        return sentPrompts;
//    }
//
//    public void setSentPrompts(List<SentPrompt> sentPrompts) {
//        this.sentPrompts = sentPrompts;
//    }

//    public List<String> getResponses() {
//        return responses;
//    }
//
//    public void setResponses(List<String> responses) {
//        this.responses = responses;
//    }

    //    public HashMap<SentPrompt, String> getConversationHistory() {
//        return conversationHistory;
//    }
//
//    public void setConversationHistory(HashMap<SentPrompt, String> conversationHistory) {
//        this.conversationHistory = conversationHistory;
//    }

//    public void setUser(Employee user) {
//        this.user = user;
//        if (!user.getChatboxes().contains(this)) { // warning this may cause performance issues if you have a large data set since this operation is O(n)
//            user.getChatboxes().add(this);
//        }



    //i can make this set prompt in the future but it needs a date

