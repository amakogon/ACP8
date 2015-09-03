package week1.day1.tree;
public class TestTree {
    public static void main(String[] args) {
        IBTree<Integer> tree = new BTreeImpl<Integer>();
        tree.add(5);
        tree.add(1);
        tree.add(10);
        tree.add(0);
        tree.add(3);
        tree.add(1);
        tree.add(4);
        tree.add(8);
        tree.add(11);
        //tree.remove(5);
        System.out.println();
        //System.out.println(tree.contains(5));
       // tree.add(3);
        //tree.add(5);
        tree.print();




    }
}