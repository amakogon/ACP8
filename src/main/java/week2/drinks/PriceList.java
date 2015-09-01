package week2.drinks;

public enum PriceList {
  PRICE_LIST;

  private double milkPrice;
  private double coffeePrice;

  private PriceList() {
    setup();
  }

  private void setup() {
//    TODO: read prices from config file
  }

  public double getMilkPrice() {
    return milkPrice;
  }

  public void setMilkPrice(double milkPrice) {
    this.milkPrice = milkPrice;
  }

  public double getCoffeePrice() {
    return coffeePrice;
  }

  public void setCoffeePrice(double coffeePrice) {
    this.coffeePrice = coffeePrice;
  }
}
