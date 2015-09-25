package homework5.scheduler;

/**
 * Created by Razer on 25.09.15.
 */
public class Start {
    public static void main(String[] args) {
        MyTask print=new MyTask();
        Scheduler scheduler = new Scheduler(print,1);
        scheduler.run();
    }
}
