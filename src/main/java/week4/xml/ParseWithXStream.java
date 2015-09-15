package week4.xml;

import com.thoughtworks.xstream.XStream;

public class ParseWithXStream {
  public static void main(String[] args) {
    XStream xStream = new XStream();
    xStream.alias("student", Student.class);
    xStream.alias("students", Group.class);
    xStream.addImplicitCollection(Group.class, "list");

    Group group = (Group) xStream.fromXML(ClassLoader.getSystemResourceAsStream("students"));
    for (Student student : group.getStudents()) {
      System.out.println(student);
    }
  }
}
