package week6.pizza;

import java.util.concurrent.atomic.AtomicInteger;

public class PizzaMaker implements Runnable {

  private PizzaBox pizzaBox;
  private AtomicInteger done = new AtomicInteger();

  public PizzaMaker(PizzaBox pizzaBox) {
    this.pizzaBox = pizzaBox;
  }

  @Override
  public void run() {
    while (done.get() < 50) {
      if (!pizzaBox.getPizzaPresent()) {
        System.out.println("put pizza");
        pizzaBox.putPizza();
        done.incrementAndGet();
      }
    }
  }
}
