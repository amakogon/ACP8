package week7.university;

import week7.dao.*;
import week7.model.Student;

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
        ModelDAO studentModelDao = new StudentDAO(connection);
        IUniversityDAO universityDao = new UniversityDAO(connection);

        //Get students set
        ResultSet allStudents = studentModelDao.getAll();

        //Print all students
        System.out.println("\n\rPrint all students\n\r");
        studentModelDao.printAll();


        //Student info update
        studentModelDao.update(10006, new Student(10006, "Vasiliy Pitersliy",1002));

        //Student remove
        studentModelDao.remove(10001);

        ResultSet studentListFromGroup = universityDao.getStudentListFromGroup(1002);
        studentModelDao.printAllRS(studentListFromGroup);

        // -узнать какие группы изучают математику

        System.out.println("\n\rУзнать какие группы изучают математик\n\r");
        String math = "Math";
        ResultSet mathSet = universityDao.getGroupListBySubject(math);
        universityDao.printGroupListBySubject(mathSet);

        //-узнать какие предметы узучают все группы (если хотя бы одна не изучает, то предмет не входит в выборку)

        System.out.println("\n\rУзнать какие предметы узучают все группы (если хотя бы одна не изучает, то предмет не входит в выборку\n\r");
        ResultSet noExclusiveSubjects = universityDao.getNotExclusiveSubjects();
        universityDao.printNotExclusiveSubjects(noExclusiveSubjects);

        // -какие преподаватель имеют наименьший и наибольший опыт?

        TeacherDAO teacherDAO = new TeacherDAO(connection);
        ResultSet teachersWithMinExperience = teacherDAO.getTeacherWinthMinExperience();
        ResultSet teachersWithMaxExperience = teacherDAO.getTeacherWinthMaxExperience();

        System.out.println("\n\rMin experience:\n\r");
        teacherDAO.printTeacherWithMinExperience(teachersWithMinExperience);
        System.out.println("\n\rMax experience:\n\r");
        teacherDAO.printTeacherWithMinExperience(teachersWithMaxExperience);

        //  -какие преподы преподают больше 3-х лет

        System.out.println("\n\rПреподы преподают больше 3-х лет\n\r");
        ResultSet teachersWithExperienceMoreThenThreeYears = teacherDAO.getTeacherWinthExperienceMoreThen(3);
        teacherDAO.printTeacherWithExperienceMoreThen(teachersWithExperienceMoreThenThreeYears);
    }
}

