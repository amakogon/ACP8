package week5.concurrent;

import java.util.Random;

public class ExSync {
  private static Random random = new Random();
  static int startValue = 0;
  private static Object monitor = new Object();

  public static void main(String[] args) throws InterruptedException {

    Thread thread = new Thread(new Runnable() {
      @Override
      public void run() {
        for (int i = 0; i < 50; i++) {
          increment(1);
          try {
            Thread.currentThread().sleep(15);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      }
    });
    Thread thread2 = new Thread(new Runnable() {
      @Override
      public void run() {
        for (int i = 0; i < 50; i++) {
          increment(1);
          try {
            Thread.currentThread().sleep(15);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      }
    });
    thread.start();
    thread2.start();

    thread.join();
    thread2.join();
    System.out.println(startValue);
  }

  private static void increment(int val) {
    synchronized (monitor) {
      startValue += val;
    }
  }
}
