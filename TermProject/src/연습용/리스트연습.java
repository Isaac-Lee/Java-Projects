package ������;

import java.util.ArrayList;
import java.util.Scanner;

public class ����Ʈ���� {
	public static void main(String[] args) {
		ArrayList nameList = new ArrayList();
		Scanner input = new Scanner(System.in);
		String name = new String();
		
		for (int i = 0; i<3; i++) {
			System.out.print("�̸��� �Է��ϼ���: ");
			name = input.next();
			nameList.add(name);
		}
		
		System.out.println(nameList);
	}

}
