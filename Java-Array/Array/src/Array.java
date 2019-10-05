public class Array<E> {

	private E[] data;

	private int size;



    //构造函数
	public Array() {
		this(10);
	}

	//构造函数
	public Array(int capacity) {

        data = (E[])new Object[capacity];
        int size = 0;
	}

	public int getSize() {
		return size;
	}

	public int getCapacity() {
		return data.length;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void addLast(E e) {
		if(size == data.length) {
			throw new IllegalArgumentException("AddLast failed. Array is full.");
		}

		data[size] = e;
		size++;
	}

	public void add(int index, E e) {
		if(size == data.length) {
			throw new IllegalArgumentException("Add failed. Array is full.");
		}

		if(index < 0 || index > size) {
			throw new IllegalArgumentException("");
		}

		for(int i = size - 1; i >= index; i--) {
			data[i+1] = data[i];
		}

		data[index] = e;
		size++;
	}

	public int get(int index) {
		if(index < 0 || index >= size)
			throw new IllegalArgumentException("Get failed. Index is illegal.");
		return data[index];
	}

	public void set(int index, E e) {
		if(index < 0 || index >= size)
			throw new IllegalArgumentException("Set failed. Index is illegal.");
		data[index] = e;
	}

	public boolean contains(E e) {
		for(int i = 0; i < size; i++) {
			if(data[i] == e)
				return true;
		}

		return false;
	}

	public int find(E e) {
		for(int i = 0; i < size; i++) {
			if(data[i].equals(e))
				return i;
		}

		return -1;
	}

	public int remove(int index) {
		if(index < 0 || index >= size) 
			throw new IllegalArgumentException("Delete failed. Index is illegal");

		int ret = data[index];

		for(int i = index + 1; i < size; i++) {
			data[i - 1] = data[i];
		}

		size--;
		return ret;
	}

	public void removeElement(E e) {
		int index = find(e);
		if(index != -1)
			remove(index);
	}




	@Override
	public String toString() {
		StringBuilder res = new StringBuilder();
		res.append(String.format("Array: size = %d, capacity = %d\n"), size, capacity);
		res.append('[');
		for(int i = 0; i < size; i++) {
			res.append(data[i]);
			if(i != size - 1) 
				res.append(", ");
		}
		res.append(']');
		return res.toString();
	}





}
