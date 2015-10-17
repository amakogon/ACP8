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
public abstract class ModelDAO extends DAO implements IModelDAO {


    public ModelDAO(Connection connection) throws SQLException {
        super(connection);
    }
}
