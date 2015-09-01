import org.junit.Assert;
import org.junit.Test;

public class TestSum {

  @Test
  public void testSumTwoNumbers(){
    int a = 3;
    int b = 4;
    int actualResult = a + b;
    int expectedResult = 7;

    Assert.assertEquals(expectedResult, actualResult);
  }


}
