package ����;

public class MyMathTest {
	public static void main(String[] args) {
		Integer[] intArr = {1,2,3,4,5,6};
		MyMath<Integer> imath = new MyMath<Integer>();
		System.out.println("���� �迭�� ����� = " + imath.getAverage(intArr));
		
		Double[] dArr = {1.0, 3.0, 5.0, 7.0, 9.0, 11.0};
		MyMath<Double>dmath = new MyMath<Double>();
		System.out.println("�Ǽ� �迭�� ����� = " +  dmath.getAverage(dArr));
	}

}
