package com.valuedbnta.demo.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ChatGPTRequest {

    //model: is the model we want to use as part of this message
    private String model;

    //what is the prompt we want to use
    private List<Message> messages;

    public ChatGPTRequest(String model, String prompt) {
        this.model = model;
        this.messages = new ArrayList<>();
        this.messages.add(new Message("user",prompt));
        //we want to pass a prompt and bind this prompt to the list of messages
    }
}
