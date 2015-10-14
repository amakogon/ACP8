package week2.weather.json;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * |\_/|,,_____,~~`
 * (.".)~~     )`~}} Created by Juff
 *  \o/\ /---~\\ ~}}
 *    _//    _// ~}
 */

public class WeatherData {
    private int id;
    private String name;
    private Main main;
    private Weather weather;
    private Wind wind;
    private Sys sys;

    @Override
    public String toString() {
        return "\nNow is "+new SimpleDateFormat("HH:mm:ss", Locale.ENGLISH).format(System.currentTimeMillis())+"\nThe weather in " + name + " is " + weather.toString() + main.toString() + wind.toString() + sys.toString();
    }


    private class Weather {
        String main;
        String description;

        @Override
        public String toString() {
            return main.toLowerCase() + ", " + description.toLowerCase();
        }
    }

    private class Main {
        double temp;
        double pressure;
        double temp_min;
        double temp_max;


        @Override
        public String toString() {
            return "\nTemperature is " + temp + (temp >= 0 ? " above zero" : " below zero") +
                    "\nPresure is " + pressure + " hPa" +
                    "\nMin temperature is " + temp_min + (temp_min >= 0 ? " above zero" : " below zero") +
                    "\nMax temperature is " + temp_max + (temp_max >= 0 ? " above zero" : " below zero");

        }
    }

    private class Wind {
        double speed;
        double deg;

        @Override
        public String toString() {
            return "\nWind speed is " + speed + " mps \nWind direction is " + deg + " degrees by North";
        }
    }

    private class Sys {
        long sunrise;
        long sunset;

        @Override
        public String toString() {
            return "\nSunrise at " + new SimpleDateFormat("hh:mm:ss", Locale.ENGLISH).format(new Date(sunrise)) + "" +
                    "\nSunset  at " + new SimpleDateFormat("HH:mm:ss", Locale.ENGLISH).format(new Date(sunset));
        }
    }

}