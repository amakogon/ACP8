package week2.drinks.toppings;

import week2.drinks.core.Drink;
import week2.drinks.core.Topping;

/**
 * .|\_/|,,_____,~~`
 * .(.".)~~     )`~}} Created by Juff
 * ..\o/\ /---~\\ ~}}
 * ...._//    _// ~}
 */
public class Cardamon extends Topping {

    public Cardamon(Drink drink) {
        super(drink);
        description = "cardamon";
    }

    @Override
    public Drink newDrink(Drink d) {
        return new Cardamon(d);
    }
}
