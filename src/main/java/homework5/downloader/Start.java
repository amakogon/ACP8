package homework5.downloader;

/**
 * Created by Razer on 25.09.15.
 */
public class Start {
    public static void main(String[] args) {
        DownloadManager downloadManager = new DownloadManager("http://www.ex.ua/94005526?r=94005569,607160,23775");
        downloadManager.download();
    }
}
