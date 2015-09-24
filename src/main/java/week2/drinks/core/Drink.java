package week2.drinks.core;

/**
 * .|\_/|,,_____,~~`
 * .(.".)~~     )`~}} Created by Juff
 * ..\o/\ /---~\\ ~}}
 * ...._//    _// ~}
 */

public abstract class Drink {
    public static PriceList priceList = PriceList.getPriceList();

    private String description;

    protected Drink(){}

    public Drink(String description){
        this.description=description;
    }

    public String getDescription() {
        return description;
    }

    public double price(){
        return priceList.getPrice(description.toLowerCase());
    };



}
