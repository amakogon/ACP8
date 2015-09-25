package homework4.weather;

/**
 * Created by Razer on 24.09.15.
 */
public class WeatherDataXml {

    private Clouds clouds;

    private Wind wind;

    private Lastupdate lastupdate;

    private Humidity humidity;

    private Pressure pressure;

    private String visibility;

    private Precipitation precipitation;

    private Weather weather;

    private City city;

    private Temperature temperature;

    @Override
    public String toString() {
        return "Weather in " + city.toString() + " is " +
                temperature.toString() + " ";
    }


    static class City {
        private String id;

        private Coord coord;

        private String name;

        private Sun sun;

        private String country;

        @Override
        public String toString() {
            return name + " ";
        }
    }

    static class Coord {
    }

    static class Sun {
    }

    static class Temperature {

        private double min;

        private double unit;

        private double max;

        private String value;


        @Override
        public String toString() {
            return "max='" + max + '\'' +
                    ", min='" + min + '\'' +
                    ", unit='" + unit + '\'' +
                    ", value='" + value + '\'';
        }
    }

    static class Wind {
        private Speed speed;

        private Direction direction;

        private String gusts;

        static class Speed {
        }

        static class Direction {
        }
    }

    static class Humidity {
    }

    static class Weather {
    }

    static class Lastupdate {
    }

    static class Pressure {
    }

    static class Precipitation {
    }

    static class Clouds {
    }

}

