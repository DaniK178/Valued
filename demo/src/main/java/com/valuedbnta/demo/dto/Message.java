package com.valuedbnta.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message {

    //who is accessing it
    private String role;

    //the content - what you are searching for
    private String content;//prompt
}
