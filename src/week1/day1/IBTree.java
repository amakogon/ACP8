package week1.day1;

public interface IBTree<E> extends Iterable<E>{

  boolean add(E elem);

  boolean remove(E elem);

  boolean contains(E elem);

  int size();

  boolean isEmpty();

  E max();

  E min();


}
