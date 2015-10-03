package homework.homework5.downloader;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Home on 01.10.2015.
 */
public interface LinksFinder {
    HashMap<String, String> getLinks(InputStream inputStream);
}
