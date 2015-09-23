package week2.drinks.core;

/**
 * .|\_/|,,_____,~~`
 * .(.".)~~     )`~}} Created by Juff
 * ..\o/\ /---~\\ ~}}
 * ...._//    _// ~}
 */
public abstract class ToppingDecorator extends Drink {
    protected String description;
    protected Drink drink;

    public ToppingDecorator(Drink drink){
        this.drink=drink;
    }

    @Override
    public double cost() {
        return 0;
    }

    @Override
    public String getDescription() {
        return drink.getDescription()+ " with " +description;
    }
}
