package ½Ç½À;

import java.util.HashSet;
import java.util.Set;

public class SetTest {
	public static void main(String args[]) {
		Set<String> set = new HashSet<String>();
		
		set.add("milk");
		set.add("milk");
		set.add("milk");
		set.add("milk");
		set.add("milk");
		set.add("milk");
		
		System.out.println(set);
	}

}
