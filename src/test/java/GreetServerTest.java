import client.Client;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class GreetServerTest {

  @Test
  public void testGreetings() throws IOException {
    Client myFirstClient = new Client();
    myFirstClient.connect();
    String fromServer = myFirstClient.communicate();
    assertEquals("Greetings", fromServer);
  }


  @Test
  public void testGreetingsSecondTime() throws IOException {
    client.Client mySecondClient = new client.Client();
    mySecondClient.connect();
    String fromServer = mySecondClient.communicate();

    assertEquals("Greetings", fromServer);
  }
}
