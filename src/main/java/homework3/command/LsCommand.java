package homework3.command;


import homework3.CommandControl;
import homework3.ICommand;

import java.io.File;

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
                System.out.println(printFile(files));
                //System.out.println(Arrays.toString(files));
            } else {
                System.err.println(path + " No such file or directory");
            }

        } else {
            File directory = new File(path);
            File[] files = directory.listFiles();
            for (File file : files) {
                if (!file.isHidden()) {
                    System.out.println(file.getName());
                }
            }

        }
    }

    private String printFile(File[] files) {
        StringBuilder builder = new StringBuilder();
        for (File file : files) {
            if (!file.isHidden()) {
                builder.append(file);
            }
        }
        return builder.toString();
    }

    @Override
    public String toString() {
        return name +"";
    }
}