package week3.stategy.behavior;

import week3.stategy.Duck;

public class SuperDuck extends Duck {
    private FlyBehavior flyBehavior;

    public SuperDuck() {
        this.flyBehavior = new SuperCoolFlyBehavior();
    }

    @Override
    public void quack() {

    }

    @Override
    public void fly() {
        flyBehavior.fly();
    }
}
