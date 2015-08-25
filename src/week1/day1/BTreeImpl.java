package week1.day1;

public class BTreeImpl<E extends Comparable<E>> implements IBTree<E> {

  private Node<E> root;
  private int size;

  @Override
  public boolean add(E elem) {
    if (isEmpty()) {
      root = new Node<E>(elem, null, null, null);
      size++;
      return true;
    }

    Node<E> currentNode = root;
    while (true) {
      if (elem.compareTo(currentNode.elem) < 0) {
        if (currentNode.hasLeftChild()) {
          currentNode = currentNode.leftChild;
        } else {
          currentNode.leftChild = new Node<E>(elem, null, null, currentNode);
          break;
        }
      } else {
        if (currentNode.hasRightChild()) {
          currentNode = currentNode.rightChild;
        } else {
          currentNode.rightChild = new Node<E>(elem, null, null, currentNode);
          break;
        }
      }
    }
    size++;
    return true;
  }

  @Override
  public boolean remove(E elem) {

    Node<E> target = node(elem);
    if (target == null) {
      return false;
    }

    Node<E> targetLeftChild = target.leftChild;
    Node<E> targetRightChild = target.rightChild;

    if(!target.hasLeftChild() && !target.hasRightChild()){

    }

    return false;
  }

  @Override
  public boolean contains(E elem) {
    return node(elem) != null;
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public boolean isEmpty() {
    return size() == 0;
  }

  private Node<E> node(E elem) {
    Node<E> result = null;
    if (isEmpty()) {
      return result;
    }
    for (Node<E> current = root; current != null; ) {
      if (elem.compareTo(current.elem) < 0) {
        current = current.leftChild;
      } else if (elem.compareTo(current.elem) > 0) {
        current = current.rightChild;
      } else {
        result = current;
        break;
      }
    }
    return result;
  }

  private static class Node<E> {
    E elem;
    Node<E> rightChild;
    Node<E> leftChild;
    Node<E> parent;

    private Node(E elem, Node<E> right, Node<E> left, Node<E> parent) {
      this.elem = elem;
      this.rightChild = right;
      this.leftChild = left;
      this.parent = parent;
    }

    boolean hasLeftChild() {
      return leftChild != null;
    }

    boolean hasRightChild() {
      return rightChild != null;
    }

    boolean hasParent() {
      return parent != null;
    }
  }

}
