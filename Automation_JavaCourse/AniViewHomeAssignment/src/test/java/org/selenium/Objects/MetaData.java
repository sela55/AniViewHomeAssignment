package org.selenium.Objects;


import org.selenium.Utils.JacksonUtils;

import java.io.IOException;

public class MetaData {
    private String contentType;
    private String authorization;
    private String text;
    private String videoCode;
    private String username;
    private String baseURI;

    public MetaData(){}

    public MetaData(String baseURI, String contentType, String authorization, String text, String videoCode, String username) throws IOException {
        this.baseURI = baseURI;
        this.contentType = contentType;
        this.authorization = authorization;
        this.text = text;
        this.videoCode = videoCode;
        this.username = username;
    }

    public String getBaseURI() {
        return baseURI;
    }

    public void setBaseURI(String baseURI) {
        this.baseURI = baseURI;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getAuthorization() {
        return authorization;
    }

    public void setAuthorization(String authorization) {
        this.authorization = authorization;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getVideoCode() {
        return videoCode;
    }

    public void setVideoCode(String videoCode) {
        this.videoCode = videoCode;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}

