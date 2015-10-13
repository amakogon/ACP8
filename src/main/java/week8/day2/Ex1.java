package week8.day2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import week8.di.Box;
import static week8.di.Box.*;

public class Ex1 {
  public static void main(String[] args) {
    ApplicationContext context = SpringContext.getContext();
    Box box = context.getBean(Box.class);
    for (Ball ball : box.getBalls()) {
      System.out.println(ball);
    }
  }
}
