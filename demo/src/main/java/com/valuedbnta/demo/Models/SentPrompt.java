package com.valuedbnta.demo.Models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity(name = "prompts")
public class SentPrompt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Employee employee;

    @ManyToOne
    private Chatbox chatbox;



    @Column (name = "answer")
    private String answer;


   // private LocalDate dateSent;

    public SentPrompt(){}
    public SentPrompt(String answer) {
        this.answer = answer;
//        this.dateSent = dateSent;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

//    public LocalDate getDateSent() {
//        return dateSent;
//    }
//
//    public void setDateSent(LocalDate dateSent) {
//        this.dateSent = dateSent;
//    }
}
