package homework7;

import java.sql.*;

/**
 * Created by Razer on 11.10.15.
 */
public class Start {
    public static void main(String[] args) {
        Connection connection=null;
        try {
            connection = ConnectionFactoryToDB.getConnection();
            Statement statement=connection.createStatement();
            statement.execute("select * from student");
//            ResultSet resultSet = statement.getResultSet();
//            while (resultSet.next()){
//                System.out.println(String.format("id=%d, title=%s", resultSet.getInt(1), resultSet.getString(2)));
//            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(Query.SHOW_STUDENT_GROUP);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                System.out.println(String.format("id=%d, title=%s", resultSet.getInt(1), resultSet.getString(2)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
