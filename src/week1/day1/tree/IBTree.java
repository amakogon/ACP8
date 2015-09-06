package week1.day1.tree;

public interface IBTree<E> extends Iterable<E> {

    boolean add(E element);

    boolean remove(E element);

    boolean contains(E element);

    int getStages();

    int size();

    boolean isEmpty();

    void print();

    void minRecurce();



}
