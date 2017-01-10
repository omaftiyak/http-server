package com.omaftiyak;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;

public class Request {

    private String method;
    private String URL;
    private String version;
    //todo low map<String,Collection>
    private Map<String, String> headers;
    private BufferedReader body;

    public Request(String method, String URL, String version, Map<String, String> headers, BufferedReader body) {
        this.method = method;
        this.URL = URL;
        this.version = version;
        this.headers = headers;
        this.body = body;

    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public BufferedReader getBody() {
        return body;
    }

    public void setBody(BufferedReader body) {
        this.body = body;
    }

}
