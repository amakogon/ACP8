package week5.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
  public static void main(String[] args) throws IOException {
    ServerSocket serverSocket = new ServerSocket(4321);
    Socket acceptedSocket = serverSocket.accept();

    PrintWriter writer = new PrintWriter(acceptedSocket.getOutputStream());
    writer.write("Hello from server!");
    writer.flush();

    InputStream inputStream = acceptedSocket.getInputStream();
    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
    String message;

    Scanner scanner = new Scanner(System.in);
    while ((message = reader.readLine()) != null) {
      System.out.println("From client: " + message);

      String response = scanner.nextLine();
      writer.write(response);
      writer.flush();
    }
  }
}
