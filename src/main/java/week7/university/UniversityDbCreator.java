
package week7.university;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * .|\_/|,,_____,~~`
 * .(.".)~~     )`~}} Created by Juff
 * ..\o/\ /---~\\ ~}}
 * ...._//    _// ~}
 */
public class UniversityDbCreator {
    private Connection connection;
    private String dbName;

    public UniversityDbCreator(String dbName, Connection connection) {
        this.dbName=dbName;
        this.connection = connection;
    }

    public void create() throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate("CREATE DATABASE " + dbName);
    }

}
