package week5.generic;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Ex3 {
  public static void main(String[] args) {
    Set<Integer> integerSet = new HashSet<>(Arrays.asList(1, 2, 4));
    Set<Integer> integerSet1 = new HashSet<>(Arrays.asList(8, 15, 3));
    Set<Double> doubles = new HashSet<>(Arrays.asList(6.4, 7.2, 3.1));

    Set<Number> resultSet = union(integerSet, doubles);

    System.out.println(resultSet);
  }

  public static Set<Number> union(Set<? extends Number> set1, Set<? extends Number> set2) {
    Set<Number> set = new HashSet<>(set1);
    set.addAll(set2);
    return set;
  }
}
