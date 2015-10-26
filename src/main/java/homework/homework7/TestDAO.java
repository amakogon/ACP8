package homework.homework7;

/**
 * Created by Home on 17.10.2015.
 */
public class TestDAO {
    public static void main(String[] args) {
        DAO dao = new DAO();
        //dao.addStudent("Nikita","0961625685", "kit@gmail.com", 1);
        //System.out.println(dao.getStudentsByGroupAsString(1));
        //System.out.println(dao.getAllStudentsAsString());
        //System.out.println(dao.getAllTeachersAsString());
        //System.out.println(dao.getAllSubjectsAsString());
        //System.out.println(dao.getAllGroupsAsString());
        //System.out.println(dao.getTeachersWithExperienceMoreThen(40));
        //System.out.println(dao.getTeacherWithMaxExperience());
        //System.out.println(dao.getTeacherWithMinExperience());
        System.out.println(dao.getGroupsBySubjectAsString(3));
    }
}
