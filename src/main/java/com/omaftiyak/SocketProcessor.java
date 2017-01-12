package com.omaftiyak;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;


public class SocketProcessor implements Runnable {

    private Socket socket;
    private RequestParser parser;
    private RequestHandler handler;

    public SocketProcessor(Socket s) {
        this.socket = s;
        this.parser = new RequestParser();
        this.handler = new TestHandler();
    }

    public void run() {
        InputStream is = null;
        OutputStream os = null;
        Response response;
        try {
            is = socket.getInputStream();
            os = socket.getOutputStream();
            response = handler.handle(parser.parse(is));
        } catch (HttpException e) {
            response = buildExceptionResponse(e);
        } catch (Exception e) {
            response = buildExceptionResponse(new HttpException(HttpError.SC_INTERNAL_SERVER_ERROR));
        }

        try {
            writeResponse(response, os);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.close(is);
            IOUtils.close(os);
            IOUtils.close(socket);
        }
        System.err.println("Client processing finished");
    }

    private void writeResponse(Response response, OutputStream os) throws IOException {
        PrintWriter printWriter = new PrintWriter(os);
        printWriter.print(response.getVersion());
        printWriter.print(response.getStatus());
        printWriter.print("\r\n");
        for (Map.Entry<String, String> entry : response.getHeaders().entrySet()) {
            printWriter.print(entry.getKey());
            printWriter.print(": ");
            printWriter.print(entry.getValue());
            printWriter.print("\r\n");
        }
        printWriter.print("\r\n");
        printWriter.flush();
        os.write(response.getBody());
    }

    private Response buildExceptionResponse(HttpException exception) {
        String s = "<html><body><h1>" + exception.getError().getMessage() + "</h1></body></html>";
        HashMap<String, String> headers = new HashMap<>();
        headers.put(HttpHeader.SERVER.toString(), "YarServer/2009-09-09");
        headers.put(HttpHeader.CONTENT_TYPE.toString(), "text/html");
        headers.put(HttpHeader.CONTENT_LENGTH.toString(), Integer.toString(s.length()));
        headers.put(HttpHeader.CONNECTION.toString(), "close");
        return new Response("HTTP/1.1", Integer.toString(exception.getError().getNumber()), headers, s.getBytes());
    }

}
