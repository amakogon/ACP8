package homework4.weather;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;

/**
 * Created by Razer on 24.09.15.
 */
public class ParserManager {
    private String format;

    public ParserManager(String format) {
        this.format = format;
    }

    public void jsonParser(String jsonToString) {
        Gson gson = new Gson();
        WeatherDataGson weatherData = gson.fromJson(jsonToString, WeatherDataGson.class);
        System.out.println(weatherData.toString());
        //System.out.println(weatherData.toString());
    }

    public void xmlParser(String data) {
        XStream xStream = new XStream();
        xStream.alias("current", WeatherDataXml.class);
        xStream.alias("city",WeatherDataXml.City.class);
        //xStream.alias("temperature",WeatherDataXml.Temperature.class);
        WeatherDataXml weatherData = (WeatherDataXml) xStream.fromXML(data);
        System.out.println(weatherData.toString());
    }

    public void switchTypeOfParsing(String data) {
        switch (format) {
            case "json":
                jsonParser(data);
                break;
            case "xml":
                xmlParser(data);

        }
    }
}
