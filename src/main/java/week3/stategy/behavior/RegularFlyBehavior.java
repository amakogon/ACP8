package week3.stategy.behavior;

public class RegularFlyBehavior implements FlyBehavior{

    @Override
    public void fly() {
        System.out.println("I am flying like a duck");
    }
}
