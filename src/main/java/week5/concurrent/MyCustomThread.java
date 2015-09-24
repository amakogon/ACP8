package week5.concurrent;

public class MyCustomThread extends Thread {
  @Override
  public void run() {
    System.out.println("in my custom thread");
  }
}
