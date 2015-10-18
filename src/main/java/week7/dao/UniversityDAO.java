package week7.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * .|\_/|,,_____,~~`
 * .(.".)~~     )`~}} Created by Juff
 * ..\o/\ /---~\\ ~}}
 * ...._//    _// ~}
 */
public class UniversityDAO extends DAO implements IUniversityDAO {


    public UniversityDAO(Connection connection) throws SQLException {
        super(connection);
    }

    // -получить список студентов определенной группы

    @Override
    public ResultSet getStudentListFromGroup(int group_id) throws SQLException {
        ResultSet resultSet = statement.executeQuery("SELECT * FROM student WHERE group_id = " + group_id);
        return resultSet;
    }

    // -узнать какие группы изучают математику
    @Override
    public ResultSet getGroupListBySubject(String subject) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT student_group_name FROM \n" +
                "    (study st JOIN student_group sg ON st.group_id=sg.student_group_id) \n" +
                "    JOIN subject sub on st.subject_id=sub.subject_id\n" +
                "    WHERE sub.subject_name = ?");
        preparedStatement.setString(1, subject);
        ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet;
    }

    @Override
    public void printGroupListBySubject(ResultSet resultSet) throws SQLException {
        while (resultSet.next()){
            System.out.println(resultSet.getString(1));
        }
    }


    ///  -узнать какие предметы узучают все группы (если хотя бы одна не изучает, то предмет не входит в выборку)

    @Override
    public ResultSet getNotExclusiveSubjects() throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT subj.subject_name FROM (study st JOIN subject subj ON st.subject_id=subj.subject_id)\n" +
                "GROUP BY subj.subject_id\n" +
                "HAVING count(*)=(SELECT count(DISTINCT group_id) FROM study)");
        ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet;
    }

    @Override
    public void printNotExclusiveSubjects(ResultSet resultSet) throws SQLException {
        while (resultSet.next()){
            System.out.println(resultSet.getString(1));
        }
    }

   /* "SELECT (subject_name) FROM subject\n"+
            "WHERE (subject_name='Biology' OR subject_name='Geography')"*/


}
