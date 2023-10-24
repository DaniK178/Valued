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
        sentPrompt.setChatBot(this); // Set the chatbot reference in the SentPrompt
    }

    public List<SentPrompt> getConversationHistory() {
        return conversationHistory;
    }

    //    public List<SentPrompt> getConversationHistory() {
//        if (conversationHistory == null) {
//            conversationHistory = new ArrayList<>();
//        }
//        return conversationHistory;
//    }
//
//    public void setConversationHistory(List<SentPrompt> conversationHistory) {
//        this.conversationHistory = conversationHistory;
//    }
//
//    public void addSentPromptToChatBot(SentPrompt sentPrompt){
//        this.conversationHistory.add(sentPrompt);
//    }

    public String getConversationHistoryAsString() {
        // Build a string representation of the conversation history
        StringBuilder historyBuilder = new StringBuilder();

        for (SentPrompt sentPrompt : conversationHistory) {
            historyBuilder.append("Question: ").append(sentPrompt.getQuestion()).append("\n");
            historyBuilder.append("Response: ").append(sentPrompt.getResponse()).append("\n\n");
        }

        return historyBuilder.toString();
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

