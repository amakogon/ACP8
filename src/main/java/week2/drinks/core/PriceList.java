package week2.drinks.core;



import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

/**
 * .|\_/|,,_____,~~`
 * .(.".)~~     )`~}} Created by Juff
 * ..\o/\ /---~\\ ~}}
 * ...._//    _// ~}
 */
public class PriceList {
    private Properties properties = new Properties();
    private static PriceList instance = new PriceList();
    private HashMap<String, Double> priceMap;
    private PriceList() {

        try {
            properties.load(new FileReader(ClassLoader.getSystemResource("priceList.ini").getPath()));
            priceMap = new HashMap<>();
            for(Object o:properties.keySet()){
                priceMap.put(String.valueOf(o).toLowerCase(), Double.parseDouble((String) properties.get((String) o)));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public double getPrice (String drinkDescription){
        return priceMap.get(drinkDescription);
    }



    public static PriceList getPriceList() {
        return instance;
    }


}
