package week6.pizza;

public class PizzaBox {
  private int pizzaCounter;

  public synchronized boolean getPizzaPresent() {
    return pizzaCounter > 0;
  }

  public synchronized void getPizza() {
    pizzaCounter--;
  }

  public synchronized void putPizza() {
    pizzaCounter++;
  }


  public synchronized int getPizzaCounter() {
    return pizzaCounter;
  }
}
