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
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            reciever.promt();
            try {

                reciever.executeCommand(bufferedReader.readLine());

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
