package homework7.univerDAO;

/**
 * Created by Razer on 24.10.15.
 */
public interface UniverDAO {

    String addStudent(int student_id, String student_name, int group_id);

    String addGroup(int group_id, String group_name, String description);

    String addSubject(int subject_id, String subject_name, String description);

    String addTeacher(int teacher_id, String teacher_name, int subject_id, int experience);

    String addGroupLearning(int group_id, int subject_id);

    String updateStudentGroup(int newGroup_id, int student_id);

    String showStudentByGroup(int group);

    String showStudent();

    String showAvgRank(String subject);

    String showTeacherExp(int experience);

    String showGroupWhoLearnMath();

    String showGroupWhoLearnMath(int group_id);

    String showTeacher();

    String showSubject();

}
