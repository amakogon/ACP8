package week8;

import java.util.EmptyStackException;
import java.util.List;

public class MyStack<E> {
  private List<E> list;

  public void push(E e) {
    list.add(e);
  }

  public E pop() {
    if (list.isEmpty()) {
      throw new EmptyStackException();
    }
    return list.get(list.size() - 1);
  }
}
