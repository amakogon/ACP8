package week7.dao;

import week7.model.Rank;
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
public class RankDAO extends ModelDAO implements IModelDAO {


    public RankDAO(Connection connection) throws SQLException {
        super(connection);
    }


    @Override
    public void add(Object o) throws SQLException {
        if (o instanceof Rank) {
            statement.executeUpdate("INSERT INTO ranks(student_id,subject_id,rank) VALUES" + ((Rank) o).toQuery());
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
