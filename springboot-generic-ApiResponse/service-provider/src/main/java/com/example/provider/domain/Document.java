package com.example.provider.domain;


import com.fasterxml.jackson.annotation.JsonInclude;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class Document  {
    private String title;
    private String Body;
    private int version;
    private boolean isValid;

    public Document(){}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return Body;
    }

    public void setBody(String body) {
        Body = body;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }

    @Override
    public String toString() {
        return "Document{" +
                "title='" + title + '\'' +
                ", Body='" + Body + '\'' +
                ", version=" + version +
                ", isValid=" + isValid +
                '}';
    }
}
