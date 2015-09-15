package week4.json;

import com.google.gson.Gson;
import week4.xml.Student;

public class ExGSON {

  public static final Gson GSON = new Gson();

  public static void main(String[] args) {
    Student student = new Student();
    student.setAge(2);
    student.setName("Padre");
    student.setId(1001);

    String res = GSON.toJson(student);
    System.out.println(res);

    Student restored = GSON.fromJson(res, Student.class);
    System.out.println(restored);

  }
}
