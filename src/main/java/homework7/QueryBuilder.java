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
//-получить список всех студентовб группб предметов и преподов
//        -добавить сутдента, группу, предмет, препода
//        -обновить информацию о сущностях бд (например студент изменил группу или препода уволили)
//        -получить список студентов определенной группы
//        -узнать какие группы изучают математику
//        -узнать какие предметы узучают все группы (если хотя бы одна не изучает, то предмет не входит в выборку)
//        -какие преподаватель имеют наименьший и наибольший опыт?
//        -какие преподы преподают больше 3-х лет
//        -получить список гуманитарных предметов
//        -узнать средний бал студентов по физике (всех и определенной группы)
//        -показать группу, в которой более 3-х студентов изучают философию (и выгнать с универа)
public class QueryBuilder {
    Map<String, String> query = new HashMap<>();
    StringBuilder builder = new StringBuilder();
    PreparedStatement preparedStatement;
    Connection connection;

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
        query.put("showStudentByGroup", "Select * from student where group_id=?");
        query.put("addStudent", "Insert into Student(student_id,student_name,group_id) Values(?,?,?) ");
        query.put("select", "");
    }

    private final String ADD_GROUP = "Insert into Group";
    private final String ADD_SUBJECT = "Insert into Subject";
    private final String ADD_TEACHER = "Insert into Teacher";

    public String show(String name) {
        return query.get("show") + name;
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
                builder.append(String.format("id=%d, student_name=%s,group_id=%s", resultSet.getInt(1), resultSet.getString(2),resultSet.getString(3)));
                builder.append("\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }
}
