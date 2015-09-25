package homework.weather;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Home on 20.09.2015.
 */
public class CurrentWeather implements Observer {
    private Observable weatherData;

    private int minTemperature;
    private int maxTemperature;
    private double windSpeed;
    private String windName;
    private double humidity;
    private double pressure;
    private String clouds;

    public CurrentWeather(Observable weatherData) {
        this.weatherData = weatherData;
        weatherData.addObserver(this);
    }
    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof WeatherData) {
            WeatherData data = (WeatherData) o;
            minTemperature = data.getMinTemperature();
            maxTemperature = data.getMaxTemperature();
            windSpeed = data.getWindSpeed();
            windName = data.getWindName();
            humidity = data.getHumidity();
            pressure = data.getPressure();
            clouds = data.getClouds();

            outputInfo();
        }
    }

    private void outputInfo() {
        String info = String.format("City - Kiev\nmin temperature %d C\nmax temperature %d C\n" +
                "speed of wind %.2f m/s\n%s\n" +
                "humidity %.0f%%\n" +
                "pressure %.0f\nclouds: %s\n" +
                "" ,minTemperature, maxTemperature, windSpeed, windName, humidity, pressure, clouds);
        System.out.println(info);
        System.out.println("HAVE A NICE DAY!");
    }
}
