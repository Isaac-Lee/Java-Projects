package °úÁ¦06;

import java.util.ArrayList;

public class BinarySearchTest {
public static <T> int binarySearch(ArrayList<? extends Comparable<T>> list, T target, int begin, int end) {
	
	if (begin >=end)
		return -1;
	
	int middle = (begin + end) / 2;
	
	
	if(list.get(middle).compareTo(target) == 0) {
		return middle;
	}
	else if(list.get(middle).compareTo(target) < 0){
		return binarySearch(list, target, middle+1, end);
	}
	else {
		return binarySearch(list, target, begin, middle-1);
	}
	
	
	return -1;
}

public static <T> int loopBinarySearch(ArrayList<? extends Comparable<T>> list, T target, int begin, int end) {
	
	int middle = (begin + end) / 2;
	while (list.get(middle).compareTo(target) != 0) {
		if (begin >=end)
			return -1;
		
		middle = (begin + end) / 2;
		
		if(list.get(middle).compareTo(target) == 0) {
			return middle;
		}
		
		else if(list.get(middle).compareTo(target) < 0){
			begin = middle+1;
		}
		else {
			end = middle-1;
		}
	}
	return -1;
}

public static void main(String[] args) {
    ArrayList<Integer> list = new ArrayList<>();
    for(int i=0; i<100; i++) {
       list.add(i,i*2);
    }
    int one = loopBinarySearch(list, 100, 0, list.size()-1);
    System.out.println("ÀÌÁøÅ½»öÀ¸·Î 100Å½»ö : "+one);
    System.out.println("list.get(50) : "+list.get(50));
    int two = loopBinarySearch(list, 111, 0, list.size()-1);
    System.out.println("ÀÌÁøÅ½»öÀ¸·Î 111Å½»ö : "+ two);
 }


}
