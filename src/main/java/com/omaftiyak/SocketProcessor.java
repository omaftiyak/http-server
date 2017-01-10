package com.omaftiyak;

import com.omaftiyak.parsers.RequestParser;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;


public class SocketProcessor implements Runnable {

    private Socket s;
    private InputStream is;
    private OutputStream os;
    private RequestParser parser;
    private RequestHandler handler;
    private BadResponse br;

    public SocketProcessor(Socket s, RequestHandler handler) throws IOException {
        this.s = s;
        this.is = s.getInputStream();
        this.os = s.getOutputStream();
        parser = new RequestParser();
        this.handler = handler;
    }

    public void run() {

        Response response = null;
        try {
            response = handler.handle(parser.parse(this.s), os);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            writeResponse(response.toString());
        } catch (IOException e) {

            try {
                e =new HttpException(404, e.getMessage());
                br = new BadResponse((HttpException) e);
                br.showBadResponse(s);
            } catch (Exception e1) {
                e1.printStackTrace();
            }

        } finally {

            try {
                s.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        System.err.println("Client processing finished");
    }


    private void writeResponse(String s) throws IOException {
        os.write(s.getBytes());
        os.flush();
    }


}


