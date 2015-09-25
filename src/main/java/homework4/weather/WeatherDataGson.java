package homework4.weather;

/**
 * Created by Razer on 20.09.15.
 */
public class WeatherDataGson {
    public static final int KELVIN = 273;
    private int id;
    private String name;
    private Main main;
    private Weather[] weather;


    @Override
    public String toString() {
        return "Weather in " + name + " is" + weather[0].toString() + " " + main.toString();
    }

    //nested
    static class Main {
        double temp;
        double humidity;
        double pressure;
        double temp_min;
        double temp_max;

        @Override
        public String toString() {
            return "humidity=" + humidity +
                    " temp=" + Math.round(temp - KELVIN) +
                    " pressure=" + pressure + " hPa" +
                    " temp min=" + Math.round(temp_min - KELVIN) + " C" +
                    " temp max=" + Math.round(temp_max - KELVIN) + " C";
        }
    }

    //nested
    static class Weather {
        String main;
        //String description;

        @Override
        public String toString() {
            return " " + main.toLowerCase();
        }
    }

}


