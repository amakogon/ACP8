package homework3;



import homework3.command.CdCommand;
import homework3.command.HelpCommand;
import homework3.command.LsCommand;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Razer on 13.09.15.
 */
public class CommandControl {
    public static final String HOME_DIRECTORY = "/Users/johnsmith";

    //ArrayList<ICommand> commands = new ArrayList<>();

    Set<ICommand> commands=new HashSet<>();

    public CommandControl() {
        setCommand();
    }

    @Override
    public String toString() {
        return "CommandControl{" +
                "commands=" + commands +
                '}';
    }

    private void setCommand() {
        LsCommand ls=new LsCommand("ls");
        CdCommand cd=new CdCommand("cd");
        HelpCommand help=new HelpCommand("help");
        commands.add(ls);
        commands.add(cd);
    }

    private void perform(ICommand command){
        //command.execute();
    }
}
