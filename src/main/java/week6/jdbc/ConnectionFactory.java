package week6.jdbc;

import org.postgresql.ds.PGSimpleDataSource;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {

  public static final String DB_CONFIG_PATH = "DBproperties";

  private ConnectionFactory() {
  }

  private static PGSimpleDataSource dataSource;

  private static void initDataSource() {
    dataSource = new PGSimpleDataSource();
    Properties properties = new Properties();
    try {
      properties.load(ClassLoader.getSystemResourceAsStream(DB_CONFIG_PATH));
    } catch (IOException e) {
      e.printStackTrace();
    }
    dataSource.setServerName(properties.getProperty("serverName"));
    dataSource.setDatabaseName(properties.getProperty("databaseName"));
    dataSource.setPortNumber(Integer.parseInt(properties.getProperty("portNumber")));
    dataSource.setUser(properties.getProperty("user"));
    dataSource.setPassword(properties.getProperty("password"));
  }

  public static Connection getConnection() throws SQLException {
    if (dataSource == null) {
      initDataSource();
    }
    return dataSource.getConnection();
  }

}
