package week2.drinks;

public class Tea extends Drink {

    public static final String DESCRIPTION = "Ceilon tea";

    public Tea() {
        super(DESCRIPTION);
    }

    @Override
    public double cost() {
        return PriceList.PRICES.getPrice(DESCRIPTION);
    }
}
