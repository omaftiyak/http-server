package com.omaftiyak;


import java.io.IOException;

public class HttpException extends IOException {

    private String message;
    // todo rename field and getter to statusCode
    private int exeptionCode;

    public HttpException(int code, String message) {
        this.exeptionCode = code;
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getExeptionCode() {
        return exeptionCode;
    }

    public void setExeptionCode(int exeptionCode) {
        this.exeptionCode = exeptionCode;
    }
}
