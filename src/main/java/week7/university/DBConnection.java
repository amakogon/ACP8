package week7.university;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * .|\_/|,,_____,~~`
 * .(.".)~~     )`~}} Created by Juff
 * ..\o/\ /---~\\ ~}}
 * ...._//    _// ~}
 */
public class DBConnection {

    private String dbName;
    private String dbServer;
    private String user;
    private String password;
    private Driver jdbcdriver = new org.postgresql.Driver();

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public String getDbServer() {
        return dbServer;
    }

    public void setDbServer(String dbServer) {
        this.dbServer = dbServer;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Driver getJdbcdriver() {
        return jdbcdriver;
    }

    public void setJdbcdriver(Driver jdbcdriver) {
        this.jdbcdriver = jdbcdriver;
    }

    public DBConnection(String dbServer, String user, String password) {
        this.dbServer = dbServer;
        this.user = user;
        this.password = password;
    }

    public DBConnection(String dbServer, String dbName, String user, String password) {
        this.dbName = dbName;
        this.dbServer = dbServer;
        this.user = user;
        this.password = password;
    }

    public java.sql.Connection getServerConnection() throws SQLException {
        Driver jdbcdriver = new org.postgresql.Driver();
        DriverManager.registerDriver(jdbcdriver);
        return DriverManager.getConnection(dbServer, user, password);
    }

    public java.sql.Connection getDBConnection() throws SQLException {
        Driver jdbcdriver = new org.postgresql.Driver();
        DriverManager.registerDriver(jdbcdriver);
        return DriverManager.getConnection(dbServer + dbName.toLowerCase(), user, password);
    }

}
