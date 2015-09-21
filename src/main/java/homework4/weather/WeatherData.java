package homework4.weather;

/**
 * Created by Razer on 20.09.15.
 */
public class WeatherData {
    private double main;
    private String wind;

    public double getMain() {
        return main;
    }

    public void setMain(double main) {
        this.main = main;
    }

    public String getWind() {
        return wind;
    }

    public void setWind(String wind) {
        this.wind = wind;
    }

    @Override
    public String toString() {
        return "WeatherData{" +
                "main=" + main +
                ", window='" + wind + '\'' +
                '}';
    }
}

