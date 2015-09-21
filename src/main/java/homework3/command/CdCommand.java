package homework3.command;

import homework3.CommandControl;
import homework3.ICommand;

import java.io.File;

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
    public String toString() {
        return name +"";
    }

    @Override
    public void execute(String param) {
        if (param.length() == 0) {
            CommandControl.localDirectory = CommandControl.homeDirectory;
        } else if (param.equals("..")) {
           changeToLowerDirectory();
        }
        else if(param.length()>0){
            File file=new File(CommandControl.localDirectory+"/"+param);
            if (file.isDirectory()){
                CommandControl.localDirectory+="/"+param;
            }
            else {
                System.err.println("No such file or directory");
            }
        }

    }

    public void changeToLowerDirectory() {
        String path=CommandControl.localDirectory;
        int index = path.lastIndexOf("/");
        if (index>0){
        path = path.substring(0, index);
        }
        CommandControl.localDirectory=path;
    }
}
