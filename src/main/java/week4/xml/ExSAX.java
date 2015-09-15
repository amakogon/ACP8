package week4.xml;

import org.xml.sax.SAXException;

import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class ExSAX {
  public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
    SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
    SAXParser saxParser = saxParserFactory.newSAXParser();
    SAXHandler saxHandler = new SAXHandler();
    saxParser.parse(ClassLoader.getSystemResourceAsStream("students"), saxHandler);

    for (Student student : saxHandler.getStudentList()) {
      System.out.println(student);
    }
  }
}
