package homework4.weather;

/**
 * Created by Razer on 24.09.15.
 */
public class WeatherDataXml {

    private Clouds clouds;

    @Override
    public String toString() {
        return "WeatherDataXml{" +
                ", temperature=" + temperature +
                '}';
    }

    private Wind wind;

    private Lastupdate lastupdate;

    private Humidity humidity;

    private Pressure pressure;

    private String visibility;

    private Precipitation precipitation;

    private Weather weather;

    private City city;

    private Temperature temperature;


    static class City {
        private String id;

        private Coord coord;

        private String name;

        private Sun sun;

        private String country;

        @Override
        public String toString() {
            return "City{" +
                    "coord=" + coord +
                    ", id='" + id + '\'' +
                    ", name='" + name + '\'' +
                    ", sun=" + sun +
                    ", country='" + country + '\'' +
                    '}';
        }
    }

    static class Coord {
    }

    static class Sun {
    }

    static class Temperature {

        private String min;

        private String unit;

        private String max;

        private String value;

        public void setMax(String max) {
            this.max = max;
        }

        public void setMin(String min) {
            this.min = min;
        }

        public void setUnit(String unit) {
            this.unit = unit;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getMax() {

            return max;
        }

        public String getMin() {
            return min;
        }

        public String getUnit() {
            return unit;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return "max='" + max + '\'' +
                    ", min='" + min + '\'' +
                    ", unit='" + unit + '\'' +
                    ", value='" + value + '\'' +
                    '}';
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

