
package week2.command;

<<<<<<< HEAD
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.io.DirectoryWalker;
=======
>>>>>>> 69374e91f771c8bf021380e57b2cd23c1421e99d

import java.util.HashMap;

/**
 * _|\_/|,,_____,~~`
 * _(.".)~~     )`~}} Created by Juff on 17.09.15.
 * __\o/\ /---~\\ ~}}
 * ___ _//    _// ~}
 */

public class Commands {
<<<<<<< HEAD
  DirectoryWalker
=======
    String[] command;

    private HashMap<String, ACommand> commands = new HashMap<>();

    public Commands(String[] command) {
        this.command = command;

        commands.put("ls", new Ls(command));
        commands.put("cd", new Cd(command));
        commands.put("mkdir", new Mkdir(command));
        commands.put("rm", new Rm(command));
        commands.put("cat", new Cat(command));
        commands.put("help", new Help(command));
>>>>>>> 69374e91f771c8bf021380e57b2cd23c1421e99d

    }

    public String[] parse(String s){
        return new Parser(s).parce();
    }

    public HashMap<String, ACommand> getCommands() {
        return commands;
    }

    public interface Command {
        void execute(String params);
        String help();
    }

    public abstract class ACommand implements Command {
        String[] command;

        public ACommand(String[] command) {
            this.command = command;
        }

    }

    public class Ls extends ACommand {

        public Ls(String[] command) {
            super(command);
        }


        @Override
        public void execute(String params) {
            String[] args = parse(params);
            if(args.length==1){
                    
            }

        }

        @Override
        public String help() {
            return "Show list of files in current directory.\nUsage:\nls\n ls /directory";
        }

    }

    public class Cd extends ACommand {

        public Cd(String[] command) {
            super(command);
        }

        @Override
        public void execute(String params) {

        }

        @Override
        public String help() {
            return null;
        }
    }

    public class Mkdir extends ACommand {

        public Mkdir(String[] command) {
            super(command);
        }

        @Override
        public void execute(String params) {

        }

        @Override
        public String help() {
            return null;
        }
    }

    public class Rm extends ACommand {

        public Rm(String[] command) {
            super(command);
        }

        @Override
        public void execute(String params) {

        }

        @Override
        public String help() {
            return null;
        }
    }

    public class Cat extends ACommand {

        public Cat(String[] command) {
            super(command);
        }

        @Override
        public void execute(String params) {

        }

        @Override
        public String help() {
            return null;
        }
    }

    public class Help extends ACommand {

        public Help(String[] command) {
            super(command);
        }

        @Override
        public void execute(String params) {

        }

        @Override
        public String help() {
            return "";
        }
    }


}

