package homework7.univerDAO;

import org.postgresql.ds.PGSimpleDataSource;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by Razer on 11.10.15.
 */
public class ConnectionFactoryToDB {
    public static final String DB_CONFIG = "DB_UniverProperties";
    private static PGSimpleDataSource dataSource;

    private static void initDataSource() {
        dataSource = new PGSimpleDataSource();
        Properties properties = new Properties();
        try {
            properties.load(ClassLoader.getSystemResourceAsStream(DB_CONFIG));
        } catch (IOException e) {
            e.printStackTrace();
        }
        dataSource.setUser(properties.getProperty("user"));
        dataSource.setPassword(properties.getProperty("password"));
        dataSource.setServerName(properties.getProperty("serverName"));
        dataSource.setDatabaseName(properties.getProperty("databaseName"));
        dataSource.setPortNumber(Integer.parseInt(properties.getProperty("port")));
    }

    public static Connection getConnection() throws SQLException {
        if(dataSource==null){
            initDataSource();
        }
        return dataSource.getConnection();
    }
}
