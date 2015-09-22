package ClassWork;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * |\_/|,,_____,~~`
 * (.".)~~     )`~}} Created by Juff
 * \o/\ /---~\\ ~}}
 * _//    _// ~}
 */
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(4321);
        Socket acceptedSocket = serverSocket.accept();

        PrintWriter printWriter = new PrintWriter(acceptedSocket.getOutputStream());
        printWriter.write("Hello, MF!");
        printWriter.flush();

    }
}
