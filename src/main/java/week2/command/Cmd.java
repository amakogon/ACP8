package week2.command;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * _|\_/|,,_____,~~`
 * _(.".)~~     )`~}} Created by Juff on $18.09.15
 * __\o/\ /---~\\ ~}}
 * ___ _//    _// ~}
 */

public class Cmd {



    public static void main(String[] args) {
        Reciever reciever = new Reciever();
        File currentDirectory = new File(System.getProperty("user.dir"));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String command;

        while (true) {
            System.out.print("\n[" + new SimpleDateFormat("HH:mm:ss", Locale.ENGLISH).format(System.currentTimeMillis()) + " " + System.getProperty("user.name") + "] " + currentDirectory + " $\r");
            try {
                command = bufferedReader.readLine();
                reciever.executeCommand(command);

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
