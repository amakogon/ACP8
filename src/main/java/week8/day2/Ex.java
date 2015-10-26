package week8.day2;

/**
 * Created by Home on 13.10.2015.
 */
public class Ex {
    public static void main(String[] args) {
        Circle circle = SpringContext.getContext().getBean("circle", Circle.class);
        System.out.println(circle);
    }
}
