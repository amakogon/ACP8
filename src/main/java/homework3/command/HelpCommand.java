package homework3.command;


import homework3.ICommand;

/**
 * Created by Razer on 13.09.15.
 */
public class HelpCommand implements ICommand {

    String name;

    public HelpCommand(String name) {
        this.name = name;
    }


    @Override
    public void execute(String param) {
        
    }

    @Override
    public String getName() {
        return name;
    }

}
