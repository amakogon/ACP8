package homework3.command;


import homework3.ICommand;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Razer on 13.09.15.
 */
public class HelpCommand implements ICommand {

    String name;

    public HelpCommand(String name) {
        this.name = name;
    }

    Set<ICommand> commands = new HashSet<>();

    public void setCommands(ICommand commands) {
        this.commands.add(commands);
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
