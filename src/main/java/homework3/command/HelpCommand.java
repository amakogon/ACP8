package homework3.command;


import homework3.ICommand;

import java.util.ArrayList;

/**
 * Created by Razer on 13.09.15.
 */
public class HelpCommand implements ICommand {

    String name;

    public ArrayList<ICommand> commands = new ArrayList<>();

    public HelpCommand(String name) {
        this.name = name;
    }


    @Override
    public void execute(String param) {
        System.out.println(commands.toString());
    }

    @Override
    public String getName() {
        return name;
    }

}
