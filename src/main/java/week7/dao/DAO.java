package week7.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * .|\_/|,,_____,~~`
 * .(.".)~~     )`~}} Created by Juff
 * ..\o/\ /---~\\ ~}}
 * ...._//    _// ~}
 */
public abstract class DAO {
    protected Connection connection;
    protected Statement statement;

    public DAO(Connection connection) throws SQLException {
        this.connection = connection;
        statement=connection.createStatement();
    }
}
