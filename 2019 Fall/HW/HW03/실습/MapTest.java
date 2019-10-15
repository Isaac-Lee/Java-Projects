package 실습;

import java.util.HashMap;
import java.util.Map;

public class MapTest {
	public static void main(String[] args) {
		Map<String, Student> st = new HashMap<>();
		
		st.put("201901", new Student(201901, "유비"));
		st.put("201902", new Student(201902, "관우"));
		st.put("201903", new Student(201903, "장비"));
		
		System.out.println(st);
		
		st.remove("201902");
		
		st.put("201903", new Student(201903, "조운"));
		
		for (Map.Entry<String, Student> s : st.entrySet()) {
			String key = s.getKey();
			Student value = s.getValue();
			System.out.println("key = "+ key + ", value = "+ value);
		}
	}

}

