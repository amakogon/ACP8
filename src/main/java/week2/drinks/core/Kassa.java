package week2.drinks.core;

import week2.drinks.drinks.Coffee;
import week2.drinks.toppings.Milk;

import java.util.Date;

/**
 * .|\_/|,,_____,~~`
 * .(.".)~~     )`~}} Created by Juff
 * ..\o/\ /---~\\ ~}}
 * ...._//    _// ~}
 */
public class Kassa {
    public static void main(String[] args) {
        Drink CoffeeWithMilk = new Milk(new Coffee());
        System.out.println(CoffeeWithMilk.getDescription());
        System.out.println(CoffeeWithMilk.cost());
    }
}
