package week5.exDownloader;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

/**
 * .|\_/|,,_____,~~`
 * .(.".)~~     )`~}} Created by Juff
 * ..\o/\ /---~\\ ~}}
 * ...._//    _// ~}
 */
public class Downloader {

    private String url;
    private String fileName;

    public Downloader(String url, String fileName) {
        this.url = url;
        this.fileName = fileName;
    }

    public void download() throws IOException {
        URL link = new URL(url);
        HttpURLConnection httpURLConnection = new sun.net.www.protocol.http.HttpURLConnection(link, null);
        httpURLConnection.setInstanceFollowRedirects(true);
        httpURLConnection.connect();

        ReadableByteChannel rbc = Channels.newChannel(httpURLConnection.getInputStream());
        FileOutputStream fos = new FileOutputStream(fileName);
        fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
        fos.close();

    }


}
