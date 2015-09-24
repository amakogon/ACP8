package week5.generic;

import week1.day2.Human;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class Ex2 {
  public static void main(String[] args) {
    Container<String> container = new Container<>("5");

    Integer[] integers = new Integer[20];
    ArrayHelper.fillWithRandomValues(integers);

    System.out.println(Arrays.toString(integers));
    ArrayHelper.sort(integers);
    System.out.println(Arrays.toString(integers));

    Human[] humans = new Human[3];
    humans[0] = new Human("Oleg", 21);
    humans[1] = new Human("Andrew", 43);
    humans[2] = new Human("Igor", 15);

    System.out.println(Arrays.toString(humans));
    ArrayHelper.<Human>sort(humans);

//    Set<Container<String>> set = Sets.newTreeSet();
//    Set<Container<String>> set = createTreeSet();
//    set.add(container);
  }

  private static <T extends Comparable<T>> Set<T> createTreeSet() {
    return new TreeSet<>();
  }
}
