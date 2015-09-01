package week2.drinks;

public abstract class ToppingDecorator extends Drink {
  protected String description;
  protected Drink drink;

  public ToppingDecorator(Drink drink) {
    this.drink = drink;
  }

  public String getDescription() {
    return drink.getDescription() + "," + description;
  }
}
