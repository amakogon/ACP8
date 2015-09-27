package homework5.downloader;

import java.io.FileNotFoundException;
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
 * Created by Razer on 25.09.15.
 */
public class DownloadManager {
    private String link;
    private final String  pathToSave="/Users/johnsmith/IdeaProjects/ACP8/src/main/resources/download";

    public DownloadManager(String link) {
        this.link = link;
    }

    private InputStream readUrl() {
        InputStream inputStream = null;
        try {
            URL url = new URL(link);
            URLConnection connection = url.openConnection();
            inputStream = connection.getInputStream();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return inputStream;
    }

    public void download() {
        ParserManager parserManager = new ParserManager();
        InputStream pageStream = readUrl();
        HashMap<String,String> parsedLinks = parserManager.parsePage(pageStream);
        saveFiles(parsedLinks);
    }

    private void saveFiles(HashMap<String,String> parsedLinks) {
        for (Map.Entry<String, String> entry:parsedLinks.entrySet()){
            try {
                URL website = new URL(entry.getKey());
                ReadableByteChannel rbc = Channels.newChannel(website.openStream());
                FileOutputStream fos = new FileOutputStream(pathToSave+entry.getValue());
                fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
                System.out.println("Download "+entry.getValue());

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
