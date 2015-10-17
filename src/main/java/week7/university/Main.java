package week7.university;

import week7.dao.DAO;
import week7.dao.StudentDAO;
import week7.model.Student;

import java.io.IOException;
import java.net.Socket;
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
        DAO studentDao = new StudentDAO(connection);
        //Get students set
        ResultSet allStudents = studentDao.getAll();
        //Print all students

        studentDao.update(10006,new Student(10006, "Vasiliy Pitersliy",1002));

        studentDao.printAll();

        studentDao.remove(10001);
        studentDao.printAll();



    }
}

