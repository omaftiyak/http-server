package com.omaftiyak;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.HashMap;


public class SocketProcessor implements Runnable {

    private Socket socket;
    private RequestParser parser;
    private RequestHandler handler;

    public SocketProcessor(Socket s) {
        this.socket = s;
        parser = new RequestParser();
        this.handler = new TestHandler();
    }

    public void run() {
        InputStream is = null;
        OutputStream os = null;
        Response response ;
        try {
            is = socket.getInputStream();
            os = socket.getOutputStream();
            response = handler.handle(parser.parse(is), os);

        } catch (HttpException e) {
            //???
            response = buildExceptionResponse(new HttpException(404, e.getMessage()));
        } catch (IOException e1) {
            //???
            response = buildExceptionResponse(new HttpException(500, e1.getMessage()));
        }

        try {
            writeResponse(response.toString(), os);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.close(is);
            IOUtils.close(os);
            IOUtils.close(socket);
        }
        System.err.println("Client processing finished");
    }


    private void writeResponse(String s, OutputStream os) throws IOException {
        os.write(s.getBytes());
        os.flush();
    }

    private Response buildExceptionResponse(HttpException exception) {
        String s = "<html><body><h1>" + exception.getMessage() + "</h1></body></html>";
        HashMap<String, String> headers = new HashMap<>();
        headers.put("Server", "YarServer/2009-09-09");
        headers.put("Content-Type", "text/html");
        headers.put("Content-Length:", Integer.toString(s.length()));
        headers.put("Connection", "close");
        return new Response("HTTP/1.1", Integer.toString(exception.getExeptionCode()), headers, s);
    }


}


