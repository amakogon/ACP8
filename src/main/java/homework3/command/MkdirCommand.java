package homework3.command;


import homework3.CommandControl;
import homework3.ICommand;

import java.io.File;

/**
 * Created by Razer on 13.09.15.
 */
public class MkdirCommand implements ICommand {

    private String name;

    public MkdirCommand(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void execute(String param) {

    }
}
