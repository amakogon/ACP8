package homework.homework5.scheduler;

/**
 * Created by Home on 25.09.2015.
 */
public class TestScheduler {
    public static void main(String[] args) {
        Scheduler myScheduler = new Scheduler();
        myScheduler.addTask(new Task1(), 5000);
        myScheduler.addTask(new Task2(), 3000);
    }
}
