package week1.day1;

public interface IBTree<E> {

  boolean add(E elem);

  boolean remove(E elem);

  boolean contains(E elem);

  int size();

  boolean isEmpty();


}
