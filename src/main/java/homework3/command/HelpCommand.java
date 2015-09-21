package homework3.command;


import homework3.CommandControl;
import homework3.ICommand;

/**
 * Created by Razer on 13.09.15.
 */
public class HelpCommand implements ICommand {

    String name;
    CommandControl commandControl;

    public HelpCommand(String name, CommandControl commandControl)
    {
        this.commandControl = commandControl;
        this.name = name;
    }


    @Override
    public void execute(String param) {
        System.out.println(commandControl.toString());
    }

    @Override
    public String getName() {
        return name;
    }
    @Override
    public String toString() {
        return name+ "";
    }
}
