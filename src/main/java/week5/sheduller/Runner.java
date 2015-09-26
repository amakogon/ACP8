package week5.sheduller;

/**
 * .|\_/|,,_____,~~`
 * .(.".)~~     )`~}} Created by Juff
 * ..\o/\ /---~\\ ~}}
 * ...._//    _// ~}
 */
public class Runner {
    public static void main(String[] args) {
        new Thread(new Sheduller(new Thread(new TestThread()),3000)).start();
    }
}
