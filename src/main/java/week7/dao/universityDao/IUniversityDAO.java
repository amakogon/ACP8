package week7.dao.universityDao;

import week7.model.Group;
import week7.model.Student;
import week7.model.Subject;
import week7.model.Teacher;

import java.sql.SQLException;

/**
 * .|\_/|,,_____,~~`
 * .(.".)~~     )`~}} Created by Juff
 * ..\o/\ /---~\\ ~}}
 * ...._//    _// ~}
 */
public interface IUniversityDAO {

    void addSubject(Subject subject) throws SQLException;

    void addGroup(Group group) throws SQLException;

    void addTeacher(Teacher teacher) throws SQLException;

    void addSutdent(Student student) throws SQLException;


}
