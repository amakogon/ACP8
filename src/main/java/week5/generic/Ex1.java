package week5.generic;

import java.util.ArrayList;
import java.util.List;

public class Ex1 {
  public static void main(String[] args) {
    List<Integer> list = new ArrayList<>();
    list.add(1);
    list.add(3);

    List objectsList = list;

    //don't work
//    List<Object> objects = list;

    List<Object> objects = new ArrayList<>();
    print(objects);
    printGeneric(list);
    printGeneric(list);
    printGeneric(objectsList);

  }

  public static void print(List list) {
    System.out.println(list);
  }

  public static void printGeneric(List<?> list) {
    System.out.println(list);
  }
}
