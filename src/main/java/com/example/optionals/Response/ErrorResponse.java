package com.example.optionals.Response;

public class ErrorResponse implements WsResponse {

    private String responseMessage;

    public ErrorResponse(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }
}
