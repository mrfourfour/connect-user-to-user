package com.example.connectUserToUser;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class ResponseMessage {
    // HttpStatus
    private int status;
    // Http Default Message
    private String message;

    public ResponseMessage() {}

    public ResponseMessage(int status, String message) {
        this.status = status;
        this.message = message;
    }
}