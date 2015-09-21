package homework4.weather;

import homework4.weather.ConnectionManager;

/**
 * Created by Razer on 20.09.15.
 */
public class Start {
    public static void main(String[] args) {
    ConnectionManager connectionManager=new ConnectionManager();
        connectionManager.connect();
    }
}
