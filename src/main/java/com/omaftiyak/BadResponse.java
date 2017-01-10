package com.omaftiyak;


import java.io.IOException;
import java.net.Socket;

public class BadResponse extends Response {

    public BadResponse(String statusLine, String headers, String bodyMessage) {
        super(statusLine, headers, bodyMessage);
    }

    public BadResponse(HttpException exception) {
       // String str = "<html><body><h1>" + exception.getMessage() + "</h1></body></html>" ;
        super("HTTP/1.1 " + exception.getExeptionCode() + "\r\n", "Server: YarServer/2017-01-05\r\n" +
                        "Content-Type: text/html\r\n" +
                        "Content-Length: " +("<html><body><h1>" + exception.getMessage() + "</h1></body></html>").length() + "\r\n" +
                        "Connection: close\r\n\r\n", "<html><body><h1>" + exception.getMessage() + "</h1></body></html>");
    }

    public void showBadResponse(Socket s) throws IOException {
        String str = getStatusLine() + getHeaders() + getBodyMessage();
        s.getOutputStream().write(str.getBytes());
        s.getOutputStream().flush();
    }
}
