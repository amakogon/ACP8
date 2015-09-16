package homework3;

/**
 * Created by Razer on 16.09.15.
 */

import homework3.command.CdCommand;
import homework3.command.HelpCommand;
import homework3.command.LsCommand;

import java.util.Scanner;


/**
 * Created by Razer on 13.09.15.
 */
public class ConsoleInterface {

    CommandControl commandControl = new CommandControl();

    public ConsoleInterface() {
        init();
    }

    private void init() {
        String command = readCommand();
        parseCommand(command);
    }

    public String readCommand() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
    private void setCommand() {
        LsCommand ls=new LsCommand("ls");
        CdCommand cd=new CdCommand("cd");
        HelpCommand help=new HelpCommand("help");
        help.setCommands(ls);
        help.setCommands(cd);
        help.setCommands(help);

    }


    public void parseCommand(String command) {
        String[] parts = command.split(" ");
        String newCommand = parts[0];
        String parametr = parts[1];
        for (int i = 0; i < commandControl.commands.size(); i++) {
            {
//                if(commandControl.commands.get(i).getName().equals(newCommand)){
//
//                }

            }
        }
//        ICommand z = commandControl.commands.get(1);
//        //z.execute();
//        if (true) {
//            int index = commandControl.commands.indexOf(command);
//        } else {
//            System.err.println(command + " command not found");
    }
}


