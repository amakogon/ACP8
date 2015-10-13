package week6.jdbc;

import org.postgresql.ds.PGSimpleDataSource;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Ex1 {
  public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
    Class.forName("org.postgresql.Driver");
    Properties dbProperties = new Properties();
    dbProperties.load(ClassLoader.getSystemResourceAsStream("artcode_db"));

    String url = dbProperties.getProperty("url");
//    String user = "postgres";
//    String password = "P@ssw0rd";

    Connection connection = DriverManager.getConnection(url, dbProperties);
    Statement statement = connection.createStatement();

    statement.execute("select * from students order by id");

    ResultSet resultSet = statement.getResultSet();
    while (resultSet.next()) {
      int id = resultSet.getInt("id");
      String name = resultSet.getString("name");
      System.out.printf("id = %d, name = %s", id, name);
      System.out.println();
    }

    String sql = "select * from students where course = ? and homwork < ?";
    PreparedStatement preparedStatement = connection.prepareStatement(sql);
    preparedStatement.setString(1, "OOP");
    preparedStatement.setInt(2, 10);
    boolean execute = preparedStatement.execute();
    System.out.println(execute);
    ResultSet resultSet1 = preparedStatement.getResultSet();
    while (resultSet1.next()){
      int id = resultSet1.getInt("id");
      String name = resultSet1.getString("name");
      System.out.printf("id = %d, name = %s", id, name);
      System.out.println();
    }

  }
}
