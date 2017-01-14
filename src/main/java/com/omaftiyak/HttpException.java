package com.omaftiyak;


import java.io.IOException;

public class HttpException extends IOException {

   private HttpStatus error;

    public HttpException(HttpStatus error) {
        this.error = error;
    }


    public HttpStatus getError() {
        return error;
    }

    public void setError(HttpStatus error) {
        this.error = error;
    }

}
