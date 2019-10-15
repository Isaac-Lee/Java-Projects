package ����06;

import java.util.Scanner;

public class FibonacciTest {

	public static long loopFibonacci(int n) {
		if (n == 0)
			return 0;
		else if(n == 1)
			return 1;
		else {
			long re = 0;
			long re1 = 1;
			long re2 = 0;
			for (int i = 0; i < n-1; i++) {
				re = re1 + re2;
				re2 = re1;
				re1 = re;
			}
			return re;
		}
	}
	
	public static long recursiveFibonacci(int n) {
		if (n ==0)
			return 0;
		else if(n==1)
			return 1;
		else {
			return recursiveFibonacci(n-1) + recursiveFibonacci(n-2);
		}

	}
	
	public static void main(String[] args) {
	      
	      Scanner scan = new Scanner(System.in);
	      
	      System.out.println("�Ǻ���ġ ������ n��° ���� ����մϴ�.");
	      System.out.print("n���� �Է��ϼ���: ");
	      
	      int number = scan.nextInt();
	      
	      long loop_Fibonacci_start = System.currentTimeMillis();
	      
	      loopFibonacci(number);
	      
	      long loop_Fibonacci_end = System.currentTimeMillis();
	      
	      System.out.println("�ݺ����� ����ؼ� ����� F(50) = " + loopFibonacci(number));
	      System.out.println("��� �ð�: " + (loop_Fibonacci_end - loop_Fibonacci_start) / 1000.0 + "��");
	      
	      long recursive_Fibonacci_start = System.currentTimeMillis();
	      
	      recursiveFibonacci(number);
	      
	      long recursive_Fibonacci_end = System.currentTimeMillis();
	      
	      System.out.println("���ȣ���� ����ؼ� ����� F(50) = " + recursiveFibonacci(number));
	      System.out.println("��� �ð�: " + (recursive_Fibonacci_end - recursive_Fibonacci_start) / 1000.0 + "��");
	}
}
