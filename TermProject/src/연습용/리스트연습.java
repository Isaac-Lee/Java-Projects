package 연습용;

import java.util.ArrayList;
import java.util.Scanner;

public class 리스트연습 {
	public static void main(String[] args) {
		ArrayList nameList = new ArrayList();
		Scanner input = new Scanner(System.in);
		String name = new String();
		
		for (int i = 0; i<3; i++) {
			System.out.print("이름을 입력하세요: ");
			name = input.next();
			nameList.add(name);
		}
		
		System.out.println(nameList);
	}

}
