package week6.pizza;

public class PizzaDiler implements Runnable {

  private PizzaBox pizzaBox;

  public PizzaDiler(PizzaBox pizzaBox) {
    this.pizzaBox = pizzaBox;
  }

  @Override
  public void run() {
    while (true) {
      if (pizzaBox.getPizzaPresent()) {
        System.out.println("took pizza");
        pizzaBox.getPizza();
      }
    }
  }
}
