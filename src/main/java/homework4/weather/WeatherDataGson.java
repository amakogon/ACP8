package homework4.weather;

import java.util.Arrays;

/**
 * Created by Razer on 20.09.15.
 */
public class WeatherDataGson {
    private int id;
    private String name;
    private Main main;
    public Weather[] weather;




    @Override
    public String toString() {
        return "Weather in "+name+" is "+ Arrays.toString(weather) + main.toString();
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
            return  "humidity=" + humidity +
                    ", temp=" + temp +
                    ", pressure=" + pressure +
                    ", temp_min=" + temp_min +
                    ", temp_max=" + temp_max +
                    '}';
        }
    }

    static class Weather {
        String main;
        String description;

        @Override
        public String toString() {
            return "Weathe{" +
                    "main='" + main + '\'' +
                    '}';
        }
    }

}


