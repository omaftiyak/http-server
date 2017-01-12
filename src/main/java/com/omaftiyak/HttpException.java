package com.omaftiyak;


import java.io.IOException;

public class HttpException extends IOException {

   private HttpError error;

    public HttpException(HttpError error) {
        this.error = error;
    }


    public HttpError getError() {
        return error;
    }

    public void setError(HttpError error) {
        this.error = error;
    }

}
