package 과제;

public class MyMathTest {
	public static void main(String[] args) {
		Integer[] intArr = {1,2,3,4,5,6};
		MyMath<Integer> imath = new MyMath<Integer>();
		System.out.println("정수 배열의 평균은 = " + imath.getAverage(intArr));
		
		Double[] dArr = {1.0, 3.0, 5.0, 7.0, 9.0, 11.0};
		MyMath<Double>dmath = new MyMath<Double>();
		System.out.println("실수 배열의 평균은 = " +  dmath.getAverage(dArr));
	}

}
