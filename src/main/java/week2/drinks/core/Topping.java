package week2.drinks.core;

/**
 * .|\_/|,,_____,~~`
 * .(.".)~~     )`~}} Created by Juff
 * ..\o/\ /---~\\ ~}}
 * ...._//    _// ~}
 */
public abstract class Topping extends Drink {

    protected String description;

    private Drink drink;

    public Topping(Drink drink) {
        this.drink = drink;

    }


    @Override
    public String getDescription() {
        return drink.getDescription()+ " + "+description;
    }

    @Override
    public double price() {
        return drink.price()+priceList.getPrice(description.toLowerCase());
    }
}
