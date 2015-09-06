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

        System.out.println("Tree:\n");
        tree.print();

        System.out.println("\nTree contain\'s 1?" + (tree.contains(1) ? " Yes!" : " No!"));

        System.out.println("\nIterator bypass:\n");
        Iterator iterator = tree.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }

        System.out.println("\n\nTree stages = " + tree.getStages());
    }
}