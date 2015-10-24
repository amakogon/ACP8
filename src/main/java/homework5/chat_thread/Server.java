package homework5.chat_thread;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
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
    private Map<String, ServerSocket> clients;

    public void runServer() {
        clients = new HashMap<>();
        String name=null;
        try {
            serverSocket = new ServerSocket(5000);
            while (true) {
                Socket clientSock = serverSocket.accept();
                PrintWriter writer = new PrintWriter(clientSock.getOutputStream());
                writer.println("Connected to server!");
                writer.println("Enter your nickname:");
                clients.put(name,clientSock);
                Thread clientThread = new Thread(new ReadTask(clientSock));
                clientThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    }

    private boolean openConnection() {
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            socket=serverSocket.accept();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }
}

