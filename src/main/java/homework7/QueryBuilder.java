package homework7;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Razer on 11.10.15.
 */
////Используя jdbc необходимо:
//-получить список всех студентовб группб предметов и преподов +
//        -добавить сутдента, группу, предмет, препода
//        -обновить информацию о сущностях бд (например студент изменил группу или препода уволили)
//        -получить список студентов определенной группы  +
//        -узнать какие группы изучают математику
//        -узнать какие предметы узучают все группы (если хотя бы одна не изучает, то предмет не входит в выборку)
//        -какие преподаватель имеют наименьший и наибольший опыт?
//        -какие преподы преподают больше 3-х лет
//        -получить список гуманитарных предметов
//        -узнать средний бал студентов по физике (всех и определенной группы)
//        -показать группу, в которой более 3-х студентов изучают философию (и выгнать с универа)
public class QueryBuilder {
    private Map<String, String> query = new HashMap<>();
    private StringBuilder builder = new StringBuilder();
    private PreparedStatement preparedStatement;
    private Connection connection;

    public QueryBuilder() {
        addAllQuery();
        createConnection();
    }

    private void createConnection() {
        try {
            connection = ConnectionFactoryToDB.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void addAllQuery() {
        query.put("showStudent", "Select * from student");
        query.put("showTeacher", "Select * from teacher");
        query.put("showSubject", "Select * from subject");
        query.put("showStudentGroup", "Select * from studentgroup");
        query.put("showStudentByGroup", "Select * from student where group_id=?");
        query.put("addStudent", "Insert into Student(student_id,student_name,group_id) Values(?,?,?) ");
        query.put("addGroup", "Insert into Student(student_id,student_name,group_id) Values(?,?,?) ");
        query.put("addSubject", "Insert into Student(student_id,student_name,group_id) Values(?,?,?) ");
        query.put("select", "");
    }

    public String addStudent(int student_id, String student_name, int group_id) {
        try {
            preparedStatement = connection.prepareStatement(query.get("addStudent"));
            preparedStatement.setInt(1, student_id);
            preparedStatement.setString(2, student_name);
            preparedStatement.setInt(3, group_id);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "Query returned successfully";
    }

    public String showStudentByGroup(int group) {
        try {
            preparedStatement = connection.prepareStatement(query.get("showStudentByGroup"));
            preparedStatement.setInt(1, group);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                builder.append(String.format("id=%d, Student name=%s", resultSet.getInt(1), resultSet.getString(2)));
                builder.append("\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }

    public String showStudent() {
        try {
            preparedStatement = connection.prepareStatement(query.get("showStudent"));
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                builder.append(String.format("id=%d, student name=%s, group_id=%s", resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3)));
                builder.append("\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }

    public String showStudentGroup() {
        try {
            preparedStatement = connection.prepareStatement(query.get("showStudentGroup"));
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                builder.append(String.format("group id=%d, group name=%s, description=%s", resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3)));
                builder.append("\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }

    public String showTeacher() {
        try {
            preparedStatement = connection.prepareStatement(query.get("showTeacher"));
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                builder.append(String.format("id=%d, teacher name=%s, subject id=%s, experience=%s", resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4)));
                builder.append("\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }

    public String showSubject() {
        try {
            preparedStatement = connection.prepareStatement(query.get("showSubject"));
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                builder.append(String.format("id=%d, subject name=%s, description=%s", resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3)));
                builder.append("\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }
}
