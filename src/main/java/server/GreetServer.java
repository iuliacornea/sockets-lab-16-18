package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class GreetServer {
  ServerSocket myServer;

  public void start() throws IOException {
    myServer = new ServerSocket(7777);

    while (true) {
      Socket socketForClient = myServer.accept();
      new ClientHandler(socketForClient).start();
    }
  }

  public static void main(String[] args) throws IOException {
    GreetServer greetServer = new GreetServer();
    greetServer.start();
  }
}
