package homework3.command;

import homework3.ICommand;

/**
 * Created by Razer on 13.09.15.
 */
public class CdCommand implements ICommand {

    public String getName() {
        return name;
    }

    private String name;

    public CdCommand(String name) {
        this.name = name;
    }

    @Override
    public void execute(String param) {

    }
}
