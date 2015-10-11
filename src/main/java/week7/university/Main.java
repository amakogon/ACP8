package week7.university;

import week7.model.Group;
import week7.model.Student;
import week7.model.Subject;
import week7.model.Teacher;
import week7.parser.UniversityParser;

import java.io.IOException;
import java.sql.SQLException;

/**
 * .|\_/|,,_____,~~`
 * .(.".)~~     )`~}} Created by Juff
 * ..\o/\ /---~\\ ~}}
 * ...._//    _// ~}
 */
public class Main {
    public static void main(String[] args) throws SQLException, IOException {
        new ConnectAndFill().connectAndCreate();
    }
}
