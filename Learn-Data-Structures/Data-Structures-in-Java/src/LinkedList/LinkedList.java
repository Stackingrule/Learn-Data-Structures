package LinkedList;

public class LinkedList<E> {

    private int size;
    private Node<E> dummyNode; // 头节点

    private static class Node<E> {
        E element;
        Node<E> next;

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }
    }





}
