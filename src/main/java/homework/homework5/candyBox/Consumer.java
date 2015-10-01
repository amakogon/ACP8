package homework.homework5.candyBox;

import java.util.ArrayList;

/**
 * Created by Home on 01.10.2015.
 */
public class Consumer {
    private CandyBox candyBox;
    private String name;
    private ArrayList pocket = new ArrayList<Integer>();

    public Consumer(String name, CandyBox candyBox) {
        this.candyBox = candyBox;
        this.name = name;
    }

    public void getCandy() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    pocket.add(candyBox.get(name));
                    try {
                        Thread.currentThread().sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread.start();
    }
}
