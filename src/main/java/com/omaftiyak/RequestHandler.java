package com.omaftiyak;


public abstract class RequestHandler {

    public enum Methods {
        POST, GET, PUT, DELETE
    }

    public Response handle(Request request) {
        if (request.getMethod().compareToIgnoreCase(Methods.GET.toString()) == 0)
            return Get(request);
        else if (request.getMethod().compareToIgnoreCase(Methods.PUT.toString()) == 0)
            return Put(request);
        else if (request.getMethod().compareToIgnoreCase(Methods.POST.toString()) == 0)
            return Post(request);
        else if (request.getMethod().compareToIgnoreCase(Methods.DELETE.toString()) == 0)
            return Delete(request);
        else return null;
    }

    public abstract Response Get(Request request);

    public abstract Response Post(Request request);

    public abstract Response Put(Request request);

    public abstract Response Delete(Request request);
}
