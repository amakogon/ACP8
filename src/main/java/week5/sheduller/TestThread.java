package week5.sheduller;

import javax.lang.model.element.NestingKind;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * .|\_/|,,_____,~~`
 * .(.".)~~     )`~}} Created by Juff
 * ..\o/\ /---~\\ ~}}
 * ...._//    _// ~}
 */
public class TestThread implements Runnable{

    @Override
    public void run() {
        System.out.println(new SimpleDateFormat("HH:mm:ss").format(new Date(System.currentTimeMillis()))+ " - test thread started!");
    }

}
