package week8.day2;

import org.springframework.context.ApplicationContext;
import week8.di.Box;

public class Ex4 {
  public static void main(String[] args) {
    ApplicationContext context = SpringContext.getContext();
    Box.Ball uniqueBall = context.getBean("uniqueBall", Box.Ball.class);
    System.out.println(uniqueBall);
    Box.Ball uniqueBall2 = context.getBean("uniqueBall", Box.Ball.class);
    System.out.println(uniqueBall2);
    System.out.println("paraparapam свист");
  }
}
