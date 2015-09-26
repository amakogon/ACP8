package week5.exDownloader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * .|\_/|,,_____,~~`
 * .(.".)~~     )`~}} Created by Juff
 * ..\o/\ /---~\\ ~}}
 * ...._//    _// ~}
 */
public class Connection {



    public URL readURL() throws IOException {
        return new URL(new BufferedReader(new InputStreamReader(System.in)).readLine());
    }

    public URLConnection getconnection(URL url) throws IOException {
        return url.openConnection();
    }
}
