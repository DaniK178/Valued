package com.valuedbnta.demo.Models;

import java.time.LocalDate;

public class Message {


    private String answer;

    private LocalDate dateSent;

    public Message(){}
    public Message(String answer, LocalDate dateSent) {
        this.answer = answer;
        this.dateSent = dateSent;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public LocalDate getDateSent() {
        return dateSent;
    }

    public void setDateSent(LocalDate dateSent) {
        this.dateSent = dateSent;
    }
}
