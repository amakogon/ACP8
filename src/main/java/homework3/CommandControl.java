package homework3;

import homework3.command.CdCommand;
import homework3.command.HelpCommand;
import homework3.command.LsCommand;
import homework3.command.MkdirCommand;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

/**
 * Created by Razer on 17.09.15.
 */
public class CommandControl {

    public void init(){
        properties=new Properties();
        setCommands();
        readHomeDirectory();
    }

    private Properties properties;

    public ArrayList<ICommand> commands = new ArrayList<>();

    public static String localDirectory;

    private void readHomeDirectory() {
        String path = ClassLoader.getSystemResource("home").getPath();
        try {
            properties.load(new FileInputStream(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String homeDirectory = properties.getProperty("homeDirectory");
        CommandControl.localDirectory = homeDirectory;
    }

    private void setCommands() {
        HelpCommand help = new HelpCommand("help");
        MkdirCommand mkdir = new MkdirCommand("mkdir");
        LsCommand ls = new LsCommand("ls");
        CdCommand cd = new CdCommand("cd");
        commands.add(ls);
        commands.add(cd);
        commands.add(mkdir);
        commands.add(help);
    }

    @Override
    public String toString() {
        return "CommandControl{" +
                "commands=" + commands +
                '}';
    }
}
