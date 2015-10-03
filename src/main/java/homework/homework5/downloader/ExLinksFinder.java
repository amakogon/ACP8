package homework.homework5.downloader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Home on 01.10.2015.
 */
public class ExLinksFinder implements LinksFinder {

    private ArrayList<String> links;

    @Override
    public HashMap<String, String> getLinks(InputStream inputStream) {
        findLinks(inputStream);
        return divideLinkToNamePath(links);
    }

    private void findLinks(InputStream pageStream) {
        links = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(pageStream));
        try {
            while (reader.ready()) {
                Pattern pattern = Pattern.compile("<a href='/get.+title='.+'");
                Matcher matcher = pattern.matcher(reader.readLine());
                if (matcher.find()) {
                    links.add(handleLinks(matcher.group()));
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String handleLinks(String link) {
        link = link.replaceAll("<a href='/", "");
        link = link.replaceAll("get", "http://www.ex.ua/load");
        link = link.replaceAll("'", "");
        link = link.replaceAll("rel=nofollow", "");
        link = link.replaceAll(" title=", "<>");
        return link;
    }

    private HashMap divideLinkToNamePath(ArrayList<String> links) {
        HashMap<String, String> nameAndPathLink = new HashMap<>();

        for (String link : links) {
            String pathFile = link.split("<")[0];
            String nameFile = link.split(">")[1];
            nameAndPathLink.put(nameFile, pathFile);
        }
        return nameAndPathLink;
    }
}
