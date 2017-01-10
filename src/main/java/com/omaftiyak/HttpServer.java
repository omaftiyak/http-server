package com.omaftiyak;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class HttpServer {

    private int port;

    public HttpServer() {
        // todo low move port number to properties file
        port = 8080;
    }

    private void start() {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            listen(serverSocket);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    private void listen(ServerSocket serverSocket) {
        while (true) {
            Socket socket = null;
            InputStream is = null;
            OutputStream os = null;
            try {
                socket = serverSocket.accept();
                is = socket.getInputStream();
                os = socket.getOutputStream();
                // todo low use java.util.concurrent.ExecutorService instead of Thread
                new Thread(new SocketProcessor(socket, is, os)).start();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                IOUtils.close(socket);
                IOUtils.close(is);
                IOUtils.close(os);
            }
        }
    }

    public static void main(String[] args) {
        new HttpServer().start();
    }

}
