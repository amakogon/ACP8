package homework5.downloader;

/**
 * Created by Razer on 25.09.15.
 */
public class Start {
    public static void main(String[] args) {
        DownloadManager downloadManager = new DownloadManager("http://www.ex.ua/94052894?r=38495888,23777");
        downloadManager.download();
    }
}
