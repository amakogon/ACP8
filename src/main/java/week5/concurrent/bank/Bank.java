package week5.concurrent.bank;

import java.util.concurrent.atomic.AtomicInteger;

public class Bank {
  //  private int moneyAmount;
  private AtomicInteger moneyAmount;

  public Bank(AtomicInteger moneyAmount) {
    this.moneyAmount = moneyAmount;
  }

  public AtomicInteger getMoneyAmount() {
    return moneyAmount;
  }
//can be synchronized
  public void takeFee(int fee) {
//    moneyAmount += fee;
//    synchronized (this) {
//
//    }
    moneyAmount.addAndGet(fee);
  }
}
