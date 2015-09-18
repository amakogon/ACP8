package week3.command;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;


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
                String cmd = bufferedReader.readLine();
                if(cmd.equals("exit")){break;}
                reciever.executeCommand(cmd);

            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    }
}
