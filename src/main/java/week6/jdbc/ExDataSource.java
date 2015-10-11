package week6.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ExDataSource {
  public static void main(String[] args) {
    String insertIntoBook = "insert into book values (?, ?)";
    String insertIntoReader = "insert into reader values (?, ?)";
    try (Connection connection = ConnectionFactory.getConnection()) {
      PreparedStatement preparedStatement = connection.prepareStatement(insertIntoReader);
      for (int i = 101; i < 500; i+=100) {
        preparedStatement.setInt(1, i);
        preparedStatement.setString(2, "R" + i);
        preparedStatement.execute();
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
