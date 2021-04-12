package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler extends Thread {

  Socket socket;

  ClientHandler(Socket socketForClient) {
    this.socket = socketForClient;
  }

  @Override
  public void run() {
    BufferedReader in = null;
    PrintWriter out = null;
    try {
      in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
      out = new PrintWriter(socket.getOutputStream(), true);
    } catch (IOException ioException) {
      ioException.printStackTrace();
    }

    out.println("Greetings");
    String message;
    while (true) {
      try {
        message = in.readLine();
        sleep(500);
        if (message.equals("exit")) {
          break;
        }
        if ("Hi there stranger".equals(in.readLine())) {
          out.println("Hey you!");
          out.println("Hey you!");
        } else {
          out.println("I;m a dummy and only know how to greet :-D");
          out.println("I;m a dummy and only know how to greet :-D");
        }
      } catch (IOException | InterruptedException ioException) {
        ioException.printStackTrace();
      }

    }

    try {
      in.close();
      out.close();
      socket.close();
    } catch (IOException ioException) {
      ioException.printStackTrace();
    }

  }
}
