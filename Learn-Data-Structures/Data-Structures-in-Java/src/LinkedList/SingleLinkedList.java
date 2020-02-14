package LinkedList;

public class SingleLinkedList<E> extends AbstractList<E> {

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

    @Override
    public void clear() {
        size = 0;
        dummyNode = null;
    }

    @Override
    public E get(int index) {
        return getNode(index).element;
    }

    @Override
    public E set(int index, E element) {
        Node<E> node = getNode(index);
        E old = node.element;
        node.element = element;
        return old;
    }

    @Override
    public void add(int index, E element) {
        if (index == 0) {

        } else {
            Node<E> prev = getNode(index - 1);
            prev.next = new Node<E>(element, prev.next);
            size++;
        }
    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public int indexOf(E element) {
        return 0;
    }

    private Node<E> getNode(int index) {
        rangeCheck(index);

        Node<E> node = dummyNode;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }

        return node;
    }




}
