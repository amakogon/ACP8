package week7.dao.universityDao;

import week7.model.Student;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * .|\_/|,,_____,~~`
 * .(.".)~~     )`~}} Created by Juff
 * ..\o/\ /---~\\ ~}}
 * ...._//    _// ~}
 */
public class StudentDAO extends DAO implements IDAO {


    public StudentDAO(Connection connection) throws SQLException {
        super(connection);
    }


    @Override
    public void add(Object o) throws SQLException {
        if (o instanceof Student) {
            statement.executeUpdate("INSERT INTO student (student_id,student_name,group_id) VALUES" + ((Student) o).toQuery());
        }
    }

    @Override
    public void remove(Object o) {

    }

    @Override
    public void showAll() {

    }

    @Override
    public void update(Object o) {

    }
}
