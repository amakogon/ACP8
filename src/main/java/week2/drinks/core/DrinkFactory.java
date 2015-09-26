package week2.drinks.core;

import week2.drinks.drinks.Coffee;
import week2.drinks.drinks.Tea;

/**
 * .|\_/|,,_____,~~`
 * .(.".)~~     )`~}} Created by Juff
 * ..\o/\ /---~\\ ~}}
 * ...._//    _// ~}
 */
public class DrinkFactory {

    public Drink getDrink(String s) {
        Drink drink = null;
        if (s.toLowerCase().equals("coffee")) {
            drink = new Coffee();
        }

        if (s.toLowerCase().equals("tea")) {
            drink = new Tea();
        }
        return drink;
    }
}
