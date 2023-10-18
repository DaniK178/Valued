package com.valuedbnta.demo.Models;

import java.util.ArrayList;
import java.util.List;

public class Employee {

    private String name;

    private String email;

    private String manager;

    private List<String> sentPrompts;

    private List<Chatbox> chatboxes;

    public Employee() {
    }

    public Employee(String name, String email, String manager) {
        this.name = name;
        this.email = email;
        this.manager = manager;
        this.sentPrompts = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public List<String> getSentMessages() {
        return sentPrompts;
    }
    //or use sent prompts calls

    public void setSentMessages(List<String> sentMessages) {
        this.sentPrompts = sentMessages;
    }

//    public void addChatBox(Chatbox chatbox){
//        this.chatboxes.add(chatbox);
//        if (chatbox.get
//    }


}

