package week2.command;

import java.util.HashMap;

/**
 * Created by juff on 17.09.15.
 */
public class Reciever {

    String command;
    HashMap<String, Commands.ACommand> commands = new Commands(new Parser(command).parce()).getCommands();

    public void executeCommand(String command) {
        System.out.println();
        this.command = command;
        String[] parcedComand = new Parser(command).parce();
        command = parcedComand[0];
        if(commands.containsKey(command)){
           commands.get(command).execute(command);
        } else System.out.println("Invalid command, type \"help\" to get command list.");

    }


}
