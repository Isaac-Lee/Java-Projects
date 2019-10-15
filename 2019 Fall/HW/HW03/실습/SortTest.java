package 실습;
import java.util.*;

public class SortTest {
	public static void main(String[] args) {
		Student array[] = {
				new Student(201902, "김하나"),
				new Student(201901, "이준영"),
				new Student(201904, "조형근"),
				new Student(201904, "박지수")
		};
		
		List<Student> list = Arrays.asList(array);
		Collections.sort(list);
		System.out.println(list);
	}

}
