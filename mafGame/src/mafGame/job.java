package mafGame;

abstract class job {
	public static int[] players = new int[Gameluncher.getPlayerNum()];
	protected int playerId;       // �� ����� ���̵�
	protected int jobNum;       // ���� ��ȣ
	
	
	public static int[] getPlayers() {
		return players;
	}
	public static void setPlayers(int[] players) {
		job.players = players;
	}
	
	public int getJobNum() {
		return jobNum;
	}
	public void setJobNum(int jobNum) {
		this.jobNum = jobNum;
	}
	
	abstract void abilaty();
	
	abstract void vote();
}