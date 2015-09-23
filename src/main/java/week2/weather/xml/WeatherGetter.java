package week2.weather.xml;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Locale;

/**
 * .|\_/|,,_____,~~`
 * .(.".)~~     )`~}} Created by Juff.
 * ..\o/\ /---~\\ ~}}
 * ... _//    _// ~}
 */
public class WeatherGetter {
    private String city;
    private static HashMap<String, HashMap<String, String>> weather = new HashMap<>();

    public WeatherGetter(String city) {
        this.city = city;
    }

    public void getWeather() throws IOException, ParserConfigurationException, SAXException {

        String link = String.format("http://api.openweathermap.org/data/2.5/weather?q=%s&units=metric&mode=xml", city);
        URL url = new URL(link);
        URLConnection connection = url.openConnection();

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder builder = new StringBuilder();
        while (reader.ready()) {
            builder.append(reader.readLine());
        }
        reader.close();

        connection = url.openConnection();
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(connection.getInputStream());
        document.getDocumentElement().normalize();
        Element element = document.getDocumentElement();

        createWeatherHolder(element);
        printWeather();

    }

    private static Node[] convertToArray(NodeList list) {
        int length = list.getLength();
        Node[] copy = new Node[length];

        for (int n = 0; n < length; ++n)
            copy[n] = list.item(n);

        return copy;
    }

    private static void createWeatherHolder(Node n) {
        HashMap<String, String> tmpMap = new HashMap<>();
        HashMap<String, HashMap<String, String>> map = new HashMap<>();

        NamedNodeMap nodeMap = n.getAttributes();
        if (nodeMap != null) {
            for (int i = 0; i < nodeMap.getLength(); i++) {
                if (nodeMap.item(i) != null) {
                    String[] splited = nodeMap.item(i).toString().split("=");
                    tmpMap.put(splited[0], splited[1]);
                } else continue;

            }
            weather.put(n.getNodeName(), new HashMap<String, String>(tmpMap));
        }


        tmpMap.clear();

        if (n.getFirstChild() == null) {
            return;
        }
        Node currentNode = n;
        NodeList nodeList = n.getChildNodes();
        Node[] nodeArray = convertToArray(nodeList);

        for (int i = 0; i < nodeArray.length; i++) {

            createWeatherHolder(nodeArray[i]);
        }
    }

    private static void printWeather() {
        System.out.println("Now is " + new SimpleDateFormat("HH:mm:ss", Locale.ENGLISH).format(System.currentTimeMillis()) +
                "\nThe weather in " + weather.get("city").get("name").replaceAll("\"", "") + ":\n" +
                "Temperature is " + weather.get("temperature").get("value").replaceAll("\"", "") + "\n" +
                "Pressure is " + weather.get("pressure").get("value").replaceAll("\"", "") + " hPa\n" +
                "Min temperature is " + weather.get("temperature").get("min").replaceAll("\"", "") + "\n" +
                "Max temperature is " + weather.get("temperature").get("max").replaceAll("\"", "") + "\n" +
                "Wind speed is " + weather.get("speed").get("value").replaceAll("\"", "") + " mps \n" +
                "Wind direction is " + weather.get("direction").get("name").replaceAll("\"", "") + "\n");
    }


    private static void printNode(Node n) {

        System.out.println("---" + n.getNodeName());
        NamedNodeMap nodeMap = n.getAttributes();
        if (nodeMap != null) {
            for (int i = 0; i < nodeMap.getLength(); i++) {
                if (nodeMap.item(i) != null) {
                    System.out.println("\t\t" + nodeMap.item(i));
                } else continue;

            }
        }

        if (n.getFirstChild() == null) {
            return;
        }
        Node currentNode = n;
        NodeList nodeList = n.getChildNodes();
        Node[] nodeArray = convertToArray(nodeList);

        for (int i = 0; i < nodeArray.length; i++) {

            printNode(nodeArray[i]);
        }
    }
}
