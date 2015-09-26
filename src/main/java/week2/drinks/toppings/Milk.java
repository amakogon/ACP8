package week2.drinks.toppings;

import week2.drinks.core.Drink;
import week2.drinks.core.Topping;

/**
 * .|\_/|,,_____,~~`
 * .(.".)~~     )`~}} Created by Juff
 * ..\o/\ /---~\\ ~}}
 * ...._//    _// ~}
 */
public class Milk extends Topping {


    public Milk(Drink drink) {
        super(drink);
        description = "milk";
    }

    @Override
    public Drink newDrink(Drink d) {
        return new Milk(d);
    }


}
