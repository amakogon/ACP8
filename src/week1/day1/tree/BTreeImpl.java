package week1.day1.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Objects;

public class BTreeImpl<E extends Comparable<E>> implements IBTree<E> {

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
        int treeSize = size();
        ArrayList<Node<E>> firstArrayList = new ArrayList<>();
        ArrayList<Node<E>> secondArrayList = new ArrayList<>();
        ArrayList<Object> thirdArrayList = new ArrayList<>();

        firstArrayList.add(currentNode);
        treeSize--;
        thirdArrayList.addAll(firstArrayList);
        thirdArrayList.add("Splitter");
        int stages = 1;
        try {
            while (treeSize!=0) {
                for (int i = 0; i <firstArrayList.size() ; i++) {
                    if (firstArrayList.get(i).leftChild != null) {
                        secondArrayList.add(firstArrayList.get(i).leftChild);
                        treeSize--;
                    } else secondArrayList.add(null);
                    if (firstArrayList.get(i).rightChild != null) {
                        secondArrayList.add(firstArrayList.get(i).rightChild);
                        treeSize--;
                    }else secondArrayList.add(null);
                }
                thirdArrayList.addAll(secondArrayList);
                stages++;
                thirdArrayList.add("Splitter");
                firstArrayList.clear();
                firstArrayList.addAll(secondArrayList);
                secondArrayList.clear();
            }
        }catch (NullPointerException e){}


        String tabs="";
        for(int i=0; i<=stages;i++){
            tabs=tabs+"\t";
        }

        for (int i = 0; i <thirdArrayList.size() ; i++) {
            if (i==0) System.out.print("\t\t");
            if (thirdArrayList.get(i)==null){ System.out.print(tabs.substring(0,stages)+tabs.substring(0,stages));}
            else if (!thirdArrayList.get(i).equals("Splitter")){
                Node<E> node = (Node<E>)thirdArrayList.get(i);
                System.out.print(tabs.substring(0,stages)+node.element+tabs.substring(0,stages));}
            else {System.out.println();
                stages--;
            }

        }
        /*System.out.println("STAGES = " +stages);*/




       /* ArrayDeque<Node<E>> tempArrayDeque = new ArrayDeque<>();
        ArrayDeque<Node<E>> finalArrayDeque = new ArrayDeque<>();
        tempArrayDeque.add(currentNode);
        finalArrayDeque.add(currentNode);
        while (true){
            finalArrayDeque.peek();

        }
        while (!tempArrayDeque.isEmpty()) {
            currentNode = tempArrayDeque.poll();
            System.out.println("\t" + currentNode.element);
            for (int i = 0; i < tempArrayDeque.size() ; i++) {

                if (currentNode.leftChild != null) {
                    tempArrayDeque.add(currentNode.leftChild);
                }
                if (currentNode.rightChild != null) {
                    tempArrayDeque.add(currentNode.rightChild);
                }
            }

        }*/

    }
/*
    @Override
    public Iterator<E> iterator() {
        return new Itr<>();
    }


    private class Itr<E> implements Iterator<E>{
        ArrayDeque<Node<E>> iteratorDeque = getIneratorDeque();

        @Override
        public boolean hasNext() {
            return !iteratorDeque.isEmpty();
        }

       @Override
       public E next() {
           return (E)(iteratorDeque.poll().element);
       }

       private ArrayDeque<Node<E>> getIneratorDeque(){
           Node<E> currentNode = (Node<E>) root;
            ArrayDeque<Node<E>> tempArrayDeque = new ArrayDeque<>();
            ArrayDeque<Node<E>> finalArrayDeque = new ArrayDeque<>();
            tempArrayDeque.add(currentNode);

            while (!tempArrayDeque.isEmpty()) {
                currentNode = tempArrayDeque.poll();
                finalArrayDeque.add(currentNode);
                for (int i = 0; i < tempArrayDeque.size() ; i++) {
                    if (currentNode.leftChild != null) {
                        tempArrayDeque.add(currentNode.leftChild);
                    }
                    if (currentNode.rightChild != null) {
                        tempArrayDeque.add(currentNode.rightChild);
                    }
                }
            }
            return finalArrayDeque;
        }


    }
    */

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
