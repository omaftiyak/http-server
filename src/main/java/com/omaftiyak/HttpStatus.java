package com.omaftiyak;


public enum HttpStatus {
    SC_INTERNAL_SERVER_ERROR(500, "Internal server error"),
    SC_NOT_FOUND(404, "Not found"),
    SC_BAD_REQUEST(400, "Bad request");
    private int number;
    private String message;

    HttpStatus(int number, String message) {
        this.number = number;
        this.message = message;
    }

    public int getNumber() {
        return number;
    }

    public String getMessage() {
        return message;
    }

}
