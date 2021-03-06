package com.omaftiyak;

import java.io.IOException;
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
            Socket socket;
            try {
                socket = serverSocket.accept();
                // todo low use java.util.concurrent.ExecutorService instead of Thread
                new Thread(new SocketProcessor(socket)).start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        (new HttpServer()).start();
    }

}
