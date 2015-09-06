package week1.day1.tree;

import java.util.ArrayList;
import java.util.Iterator;

public class TestTree {
    public static void main(String[] args) {
        IBTree<Integer> tree = new BTreeImpl<Integer>();
        tree.add(100);
        tree.add(50);
        tree.add(200);
        tree.add(10);
        tree.add(60);
        tree.add(150);
        tree.add(300);
        tree.add(55);
        tree.add(61);
        tree.add(9);
        tree.add(11);
        tree.add(54);
        tree.add(56);
        tree.add(148);
        tree.remove(200);

        System.out.println("Tree:\n");
        tree.print();
        tree.minRecurce();
        System.out.println("\nTree contain\'s 1?" + (tree.contains(1) ? " Yes!" : " No!"));

        System.out.println("\nIterator bypass:\n");
        Iterator iterator = tree.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }

        System.out.println("\n\nTree stages = " + tree.getStages());
    }
}