package com.omaftiyak;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class HttpServer {
    /*public static void writeBedResponce(Socket s, HttpException exception) throws IOException {
        String str = "HTTP/1.1 " + exception.getExeptionCode() + "\r\n" +
                "Server: YarServer/2009-09-09\r\n" +
                "Content-Type: text/html\r\n" +
                "Content-Length: " + exception.getMessage().length() + "\r\n" +
                "Connection: close\r\n\r\n" + exception.getMessage();
        s.getOutputStream().write(str.getBytes());
        s.getOutputStream().flush();
    }*/
    private static BadResponse br;

    public static void main(String[] args) throws IOException {
        ServerSocket ss;
        try {
            // todo low move port number to properties file
            ss = new ServerSocket(8080);
            while (true) {
                Socket s = null;
                try {
                    s = ss.accept();

                    try {
                        // todo low use java.util.concurrent.ExecutorService
                        new Thread(new SocketProcessor(s, new TestHandler())).start();
                    } catch (IOException e1) {
                        e1 = new HttpException(404, e1.getMessage());
                        br = new BadResponse((HttpException) e1);
                        br.showBadResponse(s);
                    }
                } catch (HttpException e) {
                    e = new HttpException(404, e.getMessage());
                    br = new BadResponse(e);
                    br.showBadResponse(s);
                }
            }
        } catch (HttpException e) {
            e.printStackTrace();
        }
    }
}
