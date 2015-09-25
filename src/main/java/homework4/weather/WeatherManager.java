package homework4.weather;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Properties;

/**
 * Created by Razer on 20.09.15.
 */
public class WeatherManager {
    private String city;
    private String format;
    private Properties properties;

    public WeatherManager() {
        initSettings();
        city = properties.getProperty("defaultcity");
        format = properties.getProperty("format");
    }

    public WeatherManager(String city) {
        initSettings();
        this.city = city;
        format = properties.getProperty("format");
    }

    public void initSettings() {
        properties = new Properties();
        try {
            properties.load(ClassLoader.getSystemResourceAsStream("weatherSettings"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String readFromURL(String city, String format) {
        String link = String.format("http://api.openweathermap.org/data/2.5/weather?q=%s&mode=%s", city, format);
        //String link = "http://xml.weather.yahoo.com/forecastrss?p=UPXX0016&u=c";
        StringBuilder builder = null;
        try {
            URL url = new URL(link);
            URLConnection connection = url.openConnection();
            InputStream inputStream = connection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            builder = new StringBuilder();
            while (reader.ready()) {
                builder.append(reader.readLine());
            }
            System.out.println(builder.toString());
            reader.close();
            inputStream.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }

    public void getWeather() {
        ParserManager parserManager = new ParserManager(format);
        String data = readFromURL(city, format);
        parserManager.switchTypeOfParsing(data);
    }
}
