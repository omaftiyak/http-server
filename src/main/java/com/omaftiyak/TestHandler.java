package com.omaftiyak;


import java.io.IOException;
import java.io.OutputStream;

public class TestHandler extends RequestHandler {



    @Override
    public Response Get() {
        String s ="<html><body><h1>" + "Hello" + "</h1></body></html>";
        Response r = new Response("HTTP/1.1 200 OK\r\n", "Server: YarServer/2009-09-09\r\n" +
                "Content-Type: text/html\r\n" +
                "Content-Length: " + s.length() + "\r\n" +
                "Connection: close\r\n\r\n",s);
        return r;
    }

    @Override
    public Response Post() {
        return null;
    }

    @Override
    public Response Put() {
        return null;
    }

    @Override
    public Response Delete() {
        return null;
    }
}
