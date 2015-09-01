package week2.drinks.toppings;

import week2.drinks.Drink;
import week2.drinks.ToppingDecorator;

public class Korica extends ToppingDecorator {

  public Korica(Drink drink) {
    super(drink);
    description = "korica";
  }

  @Override
  public double cost() {
    return 0.25 + drink.cost();
  }
}
