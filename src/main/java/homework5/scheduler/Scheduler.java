package homework5.scheduler;


/**
 * Created by Razer on 25.09.15.
 */

public class Scheduler implements Runnable {

    private long milisecond;
    private Task task;

    public Scheduler(long timer, Task task) {
        this.milisecond = timer;
        this.task = task;
    }

    @Override
    public void run() {
        Thread curr = Thread.currentThread();
        while (!curr.isInterrupted()) {
            task.action();
            try {
                curr.sleep(milisecond);
            } catch (InterruptedException e) {
                curr.interrupt();
            }


        }
    }
}
