package homework5.downloader;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Razer on 25.09.15.
 */
public class DownloadManager {
    private String link;
    StringBuilder builder;

    public DownloadManager(String link) {
        this.link = link;
    }
    private String readUrl(){
        try {
            builder=new StringBuilder();
            URL url=new URL(link);
            InputStream in = new BufferedInputStream(url.openStream());
            BufferedReader reader=new BufferedReader(new InputStreamReader(in));
            while (reader.ready()){
                builder.append(reader.readLine());

            }
            in.close();
            reader.close();
            System.out.println(builder.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }
    public void download(){
        String page=readUrl();
        //System.out.println(page);
        parsePage(page);
    }
    private void parsePage(String page){
        final String load="href='/load/";
        String downloadAdress="";
        int startIndex;//=page.indexOf(load);
        for(int i=0;i<page.length();i++){
            startIndex=page.indexOf(load);
            downloadAdress=page.substring(startIndex + 12, startIndex + 20);
            System.out.println(downloadAdress);
        }
        System.out.println(downloadAdress);
    }

}
