package week5.concurrent;

import java.util.concurrent.TimeUnit;

public class ExChickenAndEgg {
  public static void main(String[] args) {
    Thread threadEgg = new Thread(new Runnable() {
      @Override
      public void run() {
        while (true){
          System.out.println("EGG!");
          try {
            Thread.currentThread().sleep(TimeUnit.SECONDS.toMillis(1));
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      }
    });
    Thread threadChicken = new Thread(new Runnable() {
      @Override
      public void run() {
        while (true){
          System.out.println("Chicken!");
          try {
            Thread.currentThread().sleep(TimeUnit.SECONDS.toMillis(1));
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      }
    });

    threadChicken.start();
    threadEgg.start();

  }
}
