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

    @Column(name = "job_title")
    private String jobTitle;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    @JsonIgnoreProperties({"employee"})
    private List<SentPrompt> sentPrompts;

    public Employee() {
    }

    public Employee(String name, String email,String password, String manager, String jobTitle) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.manager = manager;
        this.jobTitle = jobTitle;
        this.sentPrompts = new ArrayList<>();
    }

    public Long getId() {
        return id;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public List<SentPrompt> getSentPrompts() {
        return sentPrompts;
    }

    public void setSentPrompts(List<SentPrompt> sentPrompts) {
        this.sentPrompts = sentPrompts;
    }
}