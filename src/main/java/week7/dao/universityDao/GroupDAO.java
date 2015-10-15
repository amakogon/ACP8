package week7.dao.universityDao;

import week7.model.Group;
import week7.model.Student;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * .|\_/|,,_____,~~`
 * .(.".)~~     )`~}} Created by Juff
 * ..\o/\ /---~\\ ~}}
 * ...._//    _// ~}
 */
public class GroupDAO extends DAO implements IDAO {


    public GroupDAO(Connection connection) throws SQLException {
        super(connection);
    }


    @Override
    public void add(Object o) throws SQLException {
        if (o instanceof Group) {
            statement.executeUpdate("INSERT INTO student_group(student_group_id,student_group_name) VALUES" + ((Group) o).toQuery());
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


}
