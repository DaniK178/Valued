package com.valuedbnta.demo.Models;

import java.util.ArrayList;
import java.util.List;

public class Employee {

    private String name;

    private String email;

    private String manager;

    private List<SentPrompt> sentPrompts;

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

    public List<SentPrompt> getSentMessages() {
        return sentPrompts;
    }

    public void setSentMessages(List<SentPrompt> sentMessages) {
        this.sentPrompts = sentMessages;
    }
}
