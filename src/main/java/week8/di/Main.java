package week8.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
  public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");

//    Person person = context.getBean(Person.class);
    Person person = context.getBean("frenk", Person.class);
    System.out.println(person);

    Performer performer = context.getBean("Carl", Singer.class);
    performer.perform();

    Band band = context.getBean(Band.class);
    System.out.println("~~~~~~~~~~~~~~");
    band.startBand();
  }
}
