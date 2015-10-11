package homework5.chat_thread;

/**
 * Created by Razer on 05.10.15.
 */
public class Start {
    public static void main(String[] args) {
        Server server=new Server(5555);
        server.runServer();
    }
}
