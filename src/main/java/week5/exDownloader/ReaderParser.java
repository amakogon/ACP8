package week5.exDownloader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * .|\_/|,,_____,~~`
 * .(.".)~~     )`~}} Created by Juff
 * ..\o/\ /---~\\ ~}}
 * ...._//    _// ~}
 */
public class ReaderParser {

    private InputStream inputStream;



    public ReaderParser(InputStream inputStream) throws IOException {
        this.inputStream = inputStream;
    }

    private String[] getLinks() throws IOException

    {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        ArrayList<String> links = new ArrayList<>();
        while (bufferedReader.ready()) {
            Pattern p = Pattern.compile("<a href=\'/get.+title=\'.+\'");
            Matcher m = p.matcher(bufferedReader.readLine());
            if (m.find()) {
                links.add(m.group(0));
            }

        }
        bufferedReader.close();

        String[] linksArray = new String[links.size()];
        for (int i = 0; i <linksArray.length ; i++) {
            String s = links.get(i);
            s=s.replaceAll("<a href='","");
            s=s.replaceAll("' title='","***|***");
            s=s.replaceAll("' rel='nofollow","");
            s=s.replaceAll("'","");
            s="http://www.ex.ua"+s;
            s=s.replaceAll("get","load");

            linksArray[i] = s;
        }

        return linksArray;
    }

    public HashMap<String,String> getLinksNamesMap() throws IOException {
        HashMap<String,String> map = new HashMap<>();
        String[] array = getLinks();
        for(String s:array){
            map.put(s.split("\\*\\*\\*\\|\\*\\*\\*")[0], s.split("\\*\\*\\*\\|\\*\\*\\*")[1]);
        }

        return map;
    }

}
