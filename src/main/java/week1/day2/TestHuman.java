package week1.day2;

public class TestHuman {
  public static void main(String[] args) {
    Human teska = new Human("Oleg", 25);
    Human oleg = new Human("Oleg", 25);

    System.out.println(teska == oleg);

    System.out.println(oleg.hashCode());
    System.out.println(teska.hashCode());
  }
}
