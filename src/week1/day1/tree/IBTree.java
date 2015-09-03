package week1.day1.tree;

public interface IBTree<E>{

    boolean add(E element);

    boolean remove(E element);

    boolean contains(E element);

    int size();

    boolean isEmpty();

    void print();


}
