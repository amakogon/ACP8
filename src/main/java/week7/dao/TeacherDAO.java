package week7.dao;


import week7.model.Teacher;

import java.sql.*;

/**
 * .|\_/|,,_____,~~`
 * .(.".)~~     )`~}} Created by Juff
 * ..\o/\ /---~\\ ~}}
 * ...._//    _// ~}
 */
public class TeacherDAO extends ModelDAO implements IModelDAO {


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

    @Override
    public void printAllRS(ResultSet rs) throws SQLException {

    }

    public ResultSet getTeacherWinthMinExperience() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM teacher GROUP BY teacher_id\n" +
                "HAVING teacher_experience=(SELECT MIN (teacher_experience) FROM teacher)");
        return resultSet;
    }

    public void printTeacherWithMinExperience(ResultSet resultSet) throws SQLException {
        while (resultSet.next()){
            System.out.println(resultSet.getString("teacher_name"));
        }
    }

    public ResultSet getTeacherWinthMaxExperience() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM teacher GROUP BY teacher_id\n" +
                "HAVING teacher_experience=(SELECT MAX (teacher_experience) FROM teacher)");
        return resultSet;
    }

    public void printTeacherWithMaxExperience(ResultSet resultSet) throws SQLException {
        while (resultSet.next()){
            System.out.println(resultSet.getString("teacher_name"));
        }
    }

    public ResultSet getTeacherWinthExperienceMoreThen(int experience) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM teacher GROUP BY teacher_id\n" +
                "HAVING teacher_experience>?");
        preparedStatement.setInt(1,experience);
        ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet;
    }

    public void printTeacherWithExperienceMoreThen(ResultSet resultSet) throws SQLException {
        while (resultSet.next()){
            System.out.println(resultSet.getString("teacher_name"));
        }
    }




}
