package com.valuedbnta.demo.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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


    @ManyToOne (cascade = CascadeType.PERSIST)
    @JoinColumn(name ="employee_id")
    private Employee employee;


    @ManyToOne (cascade = CascadeType.PERSIST)
    @JoinColumn(name ="chatbot_id")
    @JsonIgnore
//    @JsonIgnoreProperties({"prompts"})
    private Chatbot chatbot;

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

    public Chatbot getChatbot() {
        return chatbot;
    }

    public void setChatBot(Chatbot chatbot) {
        this.chatbot = chatbot;
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
