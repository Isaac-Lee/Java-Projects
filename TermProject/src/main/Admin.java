package main;

public class Admin extends Member {
	
	public Admin() {
		super("admin", "hellocse");
	}
	
	public Admin(String id, String pass) {
		super (id, pass);
	}
	
	public static void chkMealList(int day, int time) { // day�� ����, time�� ��ħ ���� ����
		for (String val : MealList.getMealList(day - 1, time - 1)) {
			System.out.println(val);
		}
	}

	public static void chkStuId() { // ��� �л��� ���̵� �˻�
		for (int i = 0; i < Dormitory_Restaurant.getStudentNumber(); i++) {
			System.out.println(Dormitory_Restaurant.getMembers()[i].getId());
		}
	}

	public static void chkStuInfo(String id) { // �л� ���� ���
		for (int i = 0; i < Dormitory_Restaurant.getStudentNumber(); i++) {
			if (Dormitory_Restaurant.getMembers()[i].getId().equals(id)) {
				System.out.println("***�л� ����***");
				System.out.println("�й�: " + Dormitory_Restaurant.getMembers()[i].getId());
				System.out.println("����Ʈ: " + Dormitory_Restaurant.getMembers()[i].getBalance() + "����Ʈ");
			}
		}
	}

	public static void chkPurchaseList() {
		for (int i = 0; i < PurchaseList.getPurchaseList().length; i++) {
			System.out
					.println(PurchaseList.getPurchaseList()[i][0] + ", " + PurchaseList.getPurchaseList()[i][1] + "��");
		}
	}
}
