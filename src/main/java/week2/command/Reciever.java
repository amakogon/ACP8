package week2.command;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * _|\_/|,,_____,~~`
 * _(.".)~~     )`~}} Created by Juff on $18.09.15
 * __\o/\ /---~\\ ~}}
 * ___ _//    _// ~}
 */
public class Reciever {

    File currentDirectory = new File(System.getProperty("user.dir"));
    String promt = "\n[" + new SimpleDateFormat("HH:mm:ss", Locale.ENGLISH).format(System.currentTimeMillis()) + " " + System.getProperty("user.name") + "] " + currentDirectory + " $";
    String command;

    public void promt(){
        System.out.print(promt);
    }
    public void executeCommand(String command) {
        this.command = command;
        Commands commands = new Commands(promt,command);

    }

    private class Commands {
        String promt;
        String command;

        public Commands(String promt, String command) {
            this.promt = promt;
            this.command = command;
        }
    }

}
