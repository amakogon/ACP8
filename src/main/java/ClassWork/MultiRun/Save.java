package ClassWork.MultiRun;
/**
 *.|\_/|,,_____,~~`
 *.(.".)~~     )`~}} Created by Juff
 *..\o/\ /---~\\ ~}}
 *...._//    _// ~}
 */

public class Save {
    private static  int safe = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread chel1 = new Thread(new Runnable() {
            int money = 700;

            @Override
            public void run() {
                while (money>0) {
                    try {
                        money--;
                        addToSafe();

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        });

        Thread chel2 = new Thread(new Runnable() {
            int money = 500;
            @Override
            public void run() {
                while (money>0) {
                    try {
                        money--;
                        addToSafe();

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        });

        Thread printSafe = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    printSafe();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });

        chel1.start();
        chel2.start();

        printSafe.join();
        printSafe.start();

    }

    public static synchronized void addToSafe() throws InterruptedException {
        safe++;

    }

    public static synchronized void takeFromSafe() throws InterruptedException {
        safe--;


    }

    public static void printSafe() throws InterruptedException {
        System.out.println(safe);

    }
}
