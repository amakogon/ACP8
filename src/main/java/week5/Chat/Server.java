package week5.Chat;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * .|\_/|,,_____,~~`
 * .(.".)~~     )`~}} Created by Juff.
 * ..\o/\ /---~\\ ~}}
 * ... _//    _// ~}
 */
public class Server {

    private int port;
    Thread serverThread;


    public Server(int port) {
        this.port = port;
    }

    public void start() throws IOException {
        serverThread = new Thread() {
            @Override
            public void run() {

                try {
                    ServerSocket serverSocket = new ServerSocket(port);
                    while (!isInterrupted()) {
                        Socket acceptedSocket = serverSocket.accept();
                        InputStream is = acceptedSocket.getInputStream();
                        OutputStream os = acceptedSocket.getOutputStream();


                        new inputThread(is).start();
                        new outputThread(os).start();
                    }
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };

        serverThread.start();


    }

    private class inputThread extends Thread {
        private InputStream is;

        public inputThread(InputStream is) {
            this.is = is;
        }

        @Override
        public void run() {
            while (!isInterrupted()) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(is));
                String s = null;
                try {
                    s = reader.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (s.equals("exit")) {
                    break;
                } else System.out.println(s);
            }
        }
    }

    private class outputThread extends Thread {
        private OutputStream os;

        public outputThread(OutputStream os) {
            this.os = os;
        }

        @Override
        public void run() {
            while (!isInterrupted()) {

                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                try {
                    String s = reader.readLine();
                    PrintWriter printWriter = new PrintWriter(os);
                    printWriter.write(s+"\n");
                    printWriter.flush();

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }


}


