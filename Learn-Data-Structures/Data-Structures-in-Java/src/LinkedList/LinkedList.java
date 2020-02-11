package LinkedList;

public class LinkedList {

    private int size;
    private Node dummyNode; // 头节点

    private static class Node<E> {
        E element;
        Node<E> next;
    }

}
