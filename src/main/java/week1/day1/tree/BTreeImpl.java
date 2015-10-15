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

    private Node<E> mixRecurce(Node<E> currentNode) {
        if (currentNode.leftChild == null) return currentNode;
        return mixRecurce(currentNode.leftChild);

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
            if (!targetNode.leftChild.hasRightChild()) {
                Node<E> finalNode = targetNode.leftChild;
                targetNode.element = finalNode.element;
                targetNode.leftChild = finalNode.leftChild;
                size--;

            } else {
                Node<E> finalChild = goMaxRight(targetNode.leftChild);
                targetNode.element = finalChild.element;
                finalChild.element = null;
                finalChild.parent.rightChild = null;
                size--;
            }

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

    //Generate array with splitters to printAll method
    private String[] getOutTabArray() {
        int stages = getStages();
        int[] tabArray = new int[stages];
        String[] stringTabArray = new String[stages];
        int j = 0;
        for (int i = stages; i > 0; i--) {
            tabArray[j] = (int) (Math.pow(2, i) / 2);
            j++;
        }

        for (int i = 0; i < stages; i++) {
            String s = "";
            for (int k = 0; k < tabArray[i]; k++) {
                s = s + "\t";
            }
            stringTabArray[i] = s;
        }
        return stringTabArray;

    }

    @Override
    //Print method
    public void print() {
        String outStringTabArray[] = getOutTabArray();

        ArrayList<ArrayList<Node<E>>> totalArrayList = getTreeStagesArrayList();
        for (int i = 0; i < totalArrayList.size(); i++) {
            for (int j = 0; j < totalArrayList.get(i).size(); j++) {
                try {
                    System.out.print(outStringTabArray[i] + totalArrayList.get(i).get(j).element + outStringTabArray[i]);
                } catch (NullPointerException e) {
                    System.out.print(outStringTabArray[i] + " " + outStringTabArray[i]);
                }
            }
            System.out.println();
        }

    }

    @Override
    public void minRecurce() {
        System.out.println("\nMinimal element, finded by recursion = " + mixRecurce(root).element + ".\n");
    }

    //Convert tree to staged ArrayList
    private ArrayList<ArrayList<Node<E>>> getTreeStagesArrayList() {
        Node<E> currentNode = root;
        int count = size();

        ArrayList<ArrayList<Node<E>>> totalArrayList = new ArrayList<>();
        ArrayList<Node<E>> arrayList1 = new ArrayList<>();
        ArrayList<Node<E>> arrayList2 = new ArrayList<>();

        arrayList1.add(currentNode);
        count--;
        totalArrayList.add(new ArrayList<Node<E>>(arrayList1));

        while (count != 0) {
            for (Node<E> anArrayList1 : arrayList1) {

                if (anArrayList1 == null) continue;
                if (anArrayList1.leftChild == null) {
                    arrayList2.add(null);
                } else {
                    arrayList2.add(anArrayList1.leftChild);
                    count--;
                }

                if (anArrayList1.rightChild == null) {
                    arrayList2.add(null);
                } else {
                    arrayList2.add(anArrayList1.rightChild);
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

    //Recursion printAll method (w/o iterator simple printAll)
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

    //Mowe to Node.RightChild
    private Node<E> goRight(Node<E> node) {
        return node.rightChild != null ? node.rightChild : null;
    }

    //Search maximum element
    private Node<E> goMaxRight(Node<E> node) {
        Node<E> currentNode = node;
        while (goRight(currentNode) != null) {
            currentNode = goRight(currentNode);
        }
        return currentNode;
    }


    @Override
    //Count Stages
    public int getStages() {
        return getTreeStagesArrayList().size();
    }

    @Override
    //Iterator
    public Iterator<E> iterator() {
        return new Itr();
    }

    //Inner class for Iterator creation
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
