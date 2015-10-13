package week8.day2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringContext {

  private static ApplicationContext context = null;

  public static ApplicationContext getContext() {
    if(context == null){
      context = new ClassPathXmlApplicationContext("application-context.xml");
    }
    return context;
  }
}
