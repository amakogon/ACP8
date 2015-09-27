package homework5.downloader;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
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
        InputStream in = null;
        try {
            //builder = new StringBuilder();
            URL url = new URL(link);
            in = new BufferedInputStream(url.openStream());
            //BufferedReader reader = new BufferedReader(new InputStreamReader(in));
//            while (reader.ready()) {
//                builder.append(reader.readLine());
//            }
            in.close();
            //reader.close();
            //System.out.println(builder.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return in;
    }

    public void download() {
        InputStream pageStream = readUrl();
        System.out.println(pageStream.toString());
        parsePage(pageStream);
    }

    //    private void parsePage(String page){
//        ArrayList <String> links =new ArrayList<>();
//        final String load="href='/load/";
//        String downloadAdress="";
//        int startIndex;//=page.indexOf(load);
//        for(int i=0;i<page.length();i++){
//            startIndex=page.indexOf(load);
//            downloadAdress=page.substring(startIndex + 12, startIndex + 20);
//            System.out.println(downloadAdress);
//        }
//        System.out.println(downloadAdress);
//    }
    private void parsePage(InputStream pageStream) {
        ArrayList<String> links = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(pageStream));
        //<a href='/load/196030649'
        //"<a href=\'/get.+title=\'.+\'"
        //<a href='/get/195197443' title='Who am I - Kein System ist sicher.
        //"^<a href=\'/load/.+\'$"
        try {
            while (reader.ready()) {
                Pattern pattern = Pattern.compile("href=");
                Matcher matcher = pattern.matcher(reader.readLine());
                if (matcher.find()) {
                    System.out.println(matcher.group());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}
