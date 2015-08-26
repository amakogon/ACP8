package week1.day1;

import java.util.Iterator;

public class BTreeImpl<E extends Comparable<E>> implements IBTree<E> {

  private Node<E> root;
  private int size;

  @Override
  public boolean add(E elem) {
    if (isEmpty()) {
      root = Node.newNodeWithoutChilds(elem, null);
      size++;
      return true;
    }

    Node<E> currentNode = root;
    while (true) {
      if (elem.compareTo(currentNode.elem) < 0) {
        if (currentNode.hasLeftChild()) {
          currentNode = currentNode.leftChild;
        } else {
          currentNode.leftChild = Node.newNodeWithoutChilds(elem, currentNode);
          break;
        }
      } else {
        if (currentNode.hasRightChild()) {
          currentNode = currentNode.rightChild;
        } else {
          currentNode.rightChild = Node.newNodeWithoutChilds(elem, currentNode);
          break;
        }
      }
    }
    size++;
    return true;
  }

  @Override
  public boolean remove(E elem) {
    Node<E> targetNode = node(elem);
    if (targetNode == null) {
      return false;
    }

    if (targetNode.hasLeftChild() && targetNode.hasRightChild()) {
      Node<E> max = max(targetNode.leftChild);
      targetNode.elem = max.elem;

      if (!max.hasLeftChild()) {
        unlinkNode(max);
      } else {
        max.leftChild.parent = max.parent;
        max.parent.rightChild = max.leftChild;
      }
    } else {
      unlinkNode(targetNode);
    }
    size--;
    return true;
  }

  private Node<E> max(Node<E> node) {
    Node<E> max = node;
    while (max.rightChild != null) {
      max = max.rightChild;
    }
    return max;
  }

  private void unlinkNode(Node<E> node) {
    Node<E> parentNode = node.parent;
    if (!node.hasLeftChild() && !node.hasRightChild()) {
      if (parentNode.leftChild == node) {
        parentNode.leftChild = null;
      } else {
        parentNode.rightChild = null;
      }
    } else if (!node.hasRightChild()) {
      parentNode.leftChild = node.leftChild;
      node.leftChild.parent = parentNode;
    } else if (!node.hasLeftChild()) {
      parentNode.rightChild = node.rightChild;
      node.rightChild.parent = parentNode;
    }
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

  @Override
  public E max() {
    return isEmpty() ? null : max(root).elem;
  }

  @Override
  public E min() {
    return null;
  }

  private Node<E> node(E elem) {
    if (isEmpty()) {
      return null;
    }
    Node<E> result = null;
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

  @Override
  public Iterator<E> iterator() {
    return null;
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

    static <E> Node<E> newNode(E elem, Node<E> right, Node<E> left, Node<E> parent) {
      return new Node<>(elem, right, left, parent);
    }

    static <E> Node<E> newNodeWithoutChilds(E elem, Node<E> parent) {
      return newNode(elem, null, null, parent);
    }
  }

}
