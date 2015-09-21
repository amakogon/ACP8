package week2.weather;

import com.google.gson.Gson;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * |\_/|,,_____,~~`
 * (.".)~~     )`~}} Created by Juff on 21.09.2015.
 * \o/\ /---~\\ ~}}
 * _//    _// ~}
 */
public class WeatherParser {




    public Weather getWeather() {
        String s = "{\"coord\":{\"lon\":30.52,\"lat\":50.43},\"weather\":[{\"id\":701,\"main\":\"Mist\",\"description\":\"mist\",\"icon\":\"50d\"},{\"id\":300,\"main\":\"Drizzle\",\"description\":\"light intensity drizzle\",\"icon\":\"09d\"}],\"base\":\"stations\",\"main\":{\"temp\":16.34,\"pressure\":1011,\"humidity\":100,\"temp_min\":16,\"temp_max\":17},\"visibility\":2800,\"wind\":{\"speed\":3,\"deg\":340},\"clouds\":{\"all\":90},\"dt\":1442817000,\"sys\":{\"type\":1,\"id\":7358,\"message\":0.0063,\"country\":\"UA\",\"sunrise\":1442806940,\"sunset\":1442851127},\"id\":703448,\"name\":\"Kiev\",\"cod\":200}";
        Pattern p = Pattern.compile("\"\\w++\":\\[.*\\],");
        Matcher m = p.matcher(s);
        String[] splitted = s.split(m.pattern().toString());
        String simpleString = "";
        for(String itr:splitted){
            simpleString = simpleString+itr.toString();
        }
        String arrayString = "";
        while (m.find()){
            arrayString=arrayString+m.group(0);
        }
        arrayString = arrayString.substring(0,arrayString.length()-1);

        arrayString=arrayString.replaceAll("\\]", "");
        String[] splittedArray = arrayString.split(":\\[");
        String name = splittedArray[0];
        splittedArray = splittedArray[1].split("\\}\\,\\{");

        for (int i = 0; i <splittedArray.length ; i++) {
            splittedArray[i] = splittedArray[i].replaceAll("\\}", "");
            splittedArray[i] = splittedArray[i].replaceAll("\\{","");
            splittedArray[i] = "{"+splittedArray[i]+"}";
        }

        Gson gson = new Gson();
        WeatherD[] weatherHolders = new WeatherD[splittedArray.length];

        String mainP = "";
        String descriprionP = "";
        WeatherD weatherD = new WeatherD();
        for (int i = 0; i <weatherHolders.length ; i++) {
            weatherHolders[i] = gson.fromJson("{"+name+":"+splittedArray[i]+"}", WeatherD.class);
            //System.out.println(weatherHolders[i]);
            mainP = mainP+", "+weatherHolders[i].getWeather().getMain();
            descriprionP = descriprionP+", "+weatherHolders[i].getWeather().getDescription();
        }
        mainP = mainP.substring(2,mainP.length());
        descriprionP = descriprionP.substring(2,descriprionP.length());
        //System.out.println(mainP);
       //System.out.println(descriprionP);
        return new Weather(mainP,descriprionP);
    }
    private class Weather{
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

        private class Weather{
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
