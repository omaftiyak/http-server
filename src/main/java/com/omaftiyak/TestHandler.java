package com.omaftiyak;


import java.util.HashMap;
import java.util.Map;

public class TestHandler extends RequestHandler {
    private Response buildResponse(Request request) {
        String requestHeaders = "";
        for (Map.Entry<String, String> entry : request.getHeaders().entrySet()) {
            requestHeaders = (entry.getKey() + ": " + entry.getValue() + "\r\n");
        }
        String s = "<html><body><h1>" + request.getMethod()
                + " " + request.getURL() + " " + request.getVersion() + requestHeaders + "</h1></body></html>";
        HashMap<String, String> headers = new HashMap<>();
        headers.put(HttpHeader.SERVER.toString(), "YarServer/2009-09-09");
        headers.put(HttpHeader.CONTENT_TYPE.toString(), "text/html");
        headers.put(HttpHeader.CONTENT_LENGTH.toString(), Integer.toString(s.length()));
        headers.put(HttpHeader.CONNECTION.toString(), "close");
        return new Response("HTTP/1.1", " 200 OK", headers, s.getBytes());
    }

    @Override
    public Response Get(Request request) {
        return buildResponse(request);
    }

    @Override
    public Response Post(Request request) {
        return buildResponse(request);
    }

    @Override
    public Response Put(Request request) {
        return buildResponse(request);
    }

    @Override
    public Response Delete(Request request) {
        return buildResponse(request);
    }
}
