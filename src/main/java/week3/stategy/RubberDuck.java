package week3.stategy;

public class RubberDuck extends Duck {

    @Override
    public void quack() {
        System.out.println("Резиновый кря кря");
    }

    @Override
    public void fly() {
        System.out.println("not able to");
//        throw new UnsupportedOperationException();
    }
}
