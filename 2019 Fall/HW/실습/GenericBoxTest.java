package �ǽ�;

public class GenericBoxTest {
	public static void main(String[] args) {
		GenericBox<String> box1 = new GenericBox<String>();
		box1.set("���׸�");
		GenericBox<Integer> box2 = new GenericBox<Integer>();
		box2.set(10);
		System.out.println("box2 = " + box2.get());
		GenericBox<Boolean> box3 = new GenericBox<Boolean>();
		box3.set("true");
		System.out.println("box3 = "+ box3.get());
	}
	// ���� �ڵ��� �����κ��� �ùٸ��� ����

}
