package week7.dao;

import week7.model.Group;
import week7.model.Student;
import week7.model.Subject;
import week7.model.Teacher;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * .|\_/|,,_____,~~`
 * .(.".)~~     )`~}} Created by Juff
 * ..\o/\ /---~\\ ~}}
 * ...._//    _// ~}
 */
public class UniversityDAOImpl implements IUniversityDAO {

    private Connection connection;
    private Statement statement;

    public UniversityDAOImpl(Connection connection) throws SQLException {
        this.connection = connection;
        statement = connection.createStatement();
    }


    @Override
    public void addSubject(Subject subject) throws SQLException {
        statement.executeUpdate("INSERT INTO subject(subject_id,subject_name,subject_description) VALUES" + subject.toQuery());
    }

    @Override
    public void addGroup(Group group) throws SQLException {
        statement.executeUpdate("INSERT INTO student_group(student_group_id,student_group_name) VALUES" + group.toQuery());
    }

    @Override
    public void addTeacher(Teacher teacher) throws SQLException {
        statement.executeUpdate("INSERT INTO teacher(teacher_id,teacher_name,teacher_experience,teacher_subject) VALUES" + teacher.toQuery());
    }

    @Override
    public void addSutdent(Student student) throws SQLException {
        statement.executeUpdate("INSERT INTO student (student_id,studetnt_name,group_id) VALUES" + student.toQuery());
    }
}
