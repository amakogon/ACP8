package week2.weather;


public class WeatherMain {


    public static void main(String[] args) {
        WeatherGetter weatherGetter = new WeatherGetter("Kiev",10);
        weatherGetter.start();
    }

}
