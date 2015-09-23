package week2.drinks.drinks;

import week2.drinks.core.Drink;

/**
 * .|\_/|,,_____,~~`
 * .(.".)~~     )`~}} Created by Juff
 * ..\o/\ /---~\\ ~}}
 * ...._//    _// ~}
 */
public class Coffee extends Drink{

    public static final String DESCRIPTION = "Arabic Coffee";

    public Coffee(){
        super(DESCRIPTION);
    }
    @Override
    public double cost() {
        return 2;
    }
}
