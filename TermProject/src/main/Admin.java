package main;

public class Admin extends Member {
	
	public Admin() {
		super("admin", "hellocse");
	}
	
	public Admin(String id, String pass) {
		super (id, pass);
	}
	
	public static void chkMealList(int day, int time) { // day는 요일, time은 아침 점심 저녁
		for (String val : MealList.getMealList(day - 1, time - 1)) {
			System.out.println(val);
		}
	}

	public static void chkStuId() { // 모든 학생의 아이디 검색
		for (int i = 0; i < Dormitory_Restaurant.getStudentNumber(); i++) {
			System.out.println(Dormitory_Restaurant.getMembers()[i].getId());
		}
	}

	public static void chkStuInfo(String id) { // 학생 정보 출력
		for (int i = 0; i < Dormitory_Restaurant.getStudentNumber(); i++) {
			if (Dormitory_Restaurant.getMembers()[i].getId().equals(id)) {
				System.out.println("***학생 정보***");
				System.out.println("학번: " + Dormitory_Restaurant.getMembers()[i].getId());
				System.out.println("포인트: " + Dormitory_Restaurant.getMembers()[i].getBalance() + "포인트");
			}
		}
	}

	public static void chkPurchaseList() {
		for (int i = 0; i < PurchaseList.getPurchaseList().length; i++) {
			System.out
					.println(PurchaseList.getPurchaseList()[i][0] + ", " + PurchaseList.getPurchaseList()[i][1] + "원");
		}
	}
}
