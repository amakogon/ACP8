package homework.homework4;

/**
 * Created by Home on 20.09.2015.
 */
public class TestWeather {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData("Kiev", "xml");
        CurrentWeather currentWeather = new CurrentWeather(weatherData);
        weatherData.updateData();
    }
}
