package com.valuedbnta.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

public class PromptController {

    @RestController
    @RequestMapping("/bot")
    public class CustomBotController {

        @Value("${openai.model}")
        private String model;

        @Value(("${openai.api.url}"))
        private String apiURL;

        @Autowired
        private RestTemplate template;





    }
}
