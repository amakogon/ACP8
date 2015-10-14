package week7.university;

import java.io.IOException;
import java.sql.*;

/**
 * .|\_/|,,_____,~~`
 * .(.".)~~     )`~}} Created by Juff
 * ..\o/\ /---~\\ ~}}
 * ...._//    _// ~}
 */
public class Main {
    public static void main(String[] args) throws SQLException, IOException {

        String dbName = "university";
        String dbServer = "jdbc:postgresql://localhost:5432/";
        String user = "postgres";
        String password = "root";

        DBConnection dbConnection = new DBConnection(dbServer, dbName ,user, password);
        java.sql.Connection connection = null;
        try {
            connection = dbConnection.getDBConnection();
        }catch (org.postgresql.util.PSQLException e){
            if(e.getServerErrorMessage().toString().equals("FATAL: database \"" + dbName + "\" does not exist")){
                System.out.println("Database \"" + dbName.toUpperCase() + "\" does not exist!" +
                        "\nCreating...");
                UniversityDbCreator universityDbCreator = new UniversityDbCreator(dbName,new DBConnection(dbServer,user,password).getServerConnection());
                universityDbCreator.create();
                connection = dbConnection.getDBConnection();
                System.out.println("Database \"" + dbName.toUpperCase() + "\" created!" +
                        "\nFilling...");
                UniversityDbFiller universityDbFiller = new UniversityDbFiller(connection);
                universityDbFiller.createTables();
                System.out.println("Filling tables...");
                universityDbFiller.fillTables();
                System.out.println("Ready to work!");
            }

        }

    }
}

