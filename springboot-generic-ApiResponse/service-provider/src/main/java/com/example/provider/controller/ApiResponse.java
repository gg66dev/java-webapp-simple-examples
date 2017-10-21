package com.example.provider.controller;

import com.example.provider.domain.Document;


public class ApiResponse {

    private enum StatusCode{
        OK(200),
        ERROR(500),
        NOT_FOUND(404);

        private int code;
        StatusCode(int code){
            this.code = code;
        }

        private int getCode(){
            return code;
        }
    }

    private StatusCode statusCode;
    private Object content;
    private String errorMessage;

    static public ApiResponse ok(){
        return new ApiResponse()
                .setCode(StatusCode.OK);
    }

    static public ApiResponse error(String errorMessage){
        return  new ApiResponse()
                .setCode(StatusCode.ERROR)
                .setErroMessage(errorMessage);
    }

    public ApiResponse setCode(StatusCode statusCode){
        this.statusCode = statusCode;
        return this;

    }

    public ApiResponse setDocument(Document doc){
        this.content = doc;
        return this;
    }

    public ApiResponse setErroMessage(String errorMessage){
        this.errorMessage = errorMessage;
        return this;
    }

    public StatusCode getStatusCode() {
        return statusCode;
    }

    public Object getContent() {
        return content;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
