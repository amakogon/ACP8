package week7.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * .|\_/|,,_____,~~`
 * .(.".)~~     )`~}} Created by Juff
 * ..\o/\ /---~\\ ~}}
 * ...._//    _// ~}
 */
public interface IUniversityDAO {

    public ResultSet getStudentListFromGroup(int group_id) throws SQLException;
    public ResultSet getGroupListBySubject(String subject) throws SQLException;
    public void printGroupListBySubject(ResultSet resultSet) throws SQLException;
    public ResultSet getNotExclusiveSubjects() throws SQLException;
    public void printNotExclusiveSubjects(ResultSet resultSet) throws SQLException;
}
