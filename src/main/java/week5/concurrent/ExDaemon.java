package week5.concurrent;

public class ExDaemon {
  public static void main(String[] args) {
    Thread thread = new Thread(new Runnable() {
      @Override
      public void run() {
        while (true){
          //do nothing
        }
      }
    });
    thread.setDaemon(true);
    thread.start();

    System.out.println("End of main");
  }
}
