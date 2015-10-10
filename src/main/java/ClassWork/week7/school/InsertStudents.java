package ClassWork.week7.school;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * .|\_/|,,_____,~~`
 * .(.".)~~     )`~}} Created by Juff
 * ..\o/\ /---~\\ ~}}
 * ...._//    _// ~}
 */
public class InsertStudents {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        java.sql.Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost/Univer", "postgres", "qwerty");
    }

}
