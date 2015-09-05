package week1.day1.tree;

import java.util.ArrayList;
import java.util.Iterator;

public class BTreeImpl<E extends Comparable<E>> implements IBTree<E> {

    int size;
    Node<E> root;

    @Override
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
        if (targetNode == null) return false;
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
    public boolean contains(E element) {
        //System.out.println(findNode(element));
        return findNode(element) != null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }
    //Todo Create array to out;
    @Override
    public void print() {

        int weight = getStages();
        int height = (int)Math.pow(2,weight)+1;
        System.out.println(weight);
        System.out.println(height);
        Node<E>[][] nodeArray = new Node[weight][height];

        for (int i = 0; i <weight ; i++) {
            for (int j = 0; j < height; j++) {

                System.out.print(nodeArray[i][j]+" ");
            }
            System.out.println();
        }

        ArrayList<ArrayList<Node<E>>> totalArrayList = getTreeStagesArrayList();
        for (ArrayList<Node<E>> arratList : totalArrayList) {
            for (Node<E> node : arratList) {
                if (node == null) System.out.print("N");
                else System.out.print(node.element + " ");
            }
            System.out.println();
        }
    }

    private ArrayList<ArrayList<Node<E>>> getTreeStagesArrayList(){
        Node<E> currentNode = root;
        int count = size();

        ArrayList<ArrayList<Node<E>>> totalArrayList = new ArrayList<>();
        ArrayList<Node<E>> arrayList1 = new ArrayList<>();
        ArrayList<Node<E>> arrayList2 = new ArrayList<>();

        arrayList1.add(currentNode);
        count--;
        totalArrayList.add(new ArrayList<Node<E>>(arrayList1));

        while (count != 0) {
            for (int i = 0; i < arrayList1.size(); i++) {
                if (arrayList1.get(i).leftChild == null) {
                    arrayList2.add(null);
                } else {
                    arrayList2.add(arrayList1.get(i).leftChild);
                    count--;
                }

                if (arrayList1.get(i).rightChild == null) {
                    arrayList2.add(null);
                } else {
                    arrayList2.add(arrayList1.get(i).rightChild);
                    count--;
                }
            }


            totalArrayList.add(new ArrayList<Node<E>>(arrayList2));
            arrayList1.clear();
            arrayList1.addAll(arrayList2);
            arrayList2.clear();
        }
        return totalArrayList;
    }


    private void recPrint(Node<E> currentNode) {
        if (currentNode == null) return;
        System.out.println(currentNode.element);
        recPrint(currentNode.leftChild);
        recPrint(currentNode.rightChild);
    }


    //Creating no child node
    private Node<E> createNodeNoChilds(E element, Node<E> currentNode) {
        return createNode(element, currentNode, null, null);
    }

    //Creating node - full
    private Node<E> createNode(E element, Node<E> parent, Node<E> leftChild, Node<E> rightChild) {
        size++;
        return new Node<>(element, parent, leftChild, rightChild);
    }

    //Node search (by element)
    private Node<E> findNode(E element) {
        Node<E> currentNode = root;
        Node<E> result;
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


    @Override
    //CountStages

    public int getStages() {
        Node<E> currentNode = root;
        int treeSize = size();
        ArrayList<Node<E>> firstArrayList = new ArrayList<>();
        ArrayList<Node<E>> secondArrayList = new ArrayList<>();
        firstArrayList.add(currentNode);
        treeSize--;
        if (root == null) {
            return 0;
        }
        int stages = 1;
        while (treeSize != 0) {
            //TODO: NullPointerException
            for (Node<E> aFirstArrayList : firstArrayList) {
                if (aFirstArrayList.leftChild != null) {
                    secondArrayList.add(aFirstArrayList.leftChild);
                    treeSize--;
                } else secondArrayList.add(null);
                if (aFirstArrayList.rightChild != null) {
                    secondArrayList.add(aFirstArrayList.rightChild);
                    treeSize--;
                } else secondArrayList.add(null);
            }
            stages++;
            firstArrayList.clear();
            firstArrayList.addAll(secondArrayList);
            secondArrayList.clear();
        }
        return stages;
    }

    @Override
    //Iterator
    public Iterator<E> iterator() {
        return new Itr();
    }

    //Iner class for Iterator creation
    private class Itr implements Iterator<E> {
        private Node[] nodeList = new Node[size()];
        private int i = 0;
        private int position = 0;
        private int cursor = 0;

        public Itr() {
            getNodeList(root);
        }

        @Override
        //HasNext?
        public boolean hasNext() {
            return (cursor < size());
        }

        @Override
        //Next tree element
        public E next() {
            Node node = nodeList[position];
            position++;
            cursor++;
            return (E) node.element;
        }

        //inner method to create nodeList for Iterator
        private void getNodeList(Node<E> currentNode) {
            if (currentNode == null) return;
            nodeList[i] = currentNode;
            i++;
            getNodeList(currentNode.leftChild);
            getNodeList(currentNode.rightChild);
        }
    }

    //Node
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


        boolean hasLeftChild() {
            return leftChild != null;
        }

        boolean hasRightChild() {
            return rightChild != null;
        }

        boolean hasNoChild() {
            return (rightChild == null) && (leftChild == null);
        }


    }
}
