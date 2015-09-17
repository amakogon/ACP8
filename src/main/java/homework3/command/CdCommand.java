package homework3.command;

import homework3.ICommand;

/**
 * Created by Razer on 13.09.15.
 */
public class CdCommand implements ICommand {

    private String name;

    public CdCommand(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    @Override
    public void execute(String param) {

    }
}
