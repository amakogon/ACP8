package week2.drinks.core;

import week2.drinks.drinks.Coffee;
import week2.drinks.drinks.Tea;
import week2.drinks.toppings.*;

/**
 * .|\_/|,,_____,~~`
 * .(.".)~~     )`~}} Created by Juff
 * ..\o/\ /---~\\ ~}}
 * ...._//    _// ~}
 */
public class ToppingFactory {

    public Drink getDrink(String s, Drink d) {

        Drink drink = d;

        if (s.toLowerCase().equals("milk")) {
            drink = new Milk(d);
        }

        if (s.toLowerCase().equals("cinnamon")) {
            drink = new Cinnamon(d);
        }

        if (s.toLowerCase().equals("cardamon")) {
            drink = new Cardamon(d);
        }

        if (s.toLowerCase().equals("clove")) {
            drink = new Clove(d);
        }

        if (s.toLowerCase().equals("mint")) {
            drink = new Mint(d);
        }

        if (s.toLowerCase().equals("anise")) {
            drink = new Anise(d);
        }
        return drink;
    }
}
