package homework5.downloader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Razer on 27.09.15.
 */
public class ParserManager {

    private ArrayList<String> links;

    public HashMap parsePage(InputStream pageStream) {
        copyLinksFromStream(pageStream);
        String[] link = createNewLinks();
        return divLinksToKeyValue(link);
    }

    private void copyLinksFromStream(InputStream pageStream) {
        links = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(pageStream));
        try {
            while (reader.ready()) {
                Pattern pattern = Pattern.compile("<a href='/get.+title='.+'");
                Matcher matcher = pattern.matcher(reader.readLine());
                if (matcher.find()) {
                    links.add(matcher.group());
                    //System.out.println(matcher.group());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String[] createNewLinks() {
        String[] ArrayLinks = new String[links.size()];
        for (int i = 0; i < links.size(); i++) {
            String newLink = links.get(i);
            newLink = newLink.replaceAll("<a href='/", "");
            newLink = newLink.replaceAll("get", "http://www.ex.ua/load");
            newLink = newLink.replaceAll("'", "");
            newLink = newLink.replaceAll("rel=nofollow", "");
            newLink = newLink.replaceAll(" title=", "<>");
            ArrayLinks[i] = newLink;
            //System.out.println(newLink);
        }
        return ArrayLinks;
    }

    private HashMap divLinksToKeyValue(String[] ArrayLinks) {
        HashMap<String, String> parsedLinks = new HashMap<>();

        for (String newLink : ArrayLinks) {
            String address = newLink.split("<")[0];
            String nameOfFile = newLink.split(">")[1];
            parsedLinks.put(address, nameOfFile);
        }
        return parsedLinks;
    }
}
