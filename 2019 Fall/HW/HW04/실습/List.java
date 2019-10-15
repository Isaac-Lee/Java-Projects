package ½Ç½À;

public interface List<E> {
	
	public void add(int index, E element);
	
	public void addFirst(E element);
	
	public void addLast(E element);
	
	public E remove(int index);
	
	public E removeFirst();
	
	public E removeLast();
	
	public E set(int index, E element);
	
	public E get(int index);
	
	public int indexOf(E element);
	
	public int size();
	
	public boolean isEmpty();
	
	public Iterator<E> iterator();
 
}
