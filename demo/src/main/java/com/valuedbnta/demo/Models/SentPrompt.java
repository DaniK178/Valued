package com.valuedbnta.demo.Models;

import java.time.LocalDate;

public class SentPrompt {


    private String answer;

    private LocalDate dateSent;

    public SentPrompt(){}
    public SentPrompt(String answer, LocalDate dateSent) {
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
