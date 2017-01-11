package com.omaftiyak;


import java.util.Map;

public class Response {
    private String version;
    private String status;
    private Map<String, String> headers;
    private String bodyMessage;

    @Override
    public String toString() {
        String headers = "";
        for (Map.Entry<String, String> entry : this.headers.entrySet()) {
            headers += entry.getKey() + ":\\s" + entry.getValue() + "\r\n";
        }
        return version + status + "\r\n"
                + headers+"\r\n"
                + bodyMessage;
    }

    public Response(String version, String status, Map<String, String> headers, String bodyMessage) {
        this.version = version;
        this.status = status;
        this.bodyMessage = bodyMessage;
        this.headers = headers;
    }

    public String getBodyMessage() {
        return bodyMessage;
    }

    public void setBodyMessage(String bodyMessage) {
        this.bodyMessage = bodyMessage;
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
