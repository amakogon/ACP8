package week3.stategy;

import week3.stategy.behavior.FlyBehavior;
import week3.stategy.behavior.RegularFlyBehavior;

public class MallardDuck extends Duck {

    private FlyBehavior flyBehavior;

    public MallardDuck() {
        this.flyBehavior = new RegularFlyBehavior();
    }

    @Override
    public void quack() {
        System.out.println("quack quack");
    }

    @Override
    public void fly() {
        flyBehavior.fly();
    }
}
