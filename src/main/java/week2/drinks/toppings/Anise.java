package week2.drinks.toppings;

import week2.drinks.core.Drink;
import week2.drinks.core.Topping;

/**
 * .|\_/|,,_____,~~`
 * .(.".)~~     )`~}} Created by Juff
 * ..\o/\ /---~\\ ~}}
 * ...._//    _// ~}
 */
public class Anise extends Topping {

    public Anise(Drink drink) {
        super(drink);
        description = "anise";
    }

    @Override
    public Drink newDrink(Drink d) {
        return new Anise(d);
    }
}
