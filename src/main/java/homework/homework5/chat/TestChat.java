package homework.homework5.chat;

/**
 * Created by Home on 02.10.2015.
 */
public class TestChat {
    public static void main(String[] args) {

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                ChatServer chatServer = new ChatServer();
                chatServer.go();
            }
        });
        thread1.start();

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                ChatClient client1 = new ChatClient();
            }
        });
        thread2.start();
    }
}
