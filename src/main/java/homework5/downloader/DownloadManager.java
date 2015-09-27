package homework5.downloader;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Razer on 25.09.15.
 */
public class DownloadManager {
    private String link;

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
        InputStream pageStream = readUrl();
        ArrayList links=parsePage(pageStream);
        //saveFiles(links);
    }

    private void saveFiles(ArrayList links ) {
        for(int i=0;i<links.size();i++){
        try {
            URL website = new URL("http://www.ex.ua/load/"+links.get(i));
            ReadableByteChannel rbc = Channels.newChannel(website.openStream());
            FileOutputStream fos = new FileOutputStream("/Users/johnsmith/IdeaProjects/ACP8/src/main/resources/download"+i);
            fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    }

    private ArrayList parsePage(InputStream pageStream) {
        ArrayList<String> links = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(pageStream));
        try {
            while (reader.ready()) {
                Pattern pattern=Pattern.compile("<a href='/get.+title='.+'");
                Matcher matcher = pattern.matcher(reader.readLine());
                if (matcher.find()) {
                    links.add(matcher.group());
                    System.out.println(matcher.group());
                }
            }
            for (int i = 0; i < links.size(); i++) {
                int number = Integer.valueOf(links.get(i).replaceAll("[\\D]", ""));
                String id=String.valueOf(number);
                links.remove(i);
                links.add(i,id);
                //System.out.println(((String) number));
            }
            //System.out.println(links.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return links;
    }
}
