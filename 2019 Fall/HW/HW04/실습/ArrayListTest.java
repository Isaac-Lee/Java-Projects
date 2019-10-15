package Ω«Ω¿;

public class ArrayListTest {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		
		list.addLast(10);
		list.addLast(20);
		list.addLast(30);
		list.add(1, 15);
		list.addFirst(-10);
		
		System.out.println(list);
		System.out.println("size: " + list.size());
		System.out.println(" 20¿« ¿Œµ¶Ω∫: "+list.indexOf(20));
		System.out.println("100¿« ¿Œµ¶Ω∫: "+list.indexOf(100));
		
		System.out.println(list.remove(2));
		System.out.println(list.removeLast());
		System.out.println(list.removeFirst());
		System.out.println(list.get(0));
		System.out.println(list);	
	}

}
