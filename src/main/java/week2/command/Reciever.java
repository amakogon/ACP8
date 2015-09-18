package week2.command;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;

/**
 * _|\_/|,,_____,~~`
 * _(.".)~~     )`~}} Created by Juff on $18.09.15
 * __\o/\ /---~\\ ~}}
 * ___ _//    _// ~}
 */
public class Reciever {

    File currentDirectory = setCurrentDirectory(new File(System.getProperty("user.dir")));
    String time = new SimpleDateFormat("HH:mm:ss", Locale.ENGLISH).format(System.currentTimeMillis());
    String userName = System.getProperty("user.name");
    String promt;
    String command;

    public File setCurrentDirectory(File currentDirectory) {
        this.currentDirectory = currentDirectory;
        return currentDirectory;
    }



    public void promt(){
        String promt = "\n[" +time+ " " + userName + "] " + currentDirectory + " $";
        System.out.print(promt);
    }

    public void executeCommand(String command) {
        this.command = command;
        Commands commands = new Commands(promt,command);
        HashSet<String> commandsSet = commands.getCommands();
        String execCommend = command.split(" ")[0];
        if(commandsSet.contains(execCommend)){
            commands.commandList.get(execCommend).execute();
        }


    }

    private class Commands {
        String promt;
        String command;
        public HashMap<String, ACommand> commandList = new HashMap<>();


        public Commands(String promt, String command) {
            this.promt = promt;
            this.command = command;
            commandList.put("ls", new Ls());
            commandList.put("cd", new Cd());
            commandList.put("mkdir", new Mkdir());}

        public HashSet<String> getCommands() {
            HashSet<String> commands = new HashSet<>();
            commands.addAll(commandList.keySet());
            return commands;
        }

        public abstract class ACommand {


            abstract void execute();

            abstract String help();

        }

        public class Ls extends ACommand{


            @Override
            void execute() {
                String[] fileList = currentDirectory.list();
                for(String f: fileList){
                    System.out.println(f);
                }
            }

            @Override
            String help() {
                return null;
            }
        }

        public class Cd extends ACommand{


            @Override
            void execute() {
                setCurrentDirectory(new File(command.split(" ")[1]));
            }

            @Override
            String help() {
                return null;
            }
        }

        public class Mkdir extends ACommand {
            @Override
            void execute() {
                try {
                    System.out.println(currentDirectory.getCanonicalPath());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                /*try {
                    File f = new File(currentDirectory.getCanonicalPath()+command.split(" ")[1]);
                } catch (IOException e) {
                    e.printStackTrace();
                }*/
            }

            @Override
            String help() {
                return null;
            }
        }
        public class Rm extends ACommand {
            @Override
            void execute() {

            }

            @Override
            String help() {
                return null;
            }
        }
        public class Cat extends ACommand {
            @Override
            void execute() {

            }

            @Override
            String help() {
                return null;
            }
        }
        public class Help extends ACommand {
            @Override
            void execute() {

            }

            @Override
            String help() {
                return null;
            }
        }
    }

}
