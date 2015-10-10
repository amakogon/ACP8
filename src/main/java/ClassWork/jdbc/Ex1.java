package ClassWork.jdbc;

import week5.exDownloader.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * .|\_/|,,_____,~~`
 * .(.".)~~     )`~}} Created by Juff
 * ..\o/\ /---~\\ ~}}
 * ...._//    _// ~}
 */
public class Ex1 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        java.sql.Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Univer", "postgres","newPassword");

    }
}
