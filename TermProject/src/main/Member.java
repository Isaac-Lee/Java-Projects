package main;

/*
 * � �׷��� ������� ��ü
 */

public class Member {
	protected String id = new String();
	protected String pass = new String();
	
	public Member(String id, String pass) {
		this.id = id;
		this.pass = pass;
	}

	public String getId() {
		return id;
	}

	public String getPass() {
		return pass;
	}

	public void setId(String id) {
	}

	public void setPass(String pass) {
	}
}
