package homework5.test;

/**
 * Created by Razer on 07.10.15.
 */
public class Start {
    public static void main(String[] args) {
        //Print print=new Print();
        Thread t1=new Thread(new Print());
        t1.start();
        System.out.println("main");
        Thread t2=new Thread(new Print());
        t2.start();
        Object test= new String("c");
        Object test2=new String("c");
        System.out.println(test==test2);
//        String name="a";
//        char character = name.charAt(0);
//        int ascii = (int) character;
//        System.out.println(ascii);
    }
}
