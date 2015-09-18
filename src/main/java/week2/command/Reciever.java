package week2.command;

import org.apache.commons.io.FileUtils;

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

    File currentDirectory = setCurrentDirectory(System.getProperty("user.dir"));
    String time = new SimpleDateFormat("HH:mm:ss", Locale.ENGLISH).format(System.currentTimeMillis());
    String userName = System.getProperty("user.name");
    String promt;
    String command;

    public File setCurrentDirectory(String currentDirectory) {
        this.currentDirectory = new File(currentDirectory);
        return new File(currentDirectory);
    }


    public void promt() {
        String promt = "\n[" + time + " " + userName + "] " + currentDirectory + " $";
        System.out.print(promt);
    }

    public void executeCommand(String command) {
        this.command = command;
        Commands commands = new Commands(promt, command);
        HashSet<String> commandsSet = commands.getCommands();
        String execCommend = command.split(" ")[0];
        if (commandsSet.contains(execCommend)) {
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
            commandList.put("mkdir", new Mkdir());
            commandList.put("rm", new Rm());
        }

        public HashSet<String> getCommands() {
            HashSet<String> commands = new HashSet<>();
            commands.addAll(commandList.keySet());
            return commands;
        }

        public abstract class ACommand {


            abstract void execute();

            abstract String help();

        }

        public class Ls extends ACommand {


            @Override
            void execute() {
                String[] splitedCommand = command.split(" ");
                if (splitedCommand.length == 1) {
                    for (String f : currentDirectory.list()) {
                        System.out.println(f);
                    }
                } else {
                    String targetDirectoryName = splitedCommand[1].trim();
                    if (!String.valueOf(targetDirectoryName.charAt(targetDirectoryName.length() - 1)).equals(File.separator)) {
                        targetDirectoryName = targetDirectoryName + File.separator;
                    }
                    File tergetDirectory = new File(targetDirectoryName);
                    if (tergetDirectory.isDirectory() && tergetDirectory.exists()) {
                        String[] fileList = tergetDirectory.list();
                        for (String f : fileList) {
                            System.out.println(f);
                        }
                    } else {
                        System.out.println("Wrong directory name!");
                    }
                }

            }

            @Override
            String help() {
                return null;
            }
        }

        public class Cd extends ACommand {

            @Override
            void execute() {
                String[] splitedCommand = command.split(" ");
                if (splitedCommand.length == 1) {
                    System.out.println("Input directory name!");
                } else {
                    String targetDirectoryName = splitedCommand[1].trim();
                    if (!String.valueOf(targetDirectoryName.charAt(targetDirectoryName.length() - 1)).equals(File.separator)) {
                        targetDirectoryName = targetDirectoryName + File.separator;
                    }
                    File tergetDirectory = new File(targetDirectoryName);

                    if (tergetDirectory.isDirectory() && tergetDirectory.exists()) {
                        try {
                            setCurrentDirectory(tergetDirectory.getCanonicalPath());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else {
                        System.out.println("Input directory name!");
                    }
                }
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
                    File f = new File(currentDirectory.getCanonicalPath() + File.separator + command.split(" ")[1]);
                    f.mkdirs();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            String help() {
                return null;
            }
        }

        public class Rm extends ACommand {
            @Override
            void execute() {
                String[] splitedCommand = command.split(" ");
                if (splitedCommand.length == 1) {
                    System.out.println("Can not remove current directory!");
                } else {
                    String targetDirectoryName = splitedCommand[1].trim();
                    if (!String.valueOf(targetDirectoryName.charAt(targetDirectoryName.length() - 1)).equals(File.separator)) {
                        targetDirectoryName = targetDirectoryName + File.separator;
                    }

                    File tergetDirectory = new File(targetDirectoryName);
                    if(tergetDirectory.exists()){
                    try {
                        if (tergetDirectory.isDirectory()) {
                            FileUtils.deleteDirectory(tergetDirectory);
                        } else {
                            FileUtils.forceDelete(tergetDirectory);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    }else {
                        System.out.println("No such file/directory");
                    }

                   /* if (tergetDirectory.isDirectory() && tergetDirectory.exists()) {
                        setCurrentDirectory(tergetDirectory);
                    } else {
                        System.out.println("Input directory name!");
                    }*/
                }

                /*try {
                    File f = new File(currentDirectory.getCanonicalPath() + File.separator + command.split(" ")[1]);
                    if (f.isDirectory()) {
                        FileUtils.deleteDirectory(f);
                    } else {
                        FileUtils.forceDelete(f);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }*/
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
