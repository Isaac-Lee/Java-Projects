package 실습;

public class CompareGenericMethodTest {
	public static void main(String[] args) {
		Pair<Integer, String> p1 = new OrderedPair<Integer, String>(1, "사과");
		Pair<Integer, String> p2 = new OrderedPair<Integer, String>(1, "사과");
		Pair<Integer, String> p3 = new OrderedPair<Integer, String>(1, "배");
		boolean result1 = Utility.<Integer, String>compare(p1, p2);
		if (result1)
			System.out.println("논리적으로 동등");
		else
			System.out.println("논리적으로 동등하지 않음");
		boolean result2 = Utility.compare(p2, p3);
		if (result2)
			System.out.println("논리적으로 동등");
		else
			System.out.println("논리적으로 동등하지 않음");
	}

}
