package ����;

public class MyMath<T extends Number>{
	public double getAverage(T[] arr) {
		double scr = 0;
		for (int i =0;  i < arr.length; i++ ) {
			scr += arr[i].doubleValue(); // arr[i] �̷� �����θ� ���� �ּҰ��� ���޵�
		}
		return scr/arr.length;
	}

}
