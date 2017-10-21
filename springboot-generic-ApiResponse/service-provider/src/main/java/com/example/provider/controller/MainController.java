package com.example.provider.controller;

import com.example.provider.domain.Document;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MainController {

    @RequestMapping(value = "documents/{version}" , method = RequestMethod.GET)
    public ApiResponse home(@PathVariable(name = "version") int version){

        Document document = new Document();
        document.setValid(true);
        document.setVersion(version);
        document.setBody("This is my document");
        document.setTitle("The document");

        return ApiResponse.ok().setDocument(document);

    }
}
