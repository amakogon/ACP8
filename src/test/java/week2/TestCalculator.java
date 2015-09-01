package week2;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestCalculator {
  Calculator calculator;

  @Before
  public void beforeTests() {
    calculator = new Calculator();
    System.out.println("BEFORE TESTS");
  }

  @Test
  public void testSum() {
    Assert.assertEquals(3, calculator.sum(1, 2));
    System.out.println("TESTS");
  }

  @Test
  public void testMinus() {
    Assert.assertEquals(5, calculator.minus(7, 2));
    System.out.println("TESTS");
  }

  @After
  public void afterMethod() {
    System.out.println("AFTER");
  }

}
