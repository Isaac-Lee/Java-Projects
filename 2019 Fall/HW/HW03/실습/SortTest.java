package �ǽ�;
import java.util.*;

public class SortTest {
	public static void main(String[] args) {
		Student array[] = {
				new Student(201902, "���ϳ�"),
				new Student(201901, "���ؿ�"),
				new Student(201904, "������"),
				new Student(201904, "������")
		};
		
		List<Student> list = Arrays.asList(array);
		Collections.sort(list);
		System.out.println(list);
	}

}
