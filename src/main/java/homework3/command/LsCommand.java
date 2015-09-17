package homework3.command;


import homework3.CommandControl;
import homework3.ICommand;

import java.io.File;
import java.util.Arrays;

/**
 * Created by Razer on 13.09.15.
 */
public class LsCommand implements ICommand {

    private String name;

    public String getName() {
        return name;
    }

    public LsCommand(String name) {
        this.name = name;
    }


    @Override
    public void execute(String param) {
        String path = CommandControl.localDirectory;
        if (param.length() > 0) {
            path = path.concat("/" + param);
            File directory = new File(path);
            if (directory.isDirectory()) {
                File[] files = directory.listFiles();
                CommandControl.localDirectory = path;
                System.out.println(Arrays.toString(files));
            } else {
                System.err.println(path + " No such file or directory");
            }

        } else {
            File directory = new File(path);
            File[] files = directory.listFiles();
            System.out.println(Arrays.toString(files));

        }
    }

}
