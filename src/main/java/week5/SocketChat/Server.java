package week5.SocketChat;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * .|\_/|,,_____,~~`
 * .(.".)~~     )`~}} Created by Juff
 * ..\o/\ /---~\\ ~}}
 * ...._//    _// ~}
 */
public class Server {

    public static HashMap<String, Socket> users = new HashMap<>();
    public static ArrayList<String> messagesList = new ArrayList<>();

    private int port;


    public Server(int port) {
        this.port = port;
    }

    public void start() throws IOException, InterruptedException {

        ServerSocket serverSocket = new ServerSocket(port);
        new ClientThread(serverSocket).start();
        new AllWriter(users.values()).start();


    }

    public static void sendAll(String msg) throws IOException {
        for (Socket s : users.values()) {
            try {
                PrintWriter printWriter = new PrintWriter(s.getOutputStream());
                printWriter.write(msg + "\n\r");
                printWriter.flush();
                System.out.println(msg + "\n\r");
            } catch (SocketException e){

            }

        }
    }


}
