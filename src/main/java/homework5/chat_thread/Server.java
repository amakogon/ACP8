package homework5.chat_thread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
    private Map<String, Socket> clients;


    public void runServer() {
        String name;
        System.out.println("Server started!");
        clients = new HashMap<>();
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
                System.out.println(name + " connected to the server");
                clients.put(name, clientSock);
                Thread clientThread = new Thread(new ClientThread(name));
                clientThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sendAll(String message, String name) {
        for (Socket s : clients.values()) {
            try {
                PrintWriter printWriter = new PrintWriter(s.getOutputStream());
                printWriter.write(name + ":" + message + "\n\r");
                printWriter.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private class ClientThread implements Runnable {
        BufferedReader reader;
        String name;

        public ClientThread(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            try {
                String message;
                reader = new BufferedReader(new InputStreamReader(clients.get(name).getInputStream()));
                while (true) {
                    if ((message = reader.readLine()) != null) {
                        sendAll(message, name);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}


