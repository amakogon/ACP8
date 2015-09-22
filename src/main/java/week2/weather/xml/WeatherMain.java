package week2.weather.xml;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * .|\_/|,,_____,~~`
 * .(.".)~~     )`~}} Created by Juff.
 * ..\o/\ /---~\\ ~}}
 * ... _//    _// ~}
 */
public class WeatherMain {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        WeatherGetter weatherGetter = new WeatherGetter("Kiev");
        weatherGetter.getWeather();
    }
}
