package week5.sheduller;

/**
 * .|\_/|,,_____,~~`
 * .(.".)~~     )`~}} Created by Juff
 * ..\o/\ /---~\\ ~}}
 * ...._//    _// ~}
 */
public class Sheduller implements Runnable {

    Thread thread = new Thread();
    long period;

    public Sheduller(Thread thread, long period) {
        this.thread = thread;
        this.period = period;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            new Thread(thread).start();

            try {
                Thread.sleep(period);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
