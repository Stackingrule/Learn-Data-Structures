package Arrays;

public class Array<E> {

    private E[] data;
    private int size;

    public Array(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    public Array() {
        this(10);
    }

    public int getCapacity() {
        return data.length;
    }


    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(int index, E element) {
        if (size == data.length) {
            throw new IllegalArgumentException("Add failed. Array is full.");
        }
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size.");
        }

        for (int i = size - 1; i >= index; i --) {
            data[i + 1] = data[i];
        }
        data[index] = element;
        size ++;
    }

    public E get(int index) {
        if (index >= size || index < 0)
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        return data[index];
    }

    public boolean contains(E element) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(element))
                return true;
        }
        return false;
    }

    public int find(E element) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(element))
                return i;
        }
        return -1;
    }

    public E remove(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Remove failed. Index is illegal.");
        E result = data[index];
        System.arraycopy(data, index, data, index - 1, size - index);
        size --;
        data[size] = null;
        return result;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    public void removeElement(E element) {
        int index = find(element);
        if (index != -1)
            remove(index);
    }

}

