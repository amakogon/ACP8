package week7.day2.school;

import week6.jdbc.ConnectionFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertStudents {
  public static void main(String[] args) throws SQLException {
    Connection connection = ConnectionFactory.getConnection();
    Statement statement = connection.createStatement();
    statement.execute("select * from subject");
    ResultSet resultSet = statement.getResultSet();
    while (resultSet.next()){
      System.out.println(String.format("id=%d, title=%s", resultSet.getInt(1), resultSet.getString(2)));
    }
  }
}
