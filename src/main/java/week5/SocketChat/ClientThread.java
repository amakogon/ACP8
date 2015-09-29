package week5.SocketChat;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * .|\_/|,,_____,~~`
 * .(.".)~~     )`~}} Created by Juff
 * ..\o/\ /---~\\ ~}}
 * ...._//    _// ~}
 */
public class ClientThread extends Thread {
    private ServerSocket serverSocket;

    public ClientThread(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    @Override
    public void run() {
        while (!isInterrupted()) {
            Socket acceptedSocket;
            try {
                acceptedSocket = serverSocket.accept();
                PrintWriter writer = new PrintWriter(acceptedSocket.getOutputStream());
                writer.write("Enter your nickname!\n");
                writer.flush();
                InputStream is = acceptedSocket.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));
                String name = bufferedReader.readLine();
                Server.users.put(name, acceptedSocket);
                String prompt = "[Server]: Joined " + name + "!";


                for (String m : Server.messagesList) {
                    writer.write(m + "\n");
                    writer.flush();
                }
                Server.sendAll(prompt);
                System.out.println(prompt);
                Server.messagesList.add(prompt);

                new Thread(){
                    String msg="";
                    @Override

                    public void run() {
                        while (!msg.equals("exit")){
                            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));

                            try {
                                msg = bufferedReader.readLine();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            System.out.println("["+name+"]" + ": " + msg);
                            Server.messagesList.add("["+name+"]" + ": " + msg);
                            try {
                                Server.sendAll("["+name+"]" + ": " + msg);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }.start();






            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
