package main;

import main.MealList;

public class Student extends Member {
	private int balance = 0;
	private boolean[][] chkList = new boolean[7][3];

	public Student(String st_id, String st_pass) {
		super(st_id,st_pass);
		for (boolean[] arr : chkList) {
			for (int i = 0; i < 3; i++) {
				arr[i] = false;
			}
		}
	}

	public void chk_meal_list(int day, int time) { // day는 요일, time은 아침 점심 저녁
		for (String val : MealList.getMealList(day, time)) {
			System.out.println(val);
		}
	}

	public void chk_meal_list(int day) { // day는 요일, time은 아침 점심 저녁
		for (int i = 0; i < 3; i++) {
			for (String val : MealList.getMealList(day, i)) {
				System.out.println(val);
			}
			System.out.println("\n");
		}
	}

	public void setChkList(int day, int time) { // 안먹는거 신청하면 true
		this.chkList[day][time] = true;
	}

	public void setReChkList(int day, int time) { // 안먹겠다고 신청했던것을 다시 false로 바꿈
		chkList[day][time] = false;
	}

	public boolean getChkList(int day, int time) {
		return chkList[day][time];
	}

	public void earnPoint() {
		this.setBalance(this.getBalance() + 5); // 5pt = 500원

	}

	public void subtractPoint() {
		this.setBalance(this.getBalance() - 5); // 수정했을 때 사용되는 메소드

	}

	public void chkPurchaseList() {
		for (int i = 0; i < PurchaseList.getPurchaseList().length; i++) {
			System.out.println(PurchaseList.getPurchaseList()[i][0] + ", " + PurchaseList.getPurchaseList()[i][1] + "");
		}
	}

	public boolean[][] getChkList() {
		return chkList;
	}
	

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	@Override
	public void setId(String id) {
		this.id = id;		
	}
	
	@Override
	public void setPass(String Pass) {
		this.pass = Pass;		
	}
}
