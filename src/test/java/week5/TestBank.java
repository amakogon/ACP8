package week5;

import org.junit.Assert;
import org.junit.Test;
import week5.concurrent.bank.Bank;
import week5.concurrent.bank.Customer;

import java.util.concurrent.atomic.AtomicInteger;

public class TestBank {

  private static final int NUMBER_OF_CUSTOMERS = 500;
  private static final int CUSTOMER_MONEY = 100;
  private Bank bank;

  @Test
  public void testBank() throws InterruptedException {
    bank = new Bank(new AtomicInteger(0));
    for (int i = 0; i < NUMBER_OF_CUSTOMERS; i++) {
      makeFee();
    }
    int expectedMoney = NUMBER_OF_CUSTOMERS * CUSTOMER_MONEY;
    Assert.assertEquals(expectedMoney, bank.getMoneyAmount().get());
  }

  private void makeFee() {
    Customer customer = new Customer(bank);
    customer.setCustomerMoney(CUSTOMER_MONEY);

/*    Thread thread = new Thread(new Runnable() {
      @Override
      public void run() {
        while (customer.hasMoney()) {
          customer.makeFee(1);
        }
      }
    });*/
    Thread thread = new Thread(() -> {
      while (customer.hasMoney()) {
        customer.makeFee(1);
      }
    });


    thread.start();
    try {
      thread.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
