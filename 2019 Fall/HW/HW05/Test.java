import �ǽ�.Iterator;
import �ǽ�.List;

import java.util.Random;

import ����.ArrayList;

public class Test {
public static void main(String[] args) {
	Random random = new Random();
	
	List<Integer> linkedList = new LinkedList<Integer>();
	List<Integer> arrayList = new ArrayList<Integer>();
	
	// ���� ���������� �߰�
	System.out.println("100000�� ���� ������ �߰�");
	System.out.print("LinkedList: ");
	long start = System.currentTimeMillis();
	for(int i = 0; i < 100000; i++) {
		linkedList.addLast(i);
	}
	long end = System.currentTimeMillis();
	System.out.println((end-start)/1000.0+"��");
	
	System.out.print("ArrayList: ");
	start = System.currentTimeMillis();
	for(int i = 0; i < 100000; i++) {
		arrayList.addLast(i);
	}
	end = System.currentTimeMillis();
	System.out.println((end-start)/1000.0+"��");
	
	// ���� ������ ��ġ�� ����
	System.out.println("1000�� ���� ������ ��ġ�� �߰�");
	System.out.print("LinkedList: ");
	start = System.currentTimeMillis();
	for(int i = 0; i < 1000; i++) {
		linkedList.add(random.nextInt(100000), i);
	}
	end = System.currentTimeMillis();
	System.out.println((end-start)/1000.0+"��");
	
	System.out.print("ArrayList: ");
	start = System.currentTimeMillis();
	for(int i = 0; i < 1000; i++) {
		arrayList.add(random.nextInt(100000), i);
	}
	end = System.currentTimeMillis();
	System.out.println((end-start)/1000.0+"��");
	
	// ������ ��ġ�� ���� ã��
	System.out.println("10000���� ������ ���� ã��");
	System.out.print("LinkedList: ");
	start = System.currentTimeMillis();
	for(int i = 0; i < 10000; i++) {
		linkedList.get(random.nextInt(100000));
	}
	end = System.currentTimeMillis();
	System.out.println((end-start)/1000.0+"��");
	
	System.out.print("ArrayList: ");
	start = System.currentTimeMillis();
	for(int i = 0; i < 10000; i++) {
		arrayList.get(random.nextInt(100000));
	}
	end = System.currentTimeMillis();
	System.out.println((end-start)/1000.0+"��");
	
	//������ ��ġ ���� ����
	System.out.println("1000���� ������ ���� ����");
	System.out.print("LinkedList: ");
	start = System.currentTimeMillis();
	for(int i = 0; i < 1000; i++) {
		linkedList.remove(random.nextInt(100000));
	}
	end = System.currentTimeMillis();
	System.out.println((end-start)/1000.0+"��");
	
	System.out.print("ArrayList: ");
	start = System.currentTimeMillis();
	for(int i = 0; i < 1000; i++) {
		arrayList.remove(random.nextInt(100000));
	}
	end = System.currentTimeMillis();
	System.out.println((end-start)/1000.0+"��");
	
	
	
	/*
	 * �м�
	 * �������� �������� �߰�:
	 * ũ�� ���̰� ���� ������ ArrayList�� ���� ���� �����ɸ���.
	 * �Ƹ� ����Ʈ�� ����� 2�辿 ���ִ� ������ �ð��� �� �ɸ��� ���� �ƴѰ� �ʹ�.
	 * 
	 * ������ ��ġ�� ���Ҹ� �߰��ϴ� ��:
	 * �ڷᱸ���� LinkedList��  �ϳ��� ��常 �߰��ϰ� ������ �����͵��� ����Ű�� ���� �����ϸ� �Ǵ� �ݸ�
	 * ArrayList�� �߰��� ���� �ڿ� ��� ���ҵ��� �ε����� �ڷ� �о���ؼ� �ð��� �����ɸ��� �� ����.
	 * 
	 * ������ ���� ã��:
	 * ���� �ð����̰� ���� ���� �۾��̴�. 
	 * �Ƹ��� ArrayList�� �ٷ� �ε����� �����Ϳ� ���� �� �� ������
	 * LinkedList�� ��� ��带 ���ļ� ���ϴ� �ε����� ��忡 �����ϱ� ������ ������ ����.
	 * 
	 * ������ ���� ����:
	 * �����߰��� ���������� ArrayList�� �߰��� ���� �ڿ� ��� ���ҵ��� �ε����� �����ؾ��Ѵ�.
	 * �ű⼭ �����ɸ��� �� ����.
	 */
}
}
