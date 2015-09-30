package homework5.downloader;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Razer on 25.09.15.
 */
public class DownloadManager {
    private String link;
    private final String pathToSave = "/Users/johnsmith/IdeaProjects/ACP8/src/main/resources/download/";

    public DownloadManager(String link) {
        this.link = link;
    }

    private InputStream readUrl() {
        InputStream inputStream = null;
        try {
            URL url = new URL(link);
            URLConnection connection = url.openConnection();
            //System.out.println(connection.getContentLength());
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
        HashMap<String, String> parsedLinks = parserManager.parsePage(pageStream);
        saveFiles(parsedLinks);
    }

    private void saveFiles(HashMap<String, String> parsedLinks) {
        for (Map.Entry<String, String> entry : parsedLinks.entrySet()) {
            BufferedInputStream in;
            FileOutputStream out;
            try {
                URL url = new URL(entry.getKey());
                URLConnection conn = url.openConnection();
                int size = conn.getContentLength();
                System.out.println("Start download :" + entry.getValue());
//                URL url = new URL(entry.getKey());
//                URLConnection connection=url.openConnection();
//                System.out.println(connection.getContentLength());
//                ReadableByteChannel rbc = Channels.newChannel(connection.getInputStream());
//                FileOutputStream fos = new FileOutputStream(pathToSave+entry.getValue());
//                fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
                in = new BufferedInputStream(url.openStream());
                out = new FileOutputStream(pathToSave + entry.getValue());
                byte data[] = new byte[1024];
                int count;
                double sumCount = 0.0;

                while ((count = in.read(data, 0, 1024)) != -1) {
                    out.write(data, 0, count);

                    sumCount += count;
                    if (size > 0) {
                        double loadPercentage = (sumCount / size * 100.0);
                        String formattedDouble = String.format("%.2f", loadPercentage);
                        System.out.print("\r" + formattedDouble);
                    }
                }
                System.out.println();
                System.out.println("Download is done :" + entry.getValue());

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
