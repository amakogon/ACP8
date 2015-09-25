package homework.weather;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Observable;

/**
 * Created by Home on 20.09.2015.
 */
public class WeatherData extends Observable{

    private String city;
    private String format;

    private int minTemperature;
    private int maxTemperature;
    private double windSpeed;
    private String windName;
    private double humidity;
    private double pressure;
    private String clouds;

    public WeatherData(String city, String format) {
        this.city = city;
        this.format = format;
    }


    public int getMinTemperature() {
        return minTemperature;
    }

    public void setMinTemperature(int minTemperature) {
        this.minTemperature = minTemperature;
    }

    public int getMaxTemperature() {
        return maxTemperature;
    }

    public void setMaxTemperature(int maxTemperature) {
        this.maxTemperature = maxTemperature;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public String getWindName() {
        return windName;
    }

    public void setWindName(String windName) {
        this.windName = windName;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public String getClouds() {
        return clouds;
    }

    public void setClouds(String clouds) {
        this.clouds = clouds;
    }

    private URLConnection getConnection() {
        String link = String.format(
                "http://api.openweathermap.org/data/2.5/weather?q=%s&units=metric&mode=%s", city, format);
        URL url = null;
        URLConnection connection = null;
        try {
            url = new URL(link);
            connection = url.openConnection();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return connection;
    }

    public void updateData() {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = null;
        try {
            saxParser = saxParserFactory.newSAXParser();
            Handler saxHandler = new Handler(this);
            saxParser.parse(getConnection().getInputStream(), saxHandler);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        setChanged();
        notifyObservers();

    }
}
