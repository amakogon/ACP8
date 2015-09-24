package week2.drinks;

import week2.drinks.core.Drink;
import week2.drinks.core.PriceList;
import week2.drinks.drinks.Tea;
import week2.drinks.toppings.Cinnamon;
import week2.drinks.drinks.Coffee;
import week2.drinks.toppings.Milk;

import java.io.IOException;

/**
 * .|\_/|,,_____,~~`
 * .(.".)~~     )`~}} Created by Juff
 * ..\o/\ /---~\\ ~}}
 * ...._//    _// ~}
 */
public class Cassier {
    public static PriceList priceList;
    public static void main(String[] args) throws IOException {

        priceList = priceList.getPriceList();

        Coffee coffee = new Coffee();
        Drink coffeeWithMilk = new Milk(new Coffee());
        Drink coffeeWithMilkWinhCinnamon = new Cinnamon(new Milk(new Coffee()));
        Drink teaWithMilk = new Milk(new Tea());
        System.out.println(coffee.getDescription()+" "+ coffee.price());
        System.out.println(coffeeWithMilk.getDescription() + " " + coffeeWithMilk.price());
        System.out.println(coffeeWithMilkWinhCinnamon.getDescription()+ " " + coffeeWithMilkWinhCinnamon.price());
        System.out.println(teaWithMilk.getDescription()+" "+teaWithMilk.price());
    }
}
