package week7.dao.universityDao;

import week7.model.Group;
import week7.model.Subject;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * .|\_/|,,_____,~~`
 * .(.".)~~     )`~}} Created by Juff
 * ..\o/\ /---~\\ ~}}
 * ...._//    _// ~}
 */
public class SubjectDAO extends DAO implements IDAO {


    public SubjectDAO(Connection connection) throws SQLException {
        super(connection);
    }


    @Override
    public void add(Object o) throws SQLException {
        if (o instanceof Subject) {
            statement.executeUpdate("INSERT INTO subject(subject_id,subject_name,subject_description) VALUES" + ((Subject) o).toQuery());
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
