package week5.exDownloader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

/**
 * .|\_/|,,_____,~~`
 * .(.".)~~     )`~}} Created by Juff
 * ..\o/\ /---~\\ ~}}
 * ...._//    _// ~}
 */
public class ExDownloader {


    public static void main(String[] args) throws IOException {

        Connection connection = new Connection();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Input ex.ua URL");
        ReaderParser readerParser = new ReaderParser(connection.getconnection(connection.readURL()).getInputStream());
        HashMap<String, String> map = readerParser.getLinksNamesMap();
        System.out.println("Input path");
        String path = bufferedReader.readLine();



        for (Map.Entry<String, String> entry:map.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
            Downloader downloader = new Downloader(entry.getKey(),path+entry.getValue());
            downloader.download();
        }

    }


}
