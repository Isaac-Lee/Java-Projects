package 과제;

public class MyMath<T extends Number>{
	public double getAverage(T[] arr) {
		double scr = 0;
		for (int i =0;  i < arr.length; i++ ) {
			scr += arr[i].doubleValue(); // arr[i] 이런 식으로만 쓰면 주소값이 전달됨
		}
		return scr/arr.length;
	}

}
