package week5.SocketChat;

import java.io.*;
import java.net.Socket;
import java.util.Collection;

/**
 * .|\_/|,,_____,~~`
 * .(.".)~~     )`~}} Created by Juff
 * ..\o/\ /---~\\ ~}}
 * ...._//    _// ~}
 */
public class AllWriter extends Thread {

    public AllWriter(Collection<Socket> sockets) {
        Collection<Socket> sockets1 = sockets;
    }

    @Override
    public void run() {
        try {

            while (!isInterrupted()) {

                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
                String s = bufferedReader.readLine() + "\n\r";
                Server.sendAll("[Server]: " + s);
                System.out.println("[Server]: " + s);


            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}