import 실습.Iterator;
import 실습.List;

public class LinkedList<T> implements List<T> {
	private Node<T> head;
	private Node<T> tail;
	private int size = 0;
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size ==0;
	}
	
	@Override
	public void addFirst(T element) {
		Node<T> newNode = new Node<>(element);
		newNode.next = head;
		head = newNode;
		size++;
		if (head.next ==null) {
			tail = head;
		}
	}
	
	@Override
	public void addLast(T element) {
		if (isEmpty()) {
			addFirst(element);
		}
		else {
			Node<T> newNode = new Node<>(element);
			tail.next = newNode;
			tail = newNode;
			size++;
		}
	}
	
	private Node<T> node(int index){
		Node<T> x = head;
		for (int i = 0; i < index; i++) {
			x = x.next;
		}
		
		return x;
	}
	
	public void add(int index, T element) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException();
		}
		if (index == 0) {
			addFirst(element);
		}
		else {
			Node<T> temp1 = node(index-1);
			Node<T> temp2 = temp1.next;
			Node<T> newNode = new Node<>(element);
			temp1.next = newNode;
			newNode.next = temp2;
			size++;
			if (newNode.next ==null) {
				tail = newNode;
			}
		}
	}
	
	@Override
	public String toString() {
		if (head == null) {
			return"[]";
		}
		
		Node<T> temp  = head;
		StringBuilder str = new StringBuilder("[");
		while(temp.next != null) {
			str.append(temp.data +",");
			temp = temp.next;
		}
		
		str.append(temp.data);
		return new String(str+"]");
	}
	
	
	
	private class Node<E>{
		private E data;
		private Node<E> next;
		
		public Node(E input) {
			this.data = input;
			this.next = null;
		}
		
		@Override
		public String toString() {
			return String.valueOf(this.data);
		}
	}



	@Override
	public T remove(int index) {
		// TODO Auto-generated method stub
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		if (index == 0) {
			return removeFirst();
		}
		
		Node<T> temp = node(index - 1);
		Node<T> nodeToDelete = temp.next;
		
		temp.next = temp.next.next;
		T returnData = nodeToDelete.data;
		if(nodeToDelete == tail) {
			tail = temp;
		}
		nodeToDelete = null;
		return returnData;
	}

	@Override
	public T removeFirst() {
		// TODO Auto-generated method stub
		Node<T> temp = head;
		head = temp.next;
		
		T returnData = temp.data;
		temp = null;
		size--;
		return returnData;
	}

	@Override
	public T removeLast() {
		// TODO Auto-generated method stub
		
		return remove(size - 1);
	}

	@Override
	public T set(int index, T element) {
		// TODO Auto-generated method stub
		Node<T> temp = head;
		for (int i = 0; i < index; i++) {
			temp = temp.next;
		}
		T preData = temp.data;
		temp.data = element;
		return preData;
	}

	@Override
	public T get(int index) {
		// TODO Auto-generated method stub
		if (index <0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		return node(index).data;
	}

	@Override
	public int indexOf(T element) {
		// TODO Auto-generated method stub
		Node<T> temp  = head;
		int index = 0;
		while(temp.next != null) {
			if (temp.data == element) {
				return index;
			}
			temp = temp.next;
			index++;
		}
		return -1;
	}
	
	public class ListIterator implements Iterator<T>{
		Node<T> temp = head;
		
		private ListIterator() {
		}

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return temp.next != null;

		}

		@Override
		public T next() {
			// TODO Auto-generated method stub
			T reData = temp.data;
			temp = temp.next;
			return reData;
		}
		
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new ListIterator();
	}
}
