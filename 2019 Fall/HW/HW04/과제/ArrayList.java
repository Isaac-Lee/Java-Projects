package 과제;

import 실습.List;

public class ArrayList<E> implements List<E>{
	private static final int DEFAULT_CAPACITY = 10;
	
	private Object[] elementData;
	
	private int size = 0;
	
	public ArrayList() {
		this.elementData = new Object[DEFAULT_CAPACITY];
	}
	public  ArrayList(int size) {
		this.elementData = new Object[size];
	}
	
	public String toString() {
		StringBuilder str = new StringBuilder("[");
		for (int i = 0; i < size; i++) {
			str.append(elementData[i]);
			if (i < size-1) {
				str.append(", ");
			}
			
		}
		str.append("]");
		return new String(str);
	}
	@Override
	public void add(int index, E element) {
		if (index > size) {
			throw new IndexOutOfBoundsException();
		}
		try {
			for (int i = size-1; i>=index; i--) {
			elementData[i+1] = elementData[i];
			}
			elementData[index] = element;
			size++;
		}
		catch(Exception e) {
			this.resize();
			this.add(index, element);
		}
	}
	
	
	 @Override
	public void addFirst(E element) {
		try {
			this.add(0, element);
		}
		catch(Exception e) {
			this.resize();
			this.add(0, element);
		}
	}
	@Override
	public void addLast(E element) {
		try {
			this.elementData[size++] = element;
		}
		catch(Exception e) {
			this.resize();
			this.elementData[size++] = element;
		}
	}
	
	@Override
	public void remove(int index) {
		if (this.elementData[index] == null) {
			throw new IndexOutOfBoundsException();
		}
		Object obj = this.elementData[index];
		
		for (int i = index+1; i <=size-1; i++) {
			this.elementData[i -1] = this.elementData[i];
		}
		size--;
		elementData[size] = null;
	}
	
	@Override
	public void removeFirst() {
		this.remove(0);
	}
	
	@Override
	public void removeLast() {
		this.remove(size - 1);
	}
	
	@Override
	public E get(int index) {
		if (elementData[index] == null) {
			throw new IndexOutOfBoundsException();
		}
		return (E)this.elementData[index];
	}
	
	@Override
	public int size() {
		return this.size;
	}
	
	@Override
	public int indexOf(E element) {
		for (int i = 0; i < size; i++) {
			if (element.equals(elementData[i])) {
				return i;
			}
			
		}
		return -1;
	}
	
	public Iterator<E> iterator() {
		return new ListIterator();
	}
	
	public class ListIterator implements Iterator<E>{
		private int nextIndex;
	
		private ListIterator() {
			this.nextIndex = 0;
		}
	
		public boolean hasNext() {
			return nextIndex < size();
		}
	
		public E next() {
			return (E) elementData[nextIndex++];
		}
	}

	@Override
	public void set(int index, E element) {
		if (elementData[index] == null) {
			throw new IndexOutOfBoundsException();
		}
		this.elementData[index] = element;
	}
	@Override
	public boolean isEmpty() {
		for (Object element : elementData) {
			if (element != null) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		List<Integer> list2 = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			list2.addLast(i);
		}
		Iterator<Integer> it = list2.iterator();
		while(it.hasNext()) {
			System.out.println(it.next()+" ");
		}
		
	}
	
	public void resize() {
		ArrayList newList = new ArrayList<E>(2*this.size);
		for (Object element : this.elementData) {
			newList.addLast(element);
		}
		this.size--;
		this.elementData = newList.elementData;
	}
}
