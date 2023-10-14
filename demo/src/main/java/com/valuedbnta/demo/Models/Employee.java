package com.valuedbnta.demo.Models;

import java.util.ArrayList;
import java.util.List;

public class Employee {

    private String name;

    private String email;

    private String manager;

    private List<Message> sentMessages;

    public Employee() {
    }

    public Employee(String name, String email, String manager) {
        this.name = name;
        this.email = email;
        this.manager = manager;
        this.sentMessages = new ArrayList<>();
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

    public List<Message> getSentMessages() {
        return sentMessages;
    }

    public void setSentMessages(List<Message> sentMessages) {
        this.sentMessages = sentMessages;
    }
}
