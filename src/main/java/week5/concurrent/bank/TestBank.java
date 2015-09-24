package week5.concurrent.bank;

import java.util.concurrent.atomic.AtomicInteger;

public class TestBank {
  public static void main(String[] args) throws InterruptedException {
    Bank bank = new Bank(new AtomicInteger(100));

    Customer customer1 = new Customer(bank);
    customer1.setCustomerMoney(300);

    Customer customer2 = new Customer(bank);
    customer2.setCustomerMoney(500);

    Thread thread1 = new Thread(new Runnable() {
      @Override
      public void run() {
        while (customer1.hasMoney()) {
          customer1.makeFee(1);
          System.out.println("bob");
        }
      }
    });
    Thread thread2 = new Thread(new Runnable() {
      @Override
      public void run() {
        while (customer2.hasMoney()) {
          customer2.makeFee(1);
          System.out.println("tom");
        }
      }
    });

    thread1.start();
    thread2.start();
    thread1.join();
    thread2.join();
    System.out.println("Bank money = " + bank.getMoneyAmount());


  }
}
