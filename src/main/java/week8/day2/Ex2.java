package week8.day2;

public class Ex2 {
  public static void main(String[] args) {
    Circle circle = SpringContext.getContext().getBean("circle", Circle.class);
    System.out.println(circle);
  }
}
