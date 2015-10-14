package week7.university;

import week7.dao.universityDao.*;
import week7.parser.UniversityParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * .|\_/|,,_____,~~`
 * .(.".)~~     )`~}} Created by Juff
 * ..\o/\ /---~\\ ~}}
 * ...._//    _// ~}
 */
public class UniversityDbFiller {
    private Connection connection;

    public UniversityDbFiller(Connection connection) {
        this.connection = connection;
    }

    public void createTables() throws SQLException {
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
                                    "student_name text," +
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

    public void fillTables() throws SQLException, IOException {


        DAO groupDAO   = new GroupDAO(connection);
        DAO studentDAO = new StudentDAO(connection);
        DAO subjectDAO = new SubjectDAO(connection);
        DAO teacherDAO = new TeacherDAO(connection);


        BufferedReader bufferedReader = null;
        //Groups
        URL groupsURL = ClassLoader.getSystemResource("university/groups.unv");
        bufferedReader = new BufferedReader(new InputStreamReader(groupsURL.openStream()));
        while (bufferedReader.ready()) {
            UniversityParser universityParser = new UniversityParser(bufferedReader.readLine());
            groupDAO.add(universityParser.createGroup());
        }
        bufferedReader.close();

        //Students
        URL studentsURL = ClassLoader.getSystemResource("university/students.unv");
        bufferedReader = new BufferedReader(new InputStreamReader(studentsURL.openStream()));
        while (bufferedReader.ready()) {
            UniversityParser universityParser = new UniversityParser(bufferedReader.readLine());
            studentDAO.add(universityParser.createStudent());
        }
        bufferedReader.close();

        //Subjects

        URL subjectsURL = ClassLoader.getSystemResource("university/subjects.unv");
        bufferedReader = new BufferedReader(new InputStreamReader(subjectsURL.openStream()));
        while (bufferedReader.ready()) {
            UniversityParser universityParser = new UniversityParser(bufferedReader.readLine());
            subjectDAO.add(universityParser.createSubject());
        }
        bufferedReader.close();

        //Teachers
        URL teachersURL = ClassLoader.getSystemResource("university/teachers.unv");
        bufferedReader = new BufferedReader(new InputStreamReader(teachersURL.openStream()));
        while (bufferedReader.ready()) {
            UniversityParser universityParser = new UniversityParser(bufferedReader.readLine());
            teacherDAO.add(universityParser.createTeacher());

        }
        bufferedReader.close();
    }
}
