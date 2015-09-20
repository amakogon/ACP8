package homework4.weather;

import com.google.gson.Gson;

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
public class ConnectionManager {
    private String city="Kiev";
    private String format="json";

    public String readFromURL(String city, String format) {
        String link = String.format("http://api.openweathermap.org/data/2.5/weather?q=%s&mode=%s", city, format);
        //String link = "http://xml.weather.yahoo.com/forecastrss?p=UPXX0016&u=c";
        StringBuilder builder=null;
        try {
            URL url = new URL(link);
            URLConnection connection = url.openConnection();
            InputStream inputStream = connection.getInputStream();
            BufferedReader reader=new BufferedReader(new InputStreamReader(inputStream));
            builder=new StringBuilder();
            while (reader.ready()){
                builder.append(reader.readLine());
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  builder.toString();
    }

    public void connect() {
        String data=readFromURL(city, format);
        jsonParser(data);

    }

    public void jsonParser(String data){
        Gson gson=new Gson();
        gson.fromJson(data,WeatherData.class);
        System.out.println(gson);
    }

    public void xmlParser(String data){}

}
