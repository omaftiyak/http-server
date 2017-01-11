package com.omaftiyak;


import java.util.Map;

public class Response {

    private String version;
    private String status;
    private Map<String, String> headers;
    private byte[] body;

    public Response(String version, String status, Map<String, String> headers, byte[] body) {
        this.version = version;
        this.status = status;
        this.body = body;
        this.headers = headers;
    }

    public byte[] getBody() {
        return body;
    }

    public void setBody(byte[] body) {
        this.body = body;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
