package week1.day2;

public class TestHashMap {
  public static void main(String[] args) {
    MyHashMap<Integer, String> map = new MyHashMap<>(5);

    map.put(6, "6");
    map.put(16, "16");

    System.out.println(map.get(6));
    System.out.println(map.get(16));

  }
}
