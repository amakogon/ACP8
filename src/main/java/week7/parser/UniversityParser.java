package week7.parser;

import week7.model.Group;
import week7.model.Student;
import week7.model.Subject;
import week7.model.Teacher;

/**
 * .|\_/|,,_____,~~`
 * .(.".)~~     )`~}} Created by Juff
 * ..\o/\ /---~\\ ~}}
 * ...._//    _// ~}
 */
public class UniversityParser {

    private String input;

    public UniversityParser(String input) {
        this.input = input;
    }

    public Subject createSubject() {
        String[] subjectString = input.split("\t");
        int id = Integer.parseInt(subjectString[0]);
        String name = subjectString[1];
        String description = subjectString[2];
        return new Subject(id,name,description);
    }

    public Student createStudent() {
        String[] studentString = input.split("\t");
        int id = Integer.parseInt(studentString[0]);
        String name = studentString[1];
        int groupId = Integer.parseInt(studentString[2]);
        return new Student(id,name,groupId);
    }

    public Group createGroup() {
        String[] groupString = input.split("\t");
        int id = Integer.parseInt(groupString[0]);
        String name = groupString[1];
        return new Group(id,name);
    }

    public Teacher createTeacher() {
        String[] teacherString = input.split("\t");
        int id = Integer.parseInt(teacherString[0]);
        String name = teacherString[1];
        int experience = Integer.parseInt(teacherString[2]);
        int subjectId = Integer.parseInt(teacherString[3]);
        return new Teacher(id,name,experience,subjectId);
    }


}
