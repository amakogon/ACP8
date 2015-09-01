package week2.drinks;

import week2.drinks.toppings.Korica;
import week2.drinks.toppings.Milk;

public class Kassa {
  public static void main(String[] args) {
    Drink drink = new Coffee();
    drink = new Korica(drink);
    drink = new Korica(drink);
    drink = new Milk(drink);

    System.out.println(drink.getDescription());
    System.out.println(drink.cost());
    System.out.println("~~~~~~~~~~~~~~~~~~");

    Drink tea = new Korica(new Milk(new Tea()));
    System.out.println(tea.getDescription());
    System.out.println(tea.cost());
  }
}
