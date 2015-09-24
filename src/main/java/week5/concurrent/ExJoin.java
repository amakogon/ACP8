package week5.concurrent;

public class ExJoin {
  public static void main(String[] args) throws InterruptedException {
    Thread thread = new Thread(new Ex1.MathEngineer(), "John Smith");
    thread.start();

    Thread thread1 = new Thread(new Ex1.MathEngineer(), "Lara Croft");
    thread1.start();

    thread.join();
    thread1.join();
    System.out.println("End of main");
  }
}
