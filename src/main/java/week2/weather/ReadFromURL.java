package week2.weather;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class ReadFromURL {
  public static void main(String[] args) throws IOException {
    String city = "London";
    String format = "xml";
    String link = String.format("http://api.openweathermap.org/data/2.5/weather?q=%s&mode=%s", city, format);
    URL url = new URL(link);
    URLConnection connection = url.openConnection();

    InputStream inputStream = null;

    try {
      inputStream = connection.getInputStream();
      BufferedReader reader =
        new BufferedReader(new InputStreamReader(inputStream));

      StringBuilder builder = new StringBuilder();
      while (reader.ready()) {
        builder.append(reader.readLine());
      }
      System.out.println(builder);
    } finally {
      if (inputStream != null) {
        inputStream.close();
      }
    }
  }
}
