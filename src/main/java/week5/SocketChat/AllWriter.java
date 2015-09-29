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
    private Collection<Socket> sockets;

    public AllWriter(Collection<Socket> sockets) {
        this.sockets = sockets;
    }

    @Override
    public void run() {
        try {

            while (!isInterrupted()) {

                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
                String s = bufferedReader.readLine()+"\n";
                Server.sendAll("[Server]: "+s);
                System.out.println("[Server]: "+s);


            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}