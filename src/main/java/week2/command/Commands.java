
package week2.command;


/**
 * _|\_/|,,_____,~~`
 * _(.".)~~     )`~}} Created by Juff on 17.09.15.
 * __\o/\ /---~\\ ~}}
 * ___ _//    _// ~}
 */

/*public class Commands {
    String promt;
    String command;

    public Commands(String promt, String command) {
        this.promt = promt;
        this.command = command;
    }

}*/
    /*Parser parser = new Parser();

    private HashMap<String, ACommand> commands = new HashMap<>();

    public Commands(String command, String promt) {
        this.promt=promt;
        this.command = command;

        commands.put("ls", new Ls(command));
        commands.put("cd", new Cd(command));
        commands.put("mkdir", new Mkdir(command));
        commands.put("rm", new Rm(command));
        commands.put("cat", new Cat(command));
        commands.put("help", new Help(command));

    }

    public String[] parseCommand(String s) {
        return new Parser().parceCommand(s);
    }

    public HashMap<String, ACommand> getCommands() {
        return commands;
    }

    public interface Command {
        void execute(String params);

        String help();
    }

    public abstract class ACommand implements Command {
        String command;

        public ACommand(String command) {
            this.command = command;
        }

    }


    public class Ls extends ACommand {

        public Ls(String[] command) {
            super(command);
        }


        @Override
        public void execute(String params) {
            String[] args = parseCommand(params);
            String promt = args[0];
            String arguments = args[1];
            String[] commandWithArguments = parser.parceCommandWithArgs(arguments);

            String currentDirectory = promt.split("\\] ")[1].trim();
            File directory = new File(currentDirectory);
            if (commandWithArguments.length == 2) {

                String[] fileList = directory.list();
                for (String f : fileList) {
                    System.out.println(f);
                }
            } else if (commandWithArguments.length > 2) {
                directory = new File(commandWithArguments[2]);
                String[] fileList = directory.list();
                for (String f : fileList) {
                    System.out.println(f);
                }
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
*/



