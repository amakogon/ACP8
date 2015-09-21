package week2.weather;

/**
 * |\_/|,,_____,~~`
 * (.".)~~     )`~}} Created by Juff
 *  \o/\ /---~\\ ~}}
 *    _//    _// ~}
 */

public class WeatherMain {


    public static void main(String[] args) {
       WeatherGetter weatherGetter = new WeatherGetter("Kiev",10);
        weatherGetter.start();
    }

}
