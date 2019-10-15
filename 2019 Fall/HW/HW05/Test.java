import 실습.Iterator;
import 실습.List;

import java.util.Random;

import 과제.ArrayList;

public class Test {
public static void main(String[] args) {
	Random random = new Random();
	
	List<Integer> linkedList = new LinkedList<Integer>();
	List<Integer> arrayList = new ArrayList<Integer>();
	
	// 원소 순차적으로 추가
	System.out.println("100000개 원소 순차적 추가");
	System.out.print("LinkedList: ");
	long start = System.currentTimeMillis();
	for(int i = 0; i < 100000; i++) {
		linkedList.addLast(i);
	}
	long end = System.currentTimeMillis();
	System.out.println((end-start)/1000.0+"초");
	
	System.out.print("ArrayList: ");
	start = System.currentTimeMillis();
	for(int i = 0; i < 100000; i++) {
		arrayList.addLast(i);
	}
	end = System.currentTimeMillis();
	System.out.println((end-start)/1000.0+"초");
	
	// 원소 임의의 위치에 삽입
	System.out.println("1000개 원소 임의의 위치에 추가");
	System.out.print("LinkedList: ");
	start = System.currentTimeMillis();
	for(int i = 0; i < 1000; i++) {
		linkedList.add(random.nextInt(100000), i);
	}
	end = System.currentTimeMillis();
	System.out.println((end-start)/1000.0+"초");
	
	System.out.print("ArrayList: ");
	start = System.currentTimeMillis();
	for(int i = 0; i < 1000; i++) {
		arrayList.add(random.nextInt(100000), i);
	}
	end = System.currentTimeMillis();
	System.out.println((end-start)/1000.0+"초");
	
	// 임의의 위치에 원소 찾기
	System.out.println("10000개의 임의의 원소 찾기");
	System.out.print("LinkedList: ");
	start = System.currentTimeMillis();
	for(int i = 0; i < 10000; i++) {
		linkedList.get(random.nextInt(100000));
	}
	end = System.currentTimeMillis();
	System.out.println((end-start)/1000.0+"초");
	
	System.out.print("ArrayList: ");
	start = System.currentTimeMillis();
	for(int i = 0; i < 10000; i++) {
		arrayList.get(random.nextInt(100000));
	}
	end = System.currentTimeMillis();
	System.out.println((end-start)/1000.0+"초");
	
	//임의의 위치 원소 삭제
	System.out.println("1000개의 임의의 원소 삭제");
	System.out.print("LinkedList: ");
	start = System.currentTimeMillis();
	for(int i = 0; i < 1000; i++) {
		linkedList.remove(random.nextInt(100000));
	}
	end = System.currentTimeMillis();
	System.out.println((end-start)/1000.0+"초");
	
	System.out.print("ArrayList: ");
	start = System.currentTimeMillis();
	for(int i = 0; i < 1000; i++) {
		arrayList.remove(random.nextInt(100000));
	}
	end = System.currentTimeMillis();
	System.out.println((end-start)/1000.0+"초");
	
	
	
	/*
	 * 분석
	 * 순차적인 데이터의 추가:
	 * 크게 차이가 나지 않지만 ArrayList가 아주 조금 오래걸린다.
	 * 아마 리스트의 시이즈를 2배씩 해주는 데에서 시간이 더 걸리는 것이 아닌가 싶다.
	 * 
	 * 임의의 위치에 원소를 추가하는 것:
	 * 자료구조상 LinkedList는  하나의 노드만 추가하고 각각의 포인터들이 가리키는 곳만 수정하면 되는 반면
	 * ArrayList는 추가한 원소 뒤에 모든 원소들의 인덱스를 뒤로 밀어야해서 시간이 오래걸리는 것 같다.
	 * 
	 * 임의의 원소 찾기:
	 * 가장 시간차이가 많이 나는 작업이다. 
	 * 아마도 ArrayList는 바로 인덱스로 데이터에 접근 할 수 있지만
	 * LinkedList는 모든 노드를 거쳐서 원하는 인덱스의 노드에 접근하기 때문에 느린것 같다.
	 * 
	 * 임의의 원소 삭제:
	 * 원소추가와 마찬가지로 ArrayList는 추가한 원소 뒤에 모든 원소들의 인덱스를 수정해야한다.
	 * 거기서 오래걸리는 것 같다.
	 */
}
}
