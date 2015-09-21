package homework4.weather;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Razer on 20.09.15.
 */
public class WeatherManager {
    private String city = "Kiev";
    private String format = "json";

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
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }

    public void getWeather() {
        String data = readFromURL(city, format);
        typeOfParsing(data);
    }

    private void jsonParser(String jsonToString) {
        //Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Gson gson=new Gson();
        jsonToString = jsonToString.replaceAll("\\[", "");
        jsonToString = jsonToString.replaceAll("\\]", "");
        WeatherData weatherData = gson.fromJson(jsonToString, WeatherData.class);
        System.out.println(weatherData);
        //WeatherData weatherData=gson.fromJson(data, WeatherData.class);
        //System.out.println(weatherData.toString());
        }

    private void xmlParser(String data) {
        XStream xStream = new XStream();
        xStream.alias("weather", WeatherData.class);
        String xml= (String) xStream.fromXML(data);
    }

    private void typeOfParsing(String data) {
        switch (format) {
            case "json":
                jsonParser(data);
                break;
            case "xml":
                xmlParser(data);

        }
    }

}
