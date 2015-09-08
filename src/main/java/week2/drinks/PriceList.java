package week2.drinks;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public enum PriceList {
    PRICES;

    private Map<String, Double> priceMap;

    PriceList() {
        priceMap = new HashMap<>();
        setup();
    }

    private void setup() {
        String file = getClass().getClassLoader().getResource("prices").getFile();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String currLine;
            while ((currLine = reader.readLine()) != null) {
                String[] pair = currLine.split("=");
                String description = pair[0].trim();
                double price = Double.parseDouble(pair[1].trim());
                priceMap.put(description, price);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public double getPrice(String description) {
        Double price = priceMap.get(description);
        if(price == null) {
            throw new PriceNotFoundException(description);
        }
        return price;
    }
}
