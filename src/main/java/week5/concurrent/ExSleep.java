package week5.concurrent;

public class ExSleep {
  public static void main(String[] args) throws InterruptedException {
/*    System.out.println("Hi!");
    Thread.currentThread().sleep(2000);
    System.out.println("Hello");*/

    Thread thread = new Thread(new Runnable() {
      @Override
      public void run() {
        while (true) {
          System.out.println("Bla bla bla");
          try {
            Thread.currentThread().sleep(1000);
          } catch (InterruptedException e) {
            System.out.println("I've been interrupted. Stopping my work");
            break;
          }
        }
      }
    });
    thread.start();

    Thread.currentThread().sleep(3000);
    System.out.println("I save you from this bla bla");
    thread.interrupt();
  }
}
