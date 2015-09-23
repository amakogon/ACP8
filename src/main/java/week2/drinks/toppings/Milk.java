package week2.drinks.toppings;

import week2.drinks.core.Drink;
import week2.drinks.core.ToppingDecorator;

/**
 * .|\_/|,,_____,~~`
 * .(.".)~~     )`~}} Created by Juff
 * ..\o/\ /---~\\ ~}}
 * ...._//    _// ~}
 */
public class Milk extends ToppingDecorator{

    public Milk(Drink drink) {
        super(drink);
        description = "milk";
    }

    @Override
    public double cost() {
        return drink.cost()+1;
    }
}
