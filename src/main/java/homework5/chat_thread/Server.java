package homework5.chat_thread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

/**
 * Created by Razer on 05.10.15.
 */
public class Server {
    public Server(int port) {
        this.port = port;
    }
    private int port;
    private Socket socket;
    private HashMap<String,Client> clients;

    public void runServer() {
        if (openConnection()) {

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

