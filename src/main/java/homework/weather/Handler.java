package homework.weather;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.Objects;

/**
 * Created by Home on 20.09.2015.
 */
public class Handler extends DefaultHandler {

    private String attrValue;
    private WeatherData weatherDate;

    public Handler(WeatherData weatherDate) {
        this.weatherDate = weatherDate;
    }
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (Objects.equals(qName, "temperature")) {
            weatherDate.setMinTemperature(Integer.parseInt(attributes.getValue("min")));
            weatherDate.setMaxTemperature(Integer.parseInt(attributes.getValue("max")));
        }
        else if (Objects.equals(qName, "humidity")) {
            weatherDate.setHumidity(Double.parseDouble(attributes.getValue("value")));
        }
        else if (Objects.equals(qName, "pressure")) {
            weatherDate.setPressure(Double.parseDouble(attributes.getValue("value")));
        }
        else if (Objects.equals(qName, "speed")) {
            weatherDate.setWindName(attributes.getValue("name"));
            weatherDate.setWindSpeed(Double.parseDouble(attributes.getValue("value")));
        }
        else if (Objects.equals(qName, "clouds")) {
            weatherDate.setClouds(attributes.getValue("name"));
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {

    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        attrValue = String.valueOf(ch, start, length);
    }
}
