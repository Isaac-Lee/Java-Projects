package ½Ç½À;

import java.util.ArrayList;

public class ArrayListTest {
	public static void main(String args[]) {
		ArrayList<String> list = new ArrayList<String>();
		
		list.add("MILK");
		list.add("go");
		list.add("gu");
		list.add("MILK");
		list.add(1, "mmammam");
		list.set(2,  "Grape");
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}
