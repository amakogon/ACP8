package homework7.univerDAO;

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
//        -добавить сутдента, группу, предмет, препода +
//        -обновить информацию о сущностях бд (например студент изменил группу или препода уволили) +
//        -получить список студентов определенной группы  +
//        -узнать какие группы изучают математику +
//        -узнать какие предметы узучают все группы (если хотя бы одна не изучает, то предмет не входит в выборку)
//        -какие преподаватель имеют наименьший и наибольший опыт?
//        -какие преподы преподают больше 3-х лет +
//        -получить список гуманитарных предметов ?
//        -узнать средний бал студентов по физике (всех и определенной группы) +
//        -показать группу, в которой более 3-х студентов изучают философию (и выгнать с универа) ????
public class ImplUniverDAO implements UniverDAO {
    private Map<String, String> query = new HashMap<>();
    private StringBuilder builder = new StringBuilder();
    private PreparedStatement preparedStatement;
    private Connection connection;

    public ImplUniverDAO() {
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
        query.put("addStudent", "Insert into Student(student_id,student_name,group_id) Values(?,?,?) ");
        query.put("addGroup", "Insert into StudentGroup(group_id,group_name,description) Values(?,?,?) ");
        query.put("addSubject", "Insert into Subject(subject_id,subject_name,description) Values(?,?,?) ");
        query.put("addTeacher", "Insert into Teacher(teacher_id,teacher_name,subject_id,experience) Values(?,?,?,?) ");
        query.put("addGroupLearning", "Insert into group_learning(group_id,subject_id) values (?,?)");
        query.put("updateStudentGroup","UPDATE student SET group_id=? WHERE student_id=? ");
        query.put("showStudent", "Select * from student");
        query.put("showTeacher", "Select * from teacher");
        query.put("showSubject", "Select * from subject");
        query.put("showStudentGroup", "Select * from studentgroup");
        query.put("deleteTeacher", "");
        query.put("showTeacherWhereExp", "SELECT teacher_name,experience FROM TEACHER WHERE experience>?");
        query.put("showAvgRank", "SELECT  avg(rank)from success sc join subject s on s.subject_id=sc.subject_id  where  s.subject_name =?");
        query.put("showWhoLearnMath", "select student_name,group_id from student where group_id=?");
        query.put("showStudentByGroup", "Select student_name,group_id from student where group_id=?");
        query.put("select", "");
        query.put("showGroupWhoLearnMath", "select group_id,subject_name from group_learning gl join subject s on s.subject_id = gl.subject_id  where s.subject_name = 'Math';");
    }

    public String addStudent(int studentId, String studentName, int groupId) {
        try {
            preparedStatement = connection.prepareStatement(query.get("addStudent"));
            preparedStatement.setInt(1, studentId);
            preparedStatement.setString(2, studentName);
            preparedStatement.setInt(3, groupId);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "Query returned successfully";
    }

    public String addGroup(int groupId, String groupName, String description) {
        try {
            preparedStatement = connection.prepareStatement(query.get("addGroup"));
            preparedStatement.setInt(1, groupId);
            preparedStatement.setString(2, groupName);
            preparedStatement.setString(3, description);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "Query returned successfully";
    }

    public String addSubject(int subjectId, String subjectName, String description) {
        try {
            preparedStatement = connection.prepareStatement(query.get("addSubject"));
            preparedStatement.setInt(1, subjectId);
            preparedStatement.setString(2, subjectName);
            preparedStatement.setString(3, description);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "Query returned successfully";
    }

    public String addTeacher(int teacherId, String teacherName, int subjectId, int experience) {
        try {
            preparedStatement = connection.prepareStatement(query.get("addTeacher"));
            preparedStatement.setInt(1, teacherId);
            preparedStatement.setString(2, teacherName);
            preparedStatement.setInt(3, subjectId);
            preparedStatement.setInt(4, experience);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "Query returned successfully";
    }

    public String addGroupLearning(int groupId, int subjectId) {
        try {
            preparedStatement = connection.prepareStatement(query.get("addGroupLearning"));
            preparedStatement.setInt(1, groupId);
            preparedStatement.setInt(2, subjectId);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "Query returned successfully";
    }

    public String updateStudentGroup(int newGroupId, int studentId) {
        try {
            preparedStatement = connection.prepareStatement(query.get("updateStudentGroup"));
            preparedStatement.setInt(1, newGroupId);
            preparedStatement.setInt(2, studentId);
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

    public String showAvgRank(String subject) {
        try {
            preparedStatement = connection.prepareStatement(query.get("showAvgRank"));
            preparedStatement.setString(1, subject);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                builder.append(String.format(subject + " avg rank=%.1f", resultSet.getDouble(1)));
                builder.append("\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }

    public String showTeacherExp(int experience) {
        try {
            preparedStatement = connection.prepareStatement(query.get("showTeacherWhereExp"));
            preparedStatement.setInt(1, experience);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                builder.append(String.format("teacher name=%s,experience=%d", resultSet.getString(1), resultSet.getInt(2)));
                builder.append("\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }

    public String showGroupWhoLearnMath() {

        try {
            preparedStatement = connection.prepareStatement(query.get("showGroupWhoLearnMath"));
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                builder.append(String.format("group id=%d, subject name=%s", resultSet.getInt(1), resultSet.getString(2)));
                builder.append("\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }

    public String showGroupWhoLearnMath(int groupId) {
        try {
            preparedStatement = connection.prepareStatement(query.get("showWhoLearnMath"));
            preparedStatement.setInt(1, groupId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                builder.append(String.format("student name=%s, group_id=%d", resultSet.getString(1), resultSet.getInt(2)));
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
