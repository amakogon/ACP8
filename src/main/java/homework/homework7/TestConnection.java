package homework.homework7;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Home on 16.10.2015.
 */
public class TestConnection {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("db-context.xml");
        DBConnection dbConnection =
                context.getBean("UnConnection", DBConnection.class);
        //DBConnection dbConnection = new DBConnection("5432","postgres","1111","univercity");
        dbConnection.initProperties();
        Connection connection = dbConnection.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Student;");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("stud_name"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
