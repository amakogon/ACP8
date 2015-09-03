

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
        return false;
    }

    @Override
    //OK
    public boolean contains(E element) {
        return findNode(element)!=null;
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
    }
}
