package week5.Chat;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * .|\_/|,,_____,~~`
 * .(.".)~~     )`~}} Created by Juff.
 * ..\o/\ /---~\\ ~}}
 * ... _//    _// ~}
 */
public class Client {

    String ip;
    int port;

    public Client(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }

    public void start() throws IOException {

        Socket socket = new Socket(ip,port);
        InputStream is = socket.getInputStream();
        while (is.available()>0){
            System.out.print((char)is.read());
        }
        is.close();
    }
}
