package homework.homework5.candyBox;

/**
 * Created by Home on 01.10.2015.
 */
public class CandyBox {
    private boolean isCandyInBox = false;

    public synchronized int get(String name) {
        while (isCandyInBox == false) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        isCandyInBox = false;
        System.out.printf("%s : I GOT CANDY.\n", name);
        this.notifyAll();
        return 1;
    }

    public synchronized void put(String name) {
        while (isCandyInBox == true) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        isCandyInBox = true;
        System.out.printf("%s : I put Candy.\n", name);
        this.notifyAll();
    }
}
