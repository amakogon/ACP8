package homework5.chat_thread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Razer on 05.10.15.
 */
public class Server {
    public Server(int port) {
        this.port = port;
    }

    private int port;
    private ServerSocket serverSocket;
    private Map<String, Socket> clients;

    public void runServer() {
        clients = new HashMap<>();
        String name;
        try {
            serverSocket = new ServerSocket(port);
            while (true) {
                Socket clientSock = serverSocket.accept();
                PrintWriter writer = new PrintWriter(clientSock.getOutputStream());
                BufferedReader reader = new BufferedReader(new InputStreamReader(clientSock.getInputStream()));
                writer.println("Connected to server!");
                writer.println("Enter your nickname:");
                writer.flush();
                name = reader.readLine();
                clients.put(name, clientSock);
                Thread clientThread = new Thread();
                clientThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sendAll(String message) {
        Iterator iter = clients.entrySet().iterator();
        while (iter.hasNext()) {
            PrintWriter writer = (PrintWriter) iter.next();
            writer.println(message);
            writer.flush();
        }
    }
}


