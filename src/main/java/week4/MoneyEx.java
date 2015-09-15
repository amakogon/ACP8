package week4;

import java.math.BigDecimal;

public class MoneyEx {
  public static void main(String[] args) {
    System.out.println(1.03 - 1.02);

    double startMoney = 2;

    double candyPrice = 0.1;

    while (startMoney > candyPrice) {
      startMoney = startMoney - candyPrice;
    }

    System.out.println(startMoney);
//    BigDecimal bigDecimal =
    long money = 200;

  }
}
