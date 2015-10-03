package homework.homework5.downloader;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Home on 01.10.2015.
 */
public class Downloader {
    private String resourceLink;
    private String pathToSave = "C:\\downloadedFrom/";

    public Downloader(String resourceLink) {
        this.resourceLink = resourceLink;
    }

    public void download() {
        ExLinksFinder linksFinder = new ExLinksFinder();
        saveFiles(linksFinder.getLinks(getInputStream()));
    }

    private InputStream getInputStream() {
        InputStream inputStream = null;
        URL url = null;
        try {
            url = new URL(resourceLink);
            URLConnection connection = url.openConnection();
            inputStream = connection.getInputStream();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return inputStream;

    }

    private void saveFiles(HashMap<String, String> links) {
        for (Map.Entry<String, String> entry : links.entrySet()) {
            URL url = null;
            try {
                url = new URL(entry.getValue());
                URLConnection connection = url.openConnection();
                System.out.println(connection.getContentLength());
                ReadableByteChannel rbc = Channels.newChannel(connection.getInputStream());
                FileOutputStream fos = new FileOutputStream(pathToSave + entry.getKey());
                System.out.println("Start download :" + entry.getKey());
                fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
                System.out.println("Download is done :" + entry.getKey());
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
