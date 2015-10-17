package week7.dao;

import week7.model.Student;

import java.sql.*;

/**
 * .|\_/|,,_____,~~`
 * .(.".)~~     )`~}} Created by Juff
 * ..\o/\ /---~\\ ~}}
 * ...._//    _// ~}
 */
public class StudentDAO extends ModelDAO implements IModelDAO {


    public StudentDAO(Connection connection) throws SQLException {
        super(connection);
    }


    @Override
    public void add(Object o) throws SQLException {
        if (o instanceof Student) {
            statement.executeUpdate("INSERT INTO student (student_id,student_name,group_id) VALUES" + ((Student) o).toQuery());
        }
    }

    @Override
    public void remove(int id) throws SQLException {

        PreparedStatement preparedStatement = null;
        preparedStatement=connection.prepareStatement("DELETE FROM student WHERE student_id = ?");
        preparedStatement.setInt(1, id);
        preparedStatement.execute();
    }

    @Override
    public ResultSet getAll() throws SQLException {
        ResultSet resultSet = statement.executeQuery("SELECT * FROM student");
        return resultSet;
    }

    @Override
    public void update(int id, Object o) throws SQLException {

        Student student = null;
        if (o instanceof Student){
            student=(Student)o;
        }

        PreparedStatement preparedStatement = null;
        preparedStatement=connection.prepareStatement("UPDATE student SET student_name = ? WHERE student_id = ?");
        preparedStatement.setString(1,student.getName());
        preparedStatement.setInt(2, student.getId());
        preparedStatement.execute();

        preparedStatement=connection.prepareStatement("UPDATE student SET group_id = ? WHERE student_id = ?");
        preparedStatement.setInt(1,student.getGroupId());
        preparedStatement.setInt(2,student.getId());
        preparedStatement.executeUpdate();

    }

    @Override
    public void printAll() throws SQLException {
        ResultSet rs = new StudentDAO(connection).getAll();
        while (rs.next()){
            System.out.println(rs.getInt("student_id")+"\t"+rs.getString("student_name")+ "\t" + rs.getInt("group_id"));
        }
    }

    @Override
    public void printAllRS(ResultSet rs) throws SQLException {
        while (rs.next()){
            System.out.println(rs.getInt("student_id")+"\t"+rs.getString("student_name")+ "\t" + rs.getInt("group_id"));
        }
    }
}
