package week2.drinks;

import static week2.drinks.PriceList.*;
public class Coffee extends Drink {

  public Coffee() {
    super("Arabic coffee");
  }

  @Override
  public double cost() {
    return PRICES.getCoffeePrice();
  }
}
