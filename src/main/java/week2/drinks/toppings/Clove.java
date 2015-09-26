package week2.drinks.toppings;

import week2.drinks.core.Drink;
import week2.drinks.core.Topping;

/**
 * .|\_/|,,_____,~~`
 * .(.".)~~     )`~}} Created by Juff
 * ..\o/\ /---~\\ ~}}
 * ...._//    _// ~}
 */
public class Clove extends Topping {

    public Clove(Drink drink) {
        super(drink);
        description = "clove";
    }

    @Override
    public Drink newDrink(Drink d) {
        return new Clove(d);
    }
}
