package week2.drinks.toppings;

import week2.drinks.Drink;
import week2.drinks.ToppingDecorator;

public class Milk extends ToppingDecorator {
  public Milk(Drink drink) {
    super(drink);
    description = "milk";
  }

  @Override
  public double cost() {
    return 0.4 + drink.cost();
  }
}
