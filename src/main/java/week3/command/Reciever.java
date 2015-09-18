package week3.command;

import org.apache.commons.io.FileUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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
    String postfix=(userName.equals("root")?"#":"$");

    public File setCurrentDirectory(String currentDirectory) {
        this.currentDirectory = new File(currentDirectory);
        return new File(currentDirectory);
    }


    public void promt() {
        String promt = "\n[" + time + " " + userName + "] " + currentDirectory + File.separator + postfix;
        System.out.print(promt);
    }

    public void executeCommand(String command) {
        this.command = command;
        Commands commands = new Commands(promt, command);
        HashSet<String> commandsSet = commands.getCommands();
        String execCommend = command.split(" ")[0];
        if (commandsSet.contains(execCommend)) {
            commands.commandList.get(execCommend).execute();
        }else System.out.println("Unknown command. Try [help]!");


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
            commandList.put("cat", new Cat());
            commandList.put("help", new Help());
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
                    File targetDirectory = new File(currentDirectory+File.separator+targetDirectoryName);
                    if (targetDirectory.isDirectory() && targetDirectory.exists()) {
                        String[] fileList = targetDirectory.list();
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

                return "\n[ls] command use to get directory list." +
                        "\nUsage:" +
                        "\nls ↲" +
                        "\nls DIRECTORY ↲";
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
                    if (!targetDirectoryName.contains(File.separator)) {
                        targetDirectoryName = currentDirectory + File.separator + targetDirectoryName;
                    }
                    if (!String.valueOf(targetDirectoryName.charAt(targetDirectoryName.length() - 1)).equals(File.separator)) {
                        targetDirectoryName = targetDirectoryName + File.separator;
                    }
                    File targetDirectory = new File(targetDirectoryName);

                    if (targetDirectory.isDirectory() && targetDirectory.exists()) {
                        try {
                            setCurrentDirectory(targetDirectory.getCanonicalPath());
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
                return "\n[cd] command use to set current directory." +
                        "\nUsage:" +
                        "\ncd DIRECTORY ↲";
            }
        }

        public class Mkdir extends ACommand {
            @Override
            void execute() {

                String[] splitedCommand = command.split(" ");
                if (splitedCommand.length == 1) {
                    System.out.println("Input directory name!");
                } else {
                    String targetDirectoryName = splitedCommand[1].trim();
                    if (!targetDirectoryName.contains(File.separator)) {

                        try {
                            File targetDirectory = new File(currentDirectory + File.separator + targetDirectoryName);
                            System.out.println(targetDirectory.getCanonicalPath());
                            FileUtils.forceMkdir(targetDirectory);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else {
                        File targetDirectory = new File(targetDirectoryName);
                        try {
                            if(!targetDirectory.exists()){
                            FileUtils.forceMkdir(targetDirectory);}
                            else {
                                System.out.println("Directory already exist!");
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }


            }

            @Override
            String help() {
                return "\n[mkdir] command use to create new directory." +
                        "\nUsage:" +
                        "\nmkdir NEW_DIRECTORY_NAME ↲" +
                        "\nmkdir PATH"+File.separator+"NEW_DIRECTORY_NAME ↲";
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
                    if (!targetDirectoryName.contains(File.separator)) {
                        targetDirectoryName = currentDirectory + File.separator + targetDirectoryName;
                    }
                    if (!String.valueOf(targetDirectoryName.charAt(targetDirectoryName.length() - 1)).equals(File.separator)) {
                        targetDirectoryName = targetDirectoryName + File.separator;
                    }

                    File targetDirectory = new File(targetDirectoryName);
                    if (targetDirectory.exists()) {
                        try {
                            if (targetDirectory.isDirectory() && !targetDirectory.getCanonicalPath().equals(currentDirectory.getCanonicalPath())) {
                                FileUtils.deleteDirectory(targetDirectory);
                            } else if (!targetDirectory.getCanonicalPath().equals(currentDirectory.getCanonicalPath())) {
                                FileUtils.forceDelete(targetDirectory);
                            } else {
                                System.out.println("Can not remove current directory!");
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else {
                        System.out.println("No such file/directory");
                    }
                }

            }

            @Override
            String help() {
                return "\n[rm] command use to remove directory." +
                        "\nUsage:" +
                        "\nrm DIRECTORY ↲";
            }
        }

        public class Cat extends ACommand {
            @Override
            void execute() {
                String[] splitedCommand = command.split(" ");
                if (splitedCommand.length == 1) {
                    System.out.println("Input file name!");
                } else {
                    String fileName = splitedCommand[1].trim();
                    if (!fileName.contains(File.separator)) {
                        fileName = currentDirectory + File.separator + fileName;
                    }


                    File file = new File(fileName);
                    if (file.exists()&&file.isFile()) {
                        try {
                            System.out.println();
                            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                            while (bufferedReader.ready()){
                                System.out.println(bufferedReader.readLine());
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    } else {
                        System.out.println("Wrong file name!");
                    }
                }

            }

            @Override
            String help() {
                return "\n[cat] command use to reed the file." +
                        "\nUsage:" +
                        "\ncat FILE ↲" +
                        "\ncat PATH"+File.separator+"FILE ↲";
            }
        }

        public class Help extends ACommand {
            @Override
            void execute() {
                for(String s:commandList.keySet()){
                    System.out.println(commandList.get(s).help());
                }
            }

            @Override
            String help() {
                return "\n[help] command is using to get available command list. ";
            }
        }
    }

}
