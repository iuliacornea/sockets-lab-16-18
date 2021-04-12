package client;

import java.io.IOException;

public class RunClient {

  public static void main(String[] args) throws IOException {
    Client myFirstClient = new Client();
    myFirstClient.connect();
    String fromServer = myFirstClient.communicate();
    String fromServer2 = myFirstClient.communicate();
  }
}
