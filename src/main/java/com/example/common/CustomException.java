package com.example.common;

public class CustomException extends RuntimeException {

    private int code;

    public CustomException(){}

    public CustomException(int code) {
        this.code = code;
    }

    public CustomException(String message, int code) {
        super(message);
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
