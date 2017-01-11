package com.omaftiyak;


import java.io.IOException;
import java.io.OutputStream;

public abstract class RequestHandler {

    private final String POST = "Post";
    private final String GET = "Get";
    private final String PUT = "Put";
    private final String DELETE = "Delete";
    //todo забрати поля
    //todo використовувати енами для констант http
    //todo i для хідерів
    protected Request request;
    protected OutputStream os;

    public void setParameters(Request request,OutputStream os) {
        this.request = request;
        this.os = os;
    }

    public Response handle(Request request,OutputStream os) {
        setParameters(request, os);
        if (this.request.getMethod().compareToIgnoreCase(GET)==0)
            return Get();
        else return null;
      /*  switch (this.request.getMethod()) {
            case POST:
                return Post();
            case GET:
                return Get();
            case DELETE:
                return Delete();
            case PUT:
                return Put();
            default:
                return null;
        }*/
    }

    public abstract Response Get() ;

    public abstract Response Post();

    public abstract Response Put();

    public abstract Response Delete();
}
