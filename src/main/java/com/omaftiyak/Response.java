package com.omaftiyak;


public class Response {
    private String statusLine;
    private String headers;
    private String bodyMessage;

    @Override
    public String toString() {
        return  statusLine
                + headers
                + bodyMessage
                ;
    }
    public Response(String statusLine, String headers, String bodyMessage) {
        this.statusLine = statusLine;
        this.bodyMessage = bodyMessage;
        this.headers = headers;
    }

    public String getBodyMessage() {
        return bodyMessage;
    }

    public void setBodyMessage(String bodyMessage) {
        this.bodyMessage = bodyMessage;
    }

    public  String getHeaders() {
        return headers;
    }

    public void setHeaders(String headers) {
        this.headers = headers;
    }

    public String getStatusLine() {
        return statusLine;
    }

    public void setStatusLine(String statusLine) {
        this.statusLine = statusLine;
    }


}
