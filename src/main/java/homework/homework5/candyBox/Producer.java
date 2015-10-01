package homework.homework5.candyBox;

/**
 * Created by Home on 01.10.2015.
 */
public class Producer {
    private CandyBox candyBox;
    private String name;

    public Producer(String name, CandyBox candyBox) {
        this.candyBox = candyBox;
        this.name = name;
    }

    public void putCandy() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    candyBox.put(name);
                    try {
                        Thread.currentThread().sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread.start();
    }
}
