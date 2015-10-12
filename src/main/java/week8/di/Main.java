package week8.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
  public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");

//    Person person = context.getBean(Person.class);
    Person person = context.getBean("frenk", Person.class);
    System.out.println(person);


    Performer performer = context.getBean("Jim", Singer.class);
    performer.perform();
  }
}
