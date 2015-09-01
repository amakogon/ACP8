package week2.drinks;

public abstract class Drink {
  private String description;

  protected Drink() {
  }

  public Drink(String description) {
    this.description = description;
  }

  public String getDescription() {
    return description;
  }

  public abstract double cost();

}
