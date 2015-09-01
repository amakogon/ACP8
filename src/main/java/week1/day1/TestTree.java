package week1.day1;

public class TestTree {
  public static void main(String[] args) {
    IBTree<Integer> tree = new BTreeImpl<Integer>();
    tree.add(18);
    tree.add(38);
    tree.add(100);
    tree.add(6);
    tree.add(4);
    tree.add(10);
    tree.add(15);
    tree.add(17);
    tree.add(8);
    tree.add(6);
    tree.add(9);
    tree.add(8);

    tree.remove(10);
    tree.remove(9);

    tree.isEmpty();



  }
}
