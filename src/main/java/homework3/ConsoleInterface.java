package homework3;

/**
 * Created by Razer on 16.09.15.
 */

import homework3.command.CdCommand;
import homework3.command.HelpCommand;
import homework3.command.LsCommand;
import homework3.command.MkdirCommand;

import java.util.Scanner;


/**
 * Created by Razer on 13.09.15.
 */
public class ConsoleInterface {

    CommandControl commandControl;

    public ConsoleInterface() {
        init();
    }

    private void init() {
        commandControl = new CommandControl();
        setCommand();
        commandControl.readHomeDirectory();
        while (true) {
            String command = readCommand();
            parseCommand(command);
        }
    }

    public String readCommand() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    private void setCommand() {
        HelpCommand help = new HelpCommand("help");
        MkdirCommand mkdir = new MkdirCommand("mkdir");
        LsCommand ls = new LsCommand("ls");
        CdCommand cd = new CdCommand("cd");
        commandControl.setCommands(ls);
        commandControl.setCommands(cd);
        commandControl.setCommands(mkdir);
        commandControl.setCommands(help);
    }


    public void parseCommand(String command) {
        String newCommand;
        String parametr = "";
        String[] parts = command.split(" ");
        newCommand = parts[0];
        if (parts.length > 1) {
            parametr = parts[1];
        }
        for (int i = 0; i < commandControl.commands.size(); i++) {
            if (commandControl.commands.get(i).getName().equals(newCommand)) {
                commandControl.commands.get(i).execute(parametr);
                break;
            }else {
                System.err.println(command+ " command not found");
            }

        }
    }

}





