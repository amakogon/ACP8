
package week2.command;

import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.io.DirectoryWalker;

import javax.activation.CommandMap;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * _|\_/|,,_____,~~`
 * _(.".)~~     )`~}} Created by Juff on 17.09.15.
 * __\o/\ /---~\\ ~}}
 * ___ _//    _// ~}
 */

public class Commands {
  DirectoryWalker

    public interface Command {
        void execute();
    }

    public class ls implements Command{

        @Override
        public void execute() {

        }
    }

    public class cd implements Command{

        @Override
        public void execute() {

        }
    }

    public class mkdir implements Command{

        @Override
        public void execute() {

        }
    }

    public class rm implements Command{

        @Override
        public void execute() {

        }
    }

    public class cat implements Command{

        @Override
        public void execute() {

        }
    }

    public class help implements Command{

        @Override
        public void execute() {
            System.out.println("ls - вывести содержимое текущей директории\n" +
                    "      cd - изменить текущую директорию\n" +
                    "      mkdir - создать директорию\n" +
                    "      rm - удалить файл или директорию\n" +
                    "      cat - вывести содержимое файла\n" +
                    "      help - доступные команды");
        }
    }





}
