package homework5.downloader;

/**
 * Created by Razer on 25.09.15.
 */
public class Start {
    public static void main(String[] args) {
        DownloadManager downloadManager = new DownloadManager("http://www.ex.ua/94021641?r=2,23775");
        downloadManager.download();
    }
}
