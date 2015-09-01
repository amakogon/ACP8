package week2.drinks;

public class Tea extends Drink {

  public Tea() {
    super("Ceilon tea");
  }

  @Override
  public double cost() {
    return 1.5;
  }
}
