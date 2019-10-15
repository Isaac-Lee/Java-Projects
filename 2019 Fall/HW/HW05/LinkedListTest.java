import 실습.Iterator;
import 실습.List;

public class LinkedListTest {
public static void main(String[] args) {
	List<Integer> list = new LinkedList<Integer>();
	
	for(int i = 0; i < 100000; i++) {
		list.addLast(i);
	}
	long start = System.currentTimeMillis();
	Iterator<Integer> it = list.iterator();
	while(it.hasNext()) {
		System.out.println(it.next());
	}
	long end = System.currentTimeMillis();
	System.out.println((end-start)/1000.0+"초");
	
	for(int i = 0; i < 100000; i++) {
		list.addLast(i);
	}
	start = System.currentTimeMillis();
	for (int i = 0; i <list.size(); i++) {
		System.out.println(list.get(i));
	}
	end = System.currentTimeMillis();
	System.out.println((end-start)/1000.0+"초");
}
}
