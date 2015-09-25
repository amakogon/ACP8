package homework.homework5.scheduler;

/**
 * Created by Home on 25.09.2015.
 */
public class Scheduler<T extends ITask> {

    public void addTask (T task, long time) {
        Thread thread = new Thread() {
            @Override
            public void run() {
                while (true) {
                    task.execute();
                    try {
                        System.out.println("I'm sleeping.");
                        Thread.sleep(time);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        thread.start();
    }

}
