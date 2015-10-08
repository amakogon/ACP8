package week7.day2.adapter;

import java.util.ArrayList;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    List<Duck> duckList = new ArrayList<>();
    duckList.add(new OrdinaryDuck());
    duckList.add(new OrdinaryDuck());
    duckList.add(new TurkeyAdapter(new SuperTurkey()));

    for (Duck duck : duckList) {
      duck.quake();
    }
  }
}
