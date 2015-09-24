package week5.concurrent.bank;

public class Customer {
  private final Bank bank;

  private int customerMoney;

  public Customer(Bank bank) {
    this.bank = bank;
  }

  public Bank getBank() {
    return bank;
  }

  public int getCustomerMoney() {
    return customerMoney;
  }

  public void setCustomerMoney(int customerMoney) {
    this.customerMoney = customerMoney;
  }

  public void makeFee(int fee) {
    this.customerMoney -= fee;
    bank.takeFee(fee);
  }
  public boolean hasMoney(){
    return customerMoney != 0;
  }
}
