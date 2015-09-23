package week5.concurrent;

import java.util.Random;

public class Ex1 {
  public static void main(String[] args) {
    System.out.println("Hello!");
    MathEngineer engineer = new MathEngineer();
//    engineer.run();
    Thread thread = new Thread(engineer);
    thread.start();
/*    for (int i = 0; i < 10000000; i++) {
      Math.sin(Math.sqrt(i) + Math.atan(i));
    }*/

    Thread thread2 = new Thread(new Runnable() {
      @Override
      public void run() {
        System.out.println("in thread 2");
      }
    });
    thread2.start();
    System.out.println("msg 2");

    MyCustomThread customThread = new MyCustomThread();
    customThread.start();

  }

  public static class MathEngineer implements Runnable {
    @Override
    public void run() {
      double sin = 0;
      int range = new Random().nextInt(10000000);
      for (int i = 0; i < range; i++) {
        sin = Math.sin(Math.sqrt(i) + Math.atan(i));
      }
      String name = Thread.currentThread().getName();
      System.out.println(String.format("%s finished. Result = %f", name, sin));
    }
  }
}
