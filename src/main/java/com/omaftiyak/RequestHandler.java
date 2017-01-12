package com.omaftiyak;


public abstract class RequestHandler {

    public enum Methods {
        POST, GET, PUT, DELETE;
    }

    public Response handle(Request request) {
        if (request.getMethod().compareToIgnoreCase(Methods.GET.toString()) == 0)
            return Get(request);
        else return null;
    }

    public abstract Response Get(Request request);

    public abstract Response Post(Request request);

    public abstract Response Put(Request request);

    public abstract Response Delete(Request request);
}
