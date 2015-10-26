package homework.homework7;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * Created by Home on 16.10.2015.
 */
public class DAO {
    private DBConnection connection;
    private PreparedStatement preparedStatement;
    private StringBuilder builder;

    public DAO() {
        ApplicationContext context = new ClassPathXmlApplicationContext("db-context.xml");
        connection = context.getBean("UnConnection", DBConnection.class);
        connection.initProperties();
    }

    public void addStudent(String name, String phone, String email, int group_id) {
        try {
            preparedStatement = connection.getConnection().prepareStatement(
                    "INSERT INTO Student(stud_name, phone, email, group_id) " +
                            "VALUES(?, ?, ?, ?);");
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, phone);
            preparedStatement.setString(3, email);
            preparedStatement.setInt(4, group_id);
            preparedStatement.execute();
            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void addStudent(String name, int group_id) {
        try {
            preparedStatement = connection.getConnection().prepareStatement(
                    "INSERT INTO Student(stud_name, group_id) " +
                            "VALUES(?, ?);");
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, group_id);
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addGroup(String group_name) {
        try {
            preparedStatement = connection.getConnection().prepareStatement(
                    "INSERT INTO Grupa(group_name) VALUES(?);");
            preparedStatement.setString(1, group_name);
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addSubject(String subject_name, String subject_description) {
        try {
            preparedStatement = connection.getConnection().prepareStatement(
                    "INSERT INTO Subject(subject_name, subject_description) " +
                            "VALUES (?, ?);");
            preparedStatement.setString(1, subject_name);
            preparedStatement.setString(2, subject_description);
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addTeacher(String teacher_name, int experience, int subject_id) {
        try {
            preparedStatement= connection.getConnection().prepareStatement(
                    "INSERT INTO Teacher(teacher_name, experience, subject_id) " +
                            "VALUES(?,?,?);");
            preparedStatement.setString(1, teacher_name);
            preparedStatement.setInt(2, experience);
            preparedStatement.setInt(3, subject_id);
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void changeStudentGroup(int student_id, int newGroup_id) {
        try {
            preparedStatement = connection.getConnection().prepareStatement(
                    "UPDATE Student SET group_id = ? WHERE stud_id = ?;");
            preparedStatement.setInt(1, newGroup_id);
            preparedStatement.setInt(2, student_id);
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void retireTeacher(int teacher_id) {
        try {
            preparedStatement = connection.getConnection().prepareStatement(
                    "DELETE FROM Teacher WHERE teacher_id = ?;");
            preparedStatement.setInt(1, teacher_id);
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public String getAllStudentsAsString() {
        builder = new StringBuilder("  id     name                   phone      group   entry-date       e-mail \n");
        try {
            Statement statement = connection.getConnection().createStatement();
            statement.execute("SELECT * FROM Student ORDER BY stud_id;");
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()) {
                builder.append("   " + resultSet.getInt("stud_id") + "     " + resultSet.getString("stud_name") +
                        " " + resultSet.getString("phone") + "     " + resultSet.getInt("group_id") +
                        "     " + resultSet.getDate("entry_date") + "     " + resultSet.getString("email"));
                builder.append("\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return builder.toString();
    }

    public String getAllTeachersAsString() {
        builder = new StringBuilder("   id    name              experience   subject_id \n");
        try {
            Statement statement = connection.getConnection().createStatement();
            statement.execute("SELECT * FROM Teacher;");
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()) {
                builder.append("   " + resultSet.getInt("teacher_id") + "   " + resultSet.getString("teacher_name") + "   " +
                resultSet.getString("experience") + "             " + resultSet.getInt("subject_id") + "\n");
            }
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }

    public String getAllSubjectsAsString() {
        builder = new StringBuilder("   id  subject               description\n");
        try {
            Statement statement = connection.getConnection().createStatement();
            statement.execute("SELECT * FROM Subject");
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()) {
                builder.append("   " + resultSet.getInt("subject_id") + "   " + resultSet.getString("subject_name"));
                if (resultSet.getString("subject_description") == null) {
                    builder.append("\n");
                }
                else {
                    builder.append(resultSet.getString("subject_description") + "\n");
                }
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }

    public String getAllGroupsAsString() {
        builder = new StringBuilder("   id  group\n");
        try {
            Statement statement = connection.getConnection().createStatement();
            statement.execute("SELECT * FROM Grupa;");
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()) {
                builder.append("   " + resultSet.getInt("group_id") + "   " + resultSet.getString("group_name") + "\n");
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }

    public String getStudentsByGroupAsString(int groupId) {
        builder = new StringBuilder("  id     name                   phone      group   entry-date       e-mail \n");
        try {
            preparedStatement = connection.getConnection().prepareStatement(
                    "SELECT * FROM Student WHERE group_id = ? ORDER BY stud_id;");
            preparedStatement.setInt(1, groupId);
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                builder.append("   " + resultSet.getInt("stud_id") + "     " + resultSet.getString("stud_name") +
                        " " + resultSet.getString("phone") + "     " + resultSet.getInt("group_id") +
                        "     " + resultSet.getDate("entry_date") + "     " + resultSet.getString("email"));
                builder.append("\n");
            }
            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }

    public String getTeachersWithExperienceMoreThen(int yearsExperience) {
        builder = new StringBuilder("   id    name              experience   subject_id \n");
        try {
            PreparedStatement preparedStatement = connection.getConnection().prepareStatement(
                    "SELECT * FROM Teacher WHERE experience > ? ORDER BY teacher_id");
            preparedStatement.setInt(1, yearsExperience);
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                builder.append("   " + resultSet.getInt("teacher_id") + "   " + resultSet.getString("teacher_name") + "   " +
                        resultSet.getString("experience") + "             " + resultSet.getInt("subject_id") + "\n");
            }

            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }

    public String getTeacherWithMaxExperience() {
        builder = new StringBuilder("   id    name              experience   subject_id \n");
        try {
            Statement statement = connection.getConnection().createStatement();
            statement.execute("SELECT * FROM Teacher WHERE experience = (SELECT MAX (experience) FROM Teacher);");
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()) {
                builder.append("   " + resultSet.getInt("teacher_id") + "   " + resultSet.getString("teacher_name") + "   " +
                        resultSet.getString("experience") + "             " + resultSet.getInt("subject_id") + "\n");
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }

    public String getTeacherWithMinExperience() {
        builder = new StringBuilder("   id    name              experience   subject_id \n");
        try {
            Statement statement = connection.getConnection().createStatement();
            statement.execute("SELECT * FROM Teacher WHERE experience = (SELECT MIN (experience) FROM Teacher);");
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()) {
                builder.append("   " + resultSet.getInt("teacher_id") + "   " + resultSet.getString("teacher_name") + "   " +
                        resultSet.getString("experience") + "             " + resultSet.getInt("subject_id") + "\n");
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }

    public String getGroupsBySubjectAsString(int subjectId) {
        builder = new StringBuilder("   id  group\n");
        try {
            preparedStatement = connection.getConnection().prepareStatement("SELECT * \n" +
                    "FROM Grupa WHERE group_id IN (SELECT group_id FROM Study_program WHERE " +
                    "(subject_1_id = ? OR subject_2_id = ? OR subject_3_id = ?));");
            preparedStatement.setInt(1, subjectId);
            preparedStatement.setInt(2, subjectId);
            preparedStatement.setInt(3, subjectId);
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                builder.append("   " + resultSet.getInt("group_id") + "   " + resultSet.getString("group_name") + "\n");
            }
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }

    //TODO create query
    public String getSubjectsLearnedByAllGroups() {
        builder = new StringBuilder("   id  subject               description\n");
        try {
            Statement statement = connection.getConnection().createStatement();
            statement.execute("");
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()) {
                builder.append("   " + resultSet.getInt("subject_id") + "   " + resultSet.getString("subject_name"));
                if (resultSet.getString("subject_description") == null) {
                    builder.append("\n");
                }
                else {
                    builder.append(resultSet.getString("subject_description") + "\n");
                }
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }
}
