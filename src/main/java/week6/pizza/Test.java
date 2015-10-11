package week6.pizza;

public class Test {
  public static void main(String[] args) {
    PizzaBox pizzaBox = new PizzaBox();
    PizzaDiler diler = new PizzaDiler(pizzaBox);
    PizzaMaker maker = new PizzaMaker(pizzaBox);

    Thread dilerThread = new Thread(diler);
    dilerThread.setDaemon(true);
    dilerThread.start();
    Thread makerThread = new Thread(maker);
    makerThread.start();

    try {
      Thread.currentThread().sleep(3000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    System.out.println(pizzaBox.getPizzaCounter());


  }
}
