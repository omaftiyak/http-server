package com.omaftiyak;


import java.util.HashMap;

public class TestHandler extends RequestHandler {


    @Override
    public Response Get() {
        String s = "<html><body><h1>" + "Hello" + "</h1></body></html>";
        HashMap<String, String> headers = new HashMap<>();
        headers.put("Server", "YarServer/2009-09-09");
        headers.put("Content-Type", "text/html");
        headers.put("Content-Length:", Integer.toString(s.length()));
        headers.put("Connection", "close");
        return new Response("HTTP/1.1", "200 OK", headers, s);
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
