package week4.xml;

import java.util.ArrayList;
import java.util.List;

public class Group {
  private List<Student> list = new ArrayList<>();

  public List<Student> getStudents() {
    return list;
  }

  public void setStudents(List<Student> students) {
    this.list = students;
  }
}
