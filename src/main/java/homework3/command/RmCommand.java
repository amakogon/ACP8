package homework3.command;

import homework3.ICommand;

/**
 * Created by Razer on 24.09.15.
 */
public class RmCommand implements ICommand {
    private String name;

    public RmCommand(String name) {
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