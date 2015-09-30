package homework5.scheduler;

/**
 * Created by Razer on 25.09.15.
 */
public class Start {
    public static void main(String[] args) {
        Scheduler scheduler = new Scheduler(5000, new Task());
        Thread th1 = new Thread(scheduler);
        th1.start();


        try {
            Thread.currentThread().sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        th1.interrupt();




    }
}
