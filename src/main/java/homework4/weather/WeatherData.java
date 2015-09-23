package homework4.weather;

/**
 * Created by Razer on 20.09.15.
 */
public class WeatherData {
    private int id;
    private String name;
    private Main main;
    public Weather[] weather;




    @Override
    public String toString() {
        return "WeatherData{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", main=" + main +
                '}';
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
            return "Main{" +
                    "humidity=" + humidity +
                    ", temp=" + temp +
                    ", pressure=" + pressure +
                    ", temp_min=" + temp_min +
                    ", temp_max=" + temp_max +
                    '}';
        }
    }

    static class Weather {
        String main;

        @Override
        public String toString() {
            return "Weathe{" +
                    "main='" + main + '\'' +
                    '}';
        }
    }

}


