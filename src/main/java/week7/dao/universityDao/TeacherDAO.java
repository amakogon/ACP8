package week7.dao.universityDao;


import week7.model.Teacher;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * .|\_/|,,_____,~~`
 * .(.".)~~     )`~}} Created by Juff
 * ..\o/\ /---~\\ ~}}
 * ...._//    _// ~}
 */
public class TeacherDAO extends DAO implements IDAO {


    public TeacherDAO(Connection connection) throws SQLException {
        super(connection);
    }


    @Override
    public void add(Object o) throws SQLException {
        if (o instanceof Teacher) {
            statement.executeUpdate("INSERT INTO teacher(teacher_id,teacher_name,teacher_experience,teacher_subject) VALUES" + ((Teacher) o).toQuery());
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
