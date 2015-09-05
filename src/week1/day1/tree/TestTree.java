package week1.day1.tree;

import java.util.ArrayList;
import java.util.Iterator;

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
        tree.add(11);

        tree.print();

      /*  System.out.println(tree.contains(1));
        Iterator iterator = tree.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("Stages = "+tree.getStages());*/
    }
}