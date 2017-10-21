package com.example.consumer.controller;

import com.example.consumer.domain.Document;
import com.example.consumer.domain.Title;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class MainController {

    private static final Logger log = LoggerFactory.getLogger(MainController.class);

    @RequestMapping("/")
    public String home(){

        RestTemplate restTemplate = new RestTemplate();
        ApiResponse response = restTemplate.getForObject("http://localhost:8090/provider/documents/3", ApiResponse.class);

        ObjectMapper mapper = new ObjectMapper();
        Document document = mapper.convertValue(response.getContent(), Document.class);
        Title title = mapper.convertValue(response.getContent(), Title.class);

        System.out.println(document.toString());
        System.out.println(title.toString());


        String html = new StringBuilder()
                .append("<h1>Document</h1>")
                .append("<p>" + document.getTitle() + "<p>")
                .append("<p>" + document.getBody() + "<p>")
                .append("<p> version: " + document.getVersion() + "<p>")
                .append("<h1>Just Title</h1>")
                .append("<p>" + title.getTitle() + "<p>")
                .toString();

        return html;
    }
}
