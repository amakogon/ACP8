package week2;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestList {
  private static List<Integer> list;

  @BeforeClass
  public static void beforeClass() {
    list = new ArrayList<>();
  }

  @Before
  public void before() {
    list.clear();
  }

  @Test
  public void testAdd() {
    list.add(1);
    list.add(2);
    list.add(5);

    Assert.assertEquals(3, list.size());
    Assert.assertEquals(Integer.valueOf(1), list.get(0));
    Assert.assertTrue(list.contains(5));
  }

  @Test
  public void testIncorrectGetIndex() {
    list.add(4);
    Assert.assertTrue(list.size() == 1);

    int index = 150;
    Exception exception = null;
    try {
      list.get(index);
    } catch (IndexOutOfBoundsException e) {
      exception = e;
      Assert.assertEquals("Index: 150, Size: 1", e.getMessage());
    }
    Assert.assertNotNull(exception);
  }

  @Test(expected = IndexOutOfBoundsException.class)
  public void testIncorrectGetIndexNewVersion() {
    list.add(4);
    Assert.assertTrue(list.size() == 1);

    int index = 0;
    list.get(index);
  }

  @AfterClass
  public static void afterClass() {
    System.out.println("after class");
  }
}
