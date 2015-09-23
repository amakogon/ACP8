package ClassWork;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * |\_/|,,_____,~~`
 * (.".)~~     )`~}} Created by Juff
 *  \o/\ /---~\\ ~}}
 *    _//    _// ~}
 */
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(4321);
        Socket acceptedSocket = serverSocket.accept();

        PrintWriter printWriter = new PrintWriter(acceptedSocket.getOutputStream());
        printWriter.write("Hello");
        printWriter.flush();

       /* InputStream inputStream = acceptedSocket.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String message;
        while ((message = reader.readLine()) != null) {
            System.out.println("From client: " + message);
        }
*/

    }
}
