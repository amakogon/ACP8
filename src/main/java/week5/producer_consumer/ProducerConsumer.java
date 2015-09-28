package week5.producer_consumer;

/**
 * .|\_/|,,_____,~~`
 * .(.".)~~     )`~}} Created by Juff
 * ..\o/\ /---~\\ ~}}
 * ...._//    _// ~}
 */
public class ProducerConsumer {

    private static final Object lock = new Object();
    private static int box = 0;
    private static int items = 100;


    public static void main(String[] args) throws InterruptedException {

        Thread producer = new Thread() {
            @Override
            public void run() {
                while (box ==0&&items>0&&!Thread.currentThread().isInterrupted())
                    synchronized (lock) {
                        lock.notifyAll();
                        box++;
                        System.out.println("Box status is = "+(box==0?"empty":"full"));
                        System.out.println("Items count = "+ items);
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
            }
        };

        producer.start();

        Thread consumer = new Thread() {
            @Override
            public void run() {
                while (box>=1&&!Thread.currentThread().isInterrupted()) {
                    synchronized (lock) {
                        lock.notifyAll();
                        items--;
                        box--;
                        System.out.println("Box status is = "+(box==0?"empty":"full"));
                        System.out.println("Items count = "+ items);
                        if(items==0&&box==0){
                            producer.interrupt();
                            this.interrupt();
                            break;
                        }
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        };

        consumer.start();

    }


}
