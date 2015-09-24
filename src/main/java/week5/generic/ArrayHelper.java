package week5.generic;

import java.util.Arrays;
import java.util.Random;

public class ArrayHelper {

  public static <T extends Comparable<T>> void sort(T[] array) {
    Arrays.sort(array);
  }

  public static void fillWithRandomValues(Integer[] array) {
    Random random = new Random();
    for (int i = 0; i < array.length; i++) {
      array[i] = random.nextInt(50);
    }
  }
}
