package week7.university;

import org.postgresql.util.PSQLException;
import week7.dao.UniversityDAOImpl;
import week7.parser.UniversityParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * .|\_/|,,_____,~~`
 * .(.".)~~     )`~}} Created by Juff
 * ..\o/\ /---~\\ ~}}
 * ...._//    _// ~}
 */
public class ConnectAndFill {
    Connection connection;


    public void connectAndCreate() throws SQLException, IOException {

        String dbName = "UNIVERSITY";
        String dbServer = "jdbc:postgresql://localhost:5432/";
        String user = "postgres";
        String password = "root";
        Driver jdbcdriver = new org.postgresql.Driver();
        DriverManager.registerDriver(jdbcdriver);
        connection = DriverManager.getConnection(dbServer, user, password);

        java.sql.Statement statement = connection.createStatement();
        //KILL DB - ONLY FOR TESTS
        try {
            statement.executeUpdate("DROP  DATABASE " + dbName);
        } catch (PSQLException e) {
            System.out.println("Something gona wrong...");
        }

        try {
            statement.executeUpdate("CREATE DATABASE " + dbName);
        } catch (org.postgresql.util.PSQLException e) {
            //System.out.println("DB " + dbName.toUpperCase() + " is already exist!");
        }
        connection = DriverManager.getConnection(dbServer + dbName.toLowerCase(), user, password);
        fillUniversityTable(connection);

        UniversityDAOImpl dao = new UniversityDAOImpl(connection);
        fillTables(dao);
    }

    private void fillTables(UniversityDAOImpl dao) throws IOException, SQLException {
        BufferedReader bufferedReader = null;
        //Groups
        URL groupsURL = ClassLoader.getSystemResource("university/groups.unv");
        bufferedReader = new BufferedReader(new InputStreamReader(groupsURL.openStream()));
        while (bufferedReader.ready()) {
            UniversityParser universityParser = new UniversityParser(bufferedReader.readLine());
            dao.addGroup(universityParser.createGroup());
        }
        bufferedReader.close();

        //Students
        URL studentsURL = ClassLoader.getSystemResource("university/students.unv");
        bufferedReader = new BufferedReader(new InputStreamReader(studentsURL.openStream()));
        while (bufferedReader.ready()) {
            UniversityParser universityParser = new UniversityParser(bufferedReader.readLine());
            dao.addSutdent(universityParser.createStudent());
        }
        bufferedReader.close();

        //Subjects

        URL subjectsURL = ClassLoader.getSystemResource("university/subjects.unv");
        bufferedReader = new BufferedReader(new InputStreamReader(subjectsURL.openStream()));
        while (bufferedReader.ready()) {
            UniversityParser universityParser = new UniversityParser(bufferedReader.readLine());
            dao.addSubject(universityParser.createSubject());
        }
        bufferedReader.close();

        //Teachers
        URL teachersURL = ClassLoader.getSystemResource("university/teachers.unv");
        bufferedReader = new BufferedReader(new InputStreamReader(teachersURL.openStream()));
        while (bufferedReader.ready()) {
            UniversityParser universityParser = new UniversityParser(bufferedReader.readLine());
            dao.addTeacher(universityParser.createTeacher());
        }
        bufferedReader.close();

    }


    private void fillUniversityTable(Connection connection) throws SQLException {
        java.sql.Statement statement = connection.createStatement();
        //Creating STUDENT_GROUP TABLE
        try {

            statement.executeUpdate
                    ("CREATE TABLE STUDENT_GROUP" +
                                    "(" +
                                    "student_group_id integer NOT NULL," +
                                    "student_group_name text," +
                                    "CONSTRAINT student_group_pkey PRIMARY KEY (student_group_id)" +
                                    ")"
                    );
        } catch (org.postgresql.util.PSQLException e) {
            System.out.println("TABLE STUDENT_GROUP is already exist!");
        }

        //Creating STUDENT TABLE
        try {

            statement.executeUpdate
                    ("CREATE TABLE STUDENT (" +
                                    "student_id integer NOT NULL," +
                                    "studetnt_name text," +
                                    "group_id integer REFERENCES student_group (student_group_id)," +
                                    "CONSTRAINT student_pkey PRIMARY KEY (student_id)" +
                                    ")"
                    );
        } catch (org.postgresql.util.PSQLException e) {
            System.out.println("TABLE STUDENT is already exist!");
        }

        //Creating SUBJECT TABLE
        try {

            statement.executeUpdate
                    ("CREATE TABLE SUBJECT (" +
                                    "subject_id integer NOT NULL," +
                                    "subject_name text," +
                                    "subject_description text," +
                                    "CONSTRAINT subject_pkey PRIMARY KEY (subject_id)" +
                                    ")"
                    );
        } catch (org.postgresql.util.PSQLException e) {
            System.out.println("TABLE SUBJECT is already exist!");
        }

        //Creating TEACHER TABLE
        try {

            statement.executeUpdate

                    ("CREATE TABLE TEACHER (" +
                                    "teacher_id integer NOT NULL," +
                                    "teacher_name text," +
                                    "teacher_experience integer," +
                                    "teacher_subject integer," +
                                    "CONSTRAINT teacher_pkey PRIMARY KEY (teacher_id)," +
                                    "CONSTRAINT teacher_subject_fk FOREIGN KEY (teacher_subject) REFERENCES subject(subject_id)" +
                                    ")"
                    );
        } catch (org.postgresql.util.PSQLException e) {
            System.out.println("TABLE TEACHER is already exist!");
        }

        //Creating STUDY TABLE
        try {

            statement.executeUpdate

                    ("CREATE TABLE STUDY (" +
                                    "group_id integer NOT NULL," +
                                    "CONSTRAINT group_id_fk FOREIGN KEY (group_id) REFERENCES student_group(student_group_id)," +
                                    "subject_id integer," +
                                    "CONSTRAINT subject_id_fk FOREIGN KEY (subject_id) REFERENCES subject(subject_id)" +
                                    ")"
                    );
        } catch (org.postgresql.util.PSQLException e) {
            System.out.println("TABLE STUDY is already exist!");
        }


    }
}
