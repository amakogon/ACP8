package week2.weather;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;


/*{"coord":{"lon":30.52,"lat":50.43},"weather":[{"id":800,"main":"Clear","description":"Sky is Clear","icon":"01d"}],"base":"cmc stations","main":{"temp":27.77,"pressure":1012,"humidity":22,"temp_min":26,"temp_max":29},"wind":{"speed":4,"deg":140},"clouds":{"all":0},"dt":1442761200,"sys":{"type":1,"id":7348,"message":0.004,"country":"UA","sunrise":1442720479,"sunset":1442764816},"id":703448,"name":"Kiev","cod":200}*/
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
            jsonText = jsonText.replaceAll("\\[", "");
            jsonText = jsonText.replaceAll("\\]", "");
            WeatherData weatherData = gson.fromJson(jsonText, WeatherData.class);
            System.out.println(weatherData);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
