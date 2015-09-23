package ClassWork;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 * |\_/|,,_____,~~`
 * (.".)~~     )`~}} Created by Juff
 *  \o/\ /---~\\ ~}}
 *...._//    _// ~}
 */
public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 4321);
        Scanner scanner = new Scanner(socket.getInputStream());
        while (scanner.hasNextLine()){
            System.out.println(scanner.nextLine());
        }

    }
}
