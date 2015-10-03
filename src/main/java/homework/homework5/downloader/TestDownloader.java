package homework.homework5.downloader;

/**
 * Created by Home on 02.10.2015.
 */
public class TestDownloader {
    public static void main(String[] args) {
        Downloader downloader = new Downloader("http://www.ex.ua/94312649?r=1988,23775");
        downloader.download();
    }
}
