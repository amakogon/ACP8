package week2.drinks.toppings;

import week2.drinks.core.Drink;
import week2.drinks.core.Topping;

/**
 * .|\_/|,,_____,~~`
 * .(.".)~~     )`~}} Created by Juff
 * ..\o/\ /---~\\ ~}}
 * ...._//    _// ~}
 */
public class Mint extends Topping {

    public Mint(Drink drink) {
        super(drink);
        description = "mint";
    }

    @Override
    public Drink newDrink(Drink d) {
        return new Mint(d);
    }
}
