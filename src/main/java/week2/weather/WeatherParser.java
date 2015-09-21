package week2.weather;

import com.google.gson.Gson;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * |\_/|,,_____,~~`
 * (.".)~~     )`~}} Created by Juff
 *  \o/\ /---~\\ ~}}
 *    _//    _// ~}
 */
public class WeatherParser {
    private String text;
    WeatherData weatherData;

    public WeatherParser(String text) {
        this.text = text;
    }

    public void getWeather() {
        String s = text;

        Pattern p = Pattern.compile("\"\\w++\":\\[.*\\],");
        Matcher m = p.matcher(s);
        String[] splitted = s.split(m.pattern().toString());
        String simpleString = "";
        for (String itr : splitted) {
            simpleString = simpleString + itr.toString();
        }
        String arrayString = "";
        while (m.find()) {
            arrayString = arrayString + m.group(0);
        }
        arrayString = arrayString.substring(0, arrayString.length() - 1);

        arrayString = arrayString.replaceAll("\\]", "");
        String[] splittedArray = arrayString.split(":\\[");
        String name = splittedArray[0];
        splittedArray = splittedArray[1].split("\\}\\,\\{");

        for (int i = 0; i < splittedArray.length; i++) {
            splittedArray[i] = splittedArray[i].replaceAll("\\}", "");
            splittedArray[i] = splittedArray[i].replaceAll("\\{", "");
            splittedArray[i] = splittedArray[i].replaceAll("\\]", "");
            splittedArray[i] = splittedArray[i].replaceAll("\\[", "");
            splittedArray[i] = "{" + splittedArray[i] + "}";
        }

        Gson gson = new Gson();
        WeatherD[] weatherHolders = new WeatherD[splittedArray.length];

        String mainP = "";
        String descriprionP = "";
        WeatherD weatherD = new WeatherD();
        for (int i = 0; i < weatherHolders.length; i++) {
            weatherHolders[i] = gson.fromJson("{" + name + ":" + splittedArray[i] + "}", WeatherD.class);

            mainP = mainP + ", " + weatherHolders[i].getWeather().getMain();
            descriprionP = descriprionP + ", " + weatherHolders[i].getWeather().getDescription();
        }
        mainP = mainP.substring(2, mainP.length());
        descriprionP = descriprionP.substring(2, descriprionP.length());

        Weather weather = new Weather(mainP, descriprionP);

        String jtext = simpleString.substring(0, simpleString.length() - 1) + "," + name + ":" + gson.toJson(weather) + "}";

        weatherData = gson.fromJson(jtext, WeatherData.class);

        printWeather();
    }

    public void printWeather(){
        System.out.println(weatherData);
    }

    private class Weather {
        String main;
        String description;

        public Weather(String main, String description) {
            this.main = main;
            this.description = description;
        }
    }

    private class WeatherD {
        Weather weather;

        public Weather getWeather() {
            return weather;
        }

        private class Weather {
            String main;
            String description;

            public String getMain() {
                return main;
            }

            public String getDescription() {
                return description;
            }

            @Override
            public String toString() {
                return "Weather{" +
                        "main='" + main + '\'' +
                        ", description='" + description + '\'' +
                        '}';
            }
        }

        @Override
        public String toString() {
            return "WeatherD{" +
                    "weather=" + weather.toString() +
                    '}';
        }
    }

}
