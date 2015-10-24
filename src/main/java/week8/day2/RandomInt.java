package week8.day2;

import java.util.Random;

public class RandomInt {
  private int value = new Random().nextInt(10);

  public int getValue() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }
}
