package ½Ç½À;

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
	public boolean add(int index, E element) {
		for (int i = size-1; i>=index; i--) {
			elementData[i+1] = elementData[i];
		}
		
		elementData[index] = element;
		size++;
		return true;
	}
	
	 @Override
	public boolean addFirst(E element) {
		return add(0, element);
	}
	@Override
	public boolean addLast(E element) {
		this.elementData[size++] = element;
		return true;
	}
	
	@Override
	public E remove(int index) {
		Object obj = this.elementData[index];
		
		for (int i = index+1; i <=size-1; i++) {
			this.elementData[i -1] = this.elementData[i];
		}
		size--;
		elementData[size] = null;
		return (E)obj;
	}
	
	@Override
	public E removeFirst() {
		return this.remove(0);
	}
	
	@Override
	public E removeLast() {
		return this.remove(size - 1);
	}
	
	@Override
	public E get(int index) {
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
	public E set(int index, E element) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
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
}
