package °úÁ¦;

public interface List<E> {
	
	public void add(int index, E element);
	
	public void addFirst(E element);
	
	public void addLast(E element);
	
	public void remove(int index);
	
	public void removeFirst();
	
	public void removeLast();
	
	public void set(int index, E element);
	
	public E get(int index);
	
	public int indexOf(E element);
	
	public int size();
	
	public boolean isEmpty();
	
	public Iterator<E> iterator();
 
}
