package week7.dao;

import week7.model.Study;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * .|\_/|,,_____,~~`
 * .(.".)~~     )`~}} Created by Juff
 * ..\o/\ /---~\\ ~}}
 * ...._//    _// ~}
 */
public class StudyDAO extends ModelDAO implements IModelDAO {


    public StudyDAO(Connection connection) throws SQLException {
        super(connection);
    }


    @Override
    public void add(Object o) throws SQLException {
        if (o instanceof Study) {
            statement.executeUpdate("INSERT INTO study(group_id,subject_id) VALUES" + ((Study) o).toQuery());
        }
    }

    @Override
    public void remove(int id) {

    }

    @Override
    public ResultSet getAll() {
        return null;
    }

    @Override
    public void update(int id, Object o) {

    }


    @Override
    public void printAll() {

    }

    @Override
    public void printAllRS(ResultSet rs) throws SQLException {

    }


}
