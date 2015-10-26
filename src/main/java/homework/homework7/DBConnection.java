package homework.homework7;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by Home on 16.10.2015.
 */
public class DBConnection {
    private String host;
    private String user;
    private String password;
    private String nameDB;
    private String url;


    private Properties properties = new Properties();
    private Connection connection;

    public DBConnection() {
    }

    public DBConnection(String host, String root, String password, String nameDB) {
        this.host = host;
        this.user = root;
        this.password = password;
        this.nameDB = nameDB;
    }

    public void initProperties() {
        url = "jdbc:postgresql://localhost:" + host + "/" + nameDB;

        properties.setProperty("user", user);
        properties.setProperty("password", password);
        properties.setProperty("characterEncoding", "UTF-8");
        properties.setProperty("useUnicode", "true");
    }

    public Connection getConnection() {
        if (connection == null) {
            try {
                Class.forName("org.postgresql.Driver");
                connection = DriverManager.getConnection(url, user, password);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    public void closeConnection() {
        try {
            if (connection.isClosed() == false) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setHost(String host) {
        this.host = host;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNameDB(String nameDB) {
        this.nameDB = nameDB;
    }
}
