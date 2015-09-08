package week3.stategy;

public class Test {
    public static void main(String[] args) {
        Duck duck = new MallardDuck();
        duck.quack();
        duck.fly();

        Duck duck1 = new RubberDuck();
        duck1.quack();
        duck1.fly();
    }
}
