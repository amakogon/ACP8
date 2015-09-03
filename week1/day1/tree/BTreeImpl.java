package week1.day1.tree;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;

public class BTreeImpl<E extends Comparable<E>> implements IBTree<E>, Iterable<E> {

    int size;
    Node<E> root;

    @Override
    //OK
    public boolean add(E element) {
        if (isEmpty()) {
            root = createNodeNoChilds(element, null); //Creating root
            return true;
        }

        Node<E> currentNode = root;
        while (true) {
            if (element.compareTo(currentNode.element) < 0) { // GO LEFT
                if (currentNode.hasLeftChild()) { // IF NO END, GO TO NEXT LEFT CHILD
                    currentNode = currentNode.leftChild;
                } else {
                    currentNode.leftChild = createNodeNoChilds(element, currentNode);
                    break;
                }
            } else { // GO RIGHT
                if (currentNode.hasRightChild()) { //IF NO END, GO TO NEXT RIGHT CHILD
                    currentNode = currentNode.rightChild;
                } else {
                    currentNode.rightChild = createNodeNoChilds(element, currentNode);
                    break;
                }
            }
        }
        return true;
    }


    @Override
    public boolean remove(E element) {
        Node<E> targetNode = findNode(element);

        //if no lements in the tree
        if (size() == 0) return false;

        //if the target has no childs
        if (targetNode.hasNoChild()) {
            if (targetNode.equals(targetNode.parent.leftChild)) {
                targetNode.parent.leftChild = null;
                size--;
                return true;
            }
            if (targetNode.equals(targetNode.parent.rightChild)) {
                targetNode.parent.rightChild = null;
                size--;
                return true;
            }
            targetNode.parent = null;
            size--;
            return true;
        }
        //if the target has only left child
        if (targetNode.hasLeftChild() && !targetNode.hasRightChild()) {
            targetNode.leftChild.parent = targetNode.parent;

            if (targetNode.equals(targetNode.parent.leftChild)) {
                targetNode.parent.leftChild = targetNode.leftChild;
                size--;
                return true;
            }
            if (targetNode.equals(targetNode.parent.rightChild)) {
                targetNode.parent.rightChild = targetNode.leftChild;
                size--;
                return true;
            }
        }
        //if the target has only right child
        if (!targetNode.hasLeftChild() && targetNode.hasRightChild()) {
            targetNode.rightChild.parent = targetNode.parent;

            if (targetNode.equals(targetNode.parent.leftChild)) {
                targetNode.parent.leftChild = targetNode.rightChild;
                size--;
                return true;
            }
            if (targetNode.equals(targetNode.parent.rightChild)) {
                targetNode.parent.rightChild = targetNode.rightChild;
                size--;
                return true;
            }
        }
        //if the target has 2 childs
        if (targetNode.hasLeftChild() && targetNode.hasRightChild()) {
            Node<E> finalChild = goMaxRight(targetNode.leftChild);
            targetNode.element = finalChild.element;
            finalChild.parent.rightChild = null;
            size--;
        }
        return true;
    }

    @Override
    //OK
    public boolean contains(E element) {
        //System.out.println(findNode(element));
        return findNode(element) != null;
    }

    @Override
    //OK
    public int size() {
        return size;
    }

    @Override
    //OK
    public boolean isEmpty() {
        return size() == 0;
    }


    //Creating no child node
    private Node<E> createNodeNoChilds(E element, Node<E> currentNode) {
        return createNode(element, currentNode, null, null);
    }

    //Creating node - full
    private Node<E> createNode(E element, Node<E> parent, Node<E> leftChild, Node<E> rightChild) {
        size++;
        return new Node<E>(element, parent, leftChild, rightChild);
    }

    //Node search (by element)
    private Node<E> findNode(E element) {
        Node<E> currentNode = root;
        Node<E> result = null;
        if (isEmpty()) {
            return null;
        }
        while (true) {
            if (element.compareTo(currentNode.element) < 0) { //GO LEFT

                if (!currentNode.hasLeftChild()) {
                    result = null;
                    break;
                } else if (currentNode.leftChild.element.compareTo(element) == 0) {
                    result = currentNode.leftChild;
                    break;
                } else {
                    currentNode = currentNode.leftChild;
                }
            } else if (element.compareTo(currentNode.element) == 0) { //STOP
                result = currentNode;
                break;
            } else {//GO RIGHT
                if (!currentNode.hasRightChild()) {
                    result = null;
                    break;
                } else if (currentNode.rightChild.element.compareTo(element) == 0) {
                    result = currentNode.rightChild;
                    break;
                } else {
                    currentNode = currentNode.rightChild;
                }
            }
        }
        return result;
    }

    private Node<E> goLeft(Node<E> node) {
        return node.leftChild != null ? node.leftChild : null;
    }

    private Node<E> goRight(Node<E> node) {
        return node.rightChild != null ? node.rightChild : null;
    }

    private Node<E> goMaxRight(Node<E> node) {
        Node<E> currentNode = node;
        while (goRight(currentNode) != null) {
            currentNode = goRight(currentNode);
        }
        return currentNode;
    }

    public Node<E> goMaxLeft(Node<E> node) {
        Node<E> currentNode = node;
        while (goLeft(currentNode) != null) {
            currentNode = goLeft(currentNode);
        }
        return currentNode;
    }


    public void print() {

        Node<E> currentNode = root;
        int elements = 0;
        ArrayDeque<Node<E>> arrayDeque = new ArrayDeque<>();
        arrayDeque.add(root);

        while (!arrayDeque.isEmpty()) {
            elements++;
            currentNode = arrayDeque.poll();
            System.out.println("\t" + currentNode.element);
            for (int i = 0; i <arrayDeque.size() ; i++) {

                if (currentNode.leftChild != null) {
                    arrayDeque.add(currentNode.leftChild);
                }
                if (currentNode.rightChild != null) {
                    arrayDeque.add(currentNode.rightChild);
                }
            }

        }
    }


    //Iterator
    @Override
    public Iterator<E> iterator() {
        /*ArrayQueue<Node<E>> arrayQueue = new ArrayQueue<>(size);
        arrayQueue.add(root);
        int i=0;
        w
        *//*Iterator<Node<E>> iterator = arrayQueue.iterator();
        while (true){

        }*//*
*/


        return null;
    }


    private static class Node<E> {
        E element;
        Node<E> parent;
        Node<E> leftChild;
        Node<E> rightChild;

        public Node(E element, Node<E> parent, Node<E> leftChild, Node<E> rightChild) {
            this.element = element;
            this.parent = parent;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
        }

        boolean hasParent() {
            return parent != null;
        }

        boolean hasLeftChild() {
            return leftChild != null;
        }

        boolean hasRightChild() {
            return rightChild != null;
        }

        boolean hasNoChild() {
            return (rightChild == null) && (leftChild == null);
        }

        void printNode() {
            try {

                System.out.println("ELEMENT = " + this.element);
                System.out.println("PARENT = " + this.parent.element);
                System.out.println("LEFT CHILD = " + this.leftChild.element);
                System.out.println("RIGHT CHILD = " + this.rightChild.element);
            } catch (NullPointerException e) {
            }
        }

        public void nullNode() {
            this.element = null;
            this.parent = null;
            this.leftChild = null;
            this.rightChild = null;
        }
    }
}
