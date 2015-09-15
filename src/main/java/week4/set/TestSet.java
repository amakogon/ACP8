package week4.set;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class TestSet {
  public static void main(String[] args) {
    Set<Integer> integerSet = Sets.newTreeSet();
//    Set<Integer> integerSet = new HashSet<Integer>();
    integerSet.add(1);
    boolean isAdded = integerSet.add(1);
    System.out.println(isAdded);
    integerSet.add(1234);
    integerSet.add(12);
    integerSet.add(153);

    for (Integer integer : integerSet) {
      System.out.println(integer);
    }


/*
    Set<Human> humans = Sets.newTreeSet();
    humans.add(new Human("Oleg", 23));
    humans.add(new Human("Yoda", 432));


*/
    int[] mas = new int[29];
    System.out.println(Arrays.asList(mas).size());

    final List<Integer> integerList = Lists.newArrayList(Arrays.asList(1, 2, 5, 2, 7, 2, 3));
/*    for (int i = 0; i < integerList.size(); i++) {
      if (integerList.get(i).equals(2)) {
        integerList.remove(i);
      }
    }*/

//    java.util.ConcurrentModificationException
/*    for (Integer integer : integerList) {
      if (integer.equals(2)) {
        integerList.remove(integer);
      }
    }*/

    for (Iterator<Integer> iterator = integerList.iterator(); iterator.hasNext(); ) {
      Integer next = iterator.next();
      if (next.equals(2)) {
        iterator.remove();
      }
    }

    System.out.println(Iterables.toString(integerList));

  }
}
