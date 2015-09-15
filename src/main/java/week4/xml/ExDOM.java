package week4.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class ExDOM {
  public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    DocumentBuilder documentBuilder = factory.newDocumentBuilder();
    Document document = documentBuilder.parse(ClassLoader.getSystemResourceAsStream("students"));


    List<Student> studentList = new ArrayList<>();
    Element documentElement = document.getDocumentElement();
    NodeList nodeList = documentElement.getChildNodes();

    for (int i = 0; i < nodeList.getLength(); i++) {
      Node node = nodeList.item(i);
      if (node instanceof Element) {
        Student student = new Student();
        student.setId(Integer.valueOf((node.getAttributes().
          getNamedItem("id").getNodeValue())));

        NodeList childNodes = node.getChildNodes();
        for (int j = 0; j < childNodes.getLength(); j++) {
          Node cNode = childNodes.item(j);

          //Identifying the child tag of employee encountered.
          if (cNode instanceof Element) {
            String content = cNode.getLastChild().
              getTextContent().trim();
            switch (cNode.getNodeName()) {
              case "name":
                student.setName(content);
                break;
              case "age":
                student.setAge(Integer.valueOf(content));
                break;
            }
          }
        }
        studentList.add(student);
      }
    }

    for (Student student : studentList) {
      System.out.println(student);
    }
  }
}
