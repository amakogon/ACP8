package week7.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * .|\_/|,,_____,~~`
 * .(.".)~~     )`~}} Created by Juff
 * ..\o/\ /---~\\ ~}}
 * ...._//    _// ~}
 */
public interface IModelDAO {

    public void add (Object o) throws SQLException;
    public void remove (int i) throws SQLException;
    public ResultSet getAll() throws SQLException;
    public void update(int id, Object o) throws SQLException;
    public void printAll() throws SQLException;
    public void printAllRS(ResultSet rs) throws SQLException;



}
