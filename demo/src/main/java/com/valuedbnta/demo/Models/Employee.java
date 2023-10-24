package com.valuedbnta.demo.Models;

import jakarta.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    //can be null
    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    //can be null
    @Column(name = "manager")
    private String manager;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    @JsonIgnoreProperties({"employee"})
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

//    public List<SentPrompt> getSentMessages() {
//        return sentPrompts;
//    }
//    //or use sent prompts calls
//
//    public void setSentMessages(List<SentPrompt> sentMessages) {
//        this.sentPrompts = sentMessages;
//    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<SentPrompt> getSentPrompts() {
        return sentPrompts;
    }

    public void setSentPrompts(List<SentPrompt> sentPrompts) {
        this.sentPrompts = sentPrompts;
    }
}







//Other methods to not be used
//    public List<String> getSentPrompts() {
//        return sentPrompts;
//    }
//
//    public void setSentPrompts(List<String> sentPrompts) {
//        this.sentPrompts = sentPrompts;
//    }

//    public List<Chatbox> getChatboxes() {
//        return chatboxes;
//    }
//
//    public void setChatboxes(List<Chatbox> chatboxes) {
//        this.chatboxes = chatboxes;
//    }

//    public void addChatBox(Chatbox chatbox){
//        this.chatboxes.add(chatbox);
//        if (chatbox.getUser() !=this){
//            chatbox.setUser(this);
//        }
//    }



