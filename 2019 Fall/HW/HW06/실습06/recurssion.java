package ½Ç½À06;

import java.util.ArrayList;

public class recurssion {

public static int factorial(int n) {
	if (n == 0) {
		return 1;
	}
	else {
		return n*factorial(n-1);
	}
}

public static double power(double num, int exp) {
	if (exp == 0) {
		return 1.0;
	}
	else {
		return num*power(num, exp-1);
	}
}

public static int maxArr(int[] arr, int begin, int end) {
	if (begin >= end) {
		return arr[begin];
	}
	else {
		int max = maxArr(arr, begin+1, end);
		if (arr[begin] >= max)
			return arr[begin];
		else
			return max;
		
	}
}

public static String reverseStr(String str) {
	if (str.length() == 1)
		return ""+str.charAt(0);
	else
		return reverseStr(str.substring(1)) + str.charAt(0);
}

public static <T> int sequentialSearch(ArrayList<T> list, T target, int begine, int end) {
	if (begine >= end)
		return end;
	else {
		int current = sequentialSearch(list, target, begine + 1, end);
		if (target == list.get(current)) {
			return current;
		}
		else if(begine == 0) {
			return -1;
		}
		else
			return begine;
	}
		
}




public static void main(String[] args) {
	System.out.println("10! = " + factorial(10));
	System.out.println("pi^3 = " + power(Math.PI, 3));
	System.out.println(reverseStr("programming with java"));
	int[] arr = {1,3,4,5,3,2,1,10,7};
	System.out.println("maxArr: " + maxArr(arr, 0, arr.length - 1));
	
	
	ArrayList<Integer> list = new ArrayList<>();
	for(int i = 0; i <100; i++) {
		list.add(i, i);
	}
	
	System.out.println("find 50: " + sequentialSearch(list, 50, 0, list.size()-1));
	System.out.println("find 100: " + sequentialSearch(list, 100, 0, list.size()-1));
	
}


}


