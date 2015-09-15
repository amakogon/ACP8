package week4.xml;

import com.google.common.collect.Lists;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.List;
import java.util.Objects;

public class SAXHandler extends DefaultHandler {
  private List<Student> studentList;
  private Student currentStudent;
  private String attrValue;

  public SAXHandler() {
    studentList = Lists.newArrayList();
  }

  @Override
  public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
    if (Objects.equals(qName, "student")) {
      currentStudent = new Student();
      Integer studentId = Integer.valueOf(attributes.getValue("id"));
      currentStudent.setId(studentId);
    }
  }

  @Override
  public void endElement(String uri, String localName, String qName) throws SAXException {
    if (Objects.equals(qName, "student")) {
      studentList.add(currentStudent);
    } else if (Objects.equals(qName, "age")) {
      currentStudent.setAge(Integer.parseInt(attrValue));
    } else if (Objects.equals(qName, "name")) {
      currentStudent.setName(attrValue);
    }
  }

  @Override
  public void characters(char[] ch, int start, int length) throws SAXException {
    attrValue = String.valueOf(ch, start, length);
  }

  public List<Student> getStudentList() {
    return studentList;
  }
}
