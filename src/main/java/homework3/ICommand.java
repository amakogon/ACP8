package homework3;

/**
 * Created by Razer on 13.09.15.
 * ls - вывести содержимое текущей директории
 * cd - изменить текущую директорию
 * mkdir - создать директорию
 * rm - удалить файл или директорию
 * cat - вывести содержимое файла
 * help - доступные команды                    +
 */
public interface ICommand {
    void execute(String param);

    String getName();
}
