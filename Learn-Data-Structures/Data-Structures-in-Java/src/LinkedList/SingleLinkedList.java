package LinkedList;

public class SingleLinkedList<E> extends AbstractList<E> {

    private static class Node<E> {
        E element;
        Node<E> next;

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }

        public Node(E e){
            this(e, null);
        }

        public Node(){
            this(null, null);
        }
    }


    private int size;
    private Node<E> dummyNode; // 头节点


    public SingleLinkedList() {
        dummyNode = new Node<E>();
        size = 0;
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


            Node<E> prev = getNode(index - 1);
            prev.next = new Node<E>(element, prev.next);
            size++;



    }

    @Override
    public E remove(int index) {
        rangeCheck(index);
        Node<E> prev =  getNode(index );
        Node<E> cur = getNode(index);
        prev.next = cur.next;
        size--;
        return cur.element;

    }

    @Override
    public int indexOf(E element) {
        if (element == null) {
            Node<E> node = dummyNode;
            for (int i = 0; i < size; i++) {
                if (node.element == null) return i;

                node = node.next;
            }
        } else {
            Node<E> node = dummyNode;
            for (int i = 0; i < size; i++) {
                if (element.equals(node.element)) return i;

                node = node.next;
            }
        }
        return ELEMENT_NOT_FOUND;
    }

    private Node<E> getNode(int index) {
        rangeCheck(index);

        Node<E> node = dummyNode;
        for (int i = 0; i < index + 1; i++) {
            node = node.next;
        }

        return node;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("size = ").append(size).append(", [ ");
        Node<E> node = dummyNode;
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                builder.append(", ");
            }
            builder.append(node.element);
            node = node.next;
        }

        builder.append(" ]");
        return builder.toString();
    }
}
