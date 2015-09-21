package homework3;

/**
 * Created by Razer on 16.09.15.
 */

import java.util.Scanner;


/**
 * Created by Razer on 13.09.15.
 */
public class ConsoleInterface {

    CommandControl commandControl;
    Scanner sc = new Scanner(System.in);

    public ConsoleInterface() {
        init();
    }

    private void init() {
        commandControl = new CommandControl();
        commandControl.init();
        boolean running = true;
        while (running) {
            String command = sc.nextLine();
            isExit(command);
            parseCommand(command);
        }
    }

    private void isExit(String command) {
        if (command.equals("exit")) {
            System.exit(0);
        }
    }


    public void parseCommand(String command) {
        boolean isCommand = false;
        String newCommand;
        String parametr = "";
        String[] parts = command.split(" ");
        newCommand = parts[0];
        if (parts.length > 1) {
            parametr = parts[1];
        }
        for (int i = 0; i < commandControl.getCommands().size(); i++) {
            if (commandControl.getCommands().get(i).getName().equals(newCommand)) {
                commandControl.getCommands().get(i).execute(parametr);
                isCommand = true;
                break;
            }
        }
        if (!isCommand) {
            System.err.println(command + " command not found");
        }
    }
}






