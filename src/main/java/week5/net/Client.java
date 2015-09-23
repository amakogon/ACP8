package week5.net;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
  public static void main(String[] args) throws IOException {
    Socket socket = new Socket("localhost", 4321);
    Scanner scanner = new Scanner(socket.getInputStream());

    while (scanner.hasNextLine()) {
      System.out.println(scanner.nextLine());
    }
  }
}
