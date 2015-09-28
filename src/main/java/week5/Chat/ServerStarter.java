package week5.Chat;

import java.io.IOException;

/**
 * .|\_/|,,_____,~~`
 * .(.".)~~     )`~}} Created by Juff.
 * ..\o/\ /---~\\ ~}}
 * ... _//    _// ~}
 */
public class ServerStarter {


    public static void main(String[] args) throws IOException {
        Server server = new Server(1234);
        server.start();

    }
}
