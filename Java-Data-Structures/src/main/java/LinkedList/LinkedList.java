package LinkedList;

public class LinkedList<E> {

    private class Node {
        private E element;
        private Node next;

        public Node(E element, Node next) {
            this.element = element;
            this.next = next;
        }

        public Node(E element) {
            this.element = element;
        }

        public Node() {
            this(null, null);
        }

        public String toString() {
            return element.toString();
        }

    }

    private Node dummyHead;
    private int size;

    public LinkedList() {
        dummyHead = new Node(null);
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(E element, int index) {
        if(index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }

        Node current = dummyHead;
        for (int i = 0; i < index; i ++) {
            current = current.next;
        }

        current.next = new Node(element, current.next);
        size ++;
    }

    public E get(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Get failed. Illegal index.");
        }

        Node current = dummyHead;
        for (int i = 0; i < index; i ++) {
            current = current.next;
        }

        return current.element;
    }

    public void set(int index, E element) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Set failed. Illegal index.");
        }

        Node current = dummyHead;
        for (int i = 0; i < index; i ++) {
            current = current.next;
        }

        current.element = element;
    }

    private boolean contains(E element) {
        Node current = dummyHead.next;

        while (current != null) {
            if (current.element.equals(element))
                return true;
            current = current.next;
        }
        return false;
    }

    public E remove(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Set failed. Illegal index.");
        }

        Node current = dummyHead;
        for (int i = 0; i < index; i ++) {
            current = current.next;
        }

        Node retNode = current.next;
        current.next = retNode.next;
        retNode.next = null;
        size --;

        return retNode.element;

    }

    public void removeElement(E element) {
        Node current = dummyHead;
        while (current.next != null) {
            if (current.element.equals(element))
                break;
            current = current.next;
        }
        if (current.next != null) {
            Node retNode = current.next;
            current.next = retNode.next;
            retNode.next = null;
            size --;
        }
    }

    @Override
    public String toString() {
        StringBuilder  stringBuilder = new StringBuilder();

        Node current = dummyHead.next;
        while (current != null) {
            stringBuilder.append(current + "->");
        }
        stringBuilder.append("NULL");

        return stringBuilder.toString();
    }

}
