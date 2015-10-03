package homework.homework5.chat;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Home on 02.10.2015.
 */
public class ChatServer {
    private ServerSocket serverSocket;
    private ArrayList clientsWriters;
    private StringBuilder messageHistory = new StringBuilder();

    public void go() {
        clientsWriters = new ArrayList();
        try {
            serverSocket = new ServerSocket(5000);
            while (true) {
                Socket clientSock = serverSocket.accept();
                PrintWriter writer = new PrintWriter(clientSock.getOutputStream());
                clientsWriters.add(writer);
                writer.println("Hello from server!");
                Thread clientThread = new Thread(new ReadTask(clientSock));
                clientThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public class ReadTask implements Runnable {
        private Socket clientSock;
        private BufferedReader reader;
        private String message;

        public ReadTask(Socket clientSock) {
            this.clientSock = clientSock;
        }

        public void readFromClient() {
            try {
                reader = new BufferedReader(new InputStreamReader(clientSock.getInputStream()));
                while (true) {
                    if ((message = reader.readLine()) != null) {
                        sendAllClients(message);
                        messageHistory.append(message);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            readFromClient();
        }
    }

    private void sendAllClients(String message) {
        Iterator iter = clientsWriters.iterator();
        while (iter.hasNext()) {
            PrintWriter writer = (PrintWriter) iter.next();
            writer.println(message);
            writer.flush();
        }
    }

}
