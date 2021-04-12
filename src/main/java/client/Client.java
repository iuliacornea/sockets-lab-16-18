package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
  Socket socket;
  BufferedReader in;
  PrintWriter out;

  public void connect() throws IOException {
    socket = new Socket("127.0.0.1", 7777);
    in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    out = new PrintWriter(socket.getOutputStream(), true);

  }

  public String communicate() throws IOException {
    String fromServer = in.readLine();
    System.out.println(fromServer);
    if ("Greetings".equals(fromServer)) {
      out.println("Hi there stranger");
    } else {
      out.println("Why no greet me? You have no manners!!!!");
    }
    fromServer = in.readLine();
    System.out.println(fromServer);
    if ("Greetings".equals(fromServer)) {
      out.println("Hi there stranger");
    } else {
      out.println("Why no greet me? You have no manners!!!!");
    }
    return fromServer;
  }

  public void disconnect() throws IOException {
    in.close();
    out.close();
    socket.close();
  }
}
