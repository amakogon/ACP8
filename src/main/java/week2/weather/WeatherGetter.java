package week2.weather;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
/**
 * |\_/|,,_____,~~`
 * (.".)~~     )`~}} Created by Juff
 *  \o/\ /---~\\ ~}}
 *    _//    _// ~}
 */

public class WeatherGetter extends Thread {
    String city;
    int updateFreq;
    public WeatherData weatherData;

    public WeatherGetter(String city, int updateFreq) {
        this.city = city;
        this.updateFreq = updateFreq;
    }

    @Override
    public void run() {
        while (!interrupted()) {
            updateWeather();
            try {
                Thread.sleep(updateFreq * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void updateWeather() {
        Gson gson = new Gson();

        String format = "json";
        String link = String.format("http://api.openweathermap.org/data/2.5/weather?q=%s&units=metric&mode=%s", city, format);
        try {
            URL url = new URL(link);
            URLConnection connection = url.openConnection();

            InputStream inputStream = connection.getInputStream();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            StringBuilder builder = new StringBuilder();
            while (bufferedReader.ready()) {
                builder.append(bufferedReader.readLine());
            }
            bufferedReader.close();
            inputStream.close();
            String jsonText = builder.toString();
            WeatherParser weatherParser = new WeatherParser(jsonText);
            weatherParser.getWeather();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}