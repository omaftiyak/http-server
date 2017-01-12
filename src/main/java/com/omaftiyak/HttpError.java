package com.omaftiyak;


public enum HttpError {
    SC_INTERNAL_SERVER_ERROR(500,"Internal server error"),
    SC_FIlE_NOT_FOUND(404,"File not found"),
    SC_BAD_REQUEST(400,"Bad request");
    public int number;
    public String message;

    HttpError(int number, String message) {
        this.number = number;
        this.message = message;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
