package com.valuedbnta.demo.Models;

import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDate;

@Entity
@Table(name = "prompts")
public class SentPrompt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @JoinColumn(name ="employee_id")
    private Employee employee;


    @ManyToOne
    @JoinColumn(name ="chatbox_id")
    private Chatbox chatbox;

    @Column (length = 4000, name = "question")
    private String question;

    @Column (length = 4000, name = "response")
    private String response;


   // private LocalDate dateSent;

    public SentPrompt(){}

    public SentPrompt(String question, String response) {
        this.question = question;
        this.response = response;
//        this.dateSent = dateSent;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Chatbox getChatbox() {
        return chatbox;
    }

    public void setChatbox(Chatbox chatbox) {
        this.chatbox = chatbox;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    //    public LocalDate getDateSent() {
//        return dateSent;
//    }
//
//    public void setDateSent(LocalDate dateSent) {
//        this.dateSent = dateSent;
//    }
}
