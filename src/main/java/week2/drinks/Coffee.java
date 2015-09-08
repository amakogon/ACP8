package week2.drinks;

import static week2.drinks.PriceList.*;
public class Coffee extends Drink {

    public static final String DESCRIPTION = "Arabic coffee";

    public Coffee() {
    super(DESCRIPTION);
  }

  @Override
  public double cost() {
    return PRICES.getPrice(DESCRIPTION);
  }
}
