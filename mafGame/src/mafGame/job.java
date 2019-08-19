package mafGame;

abstract class job {
	public static int[] players = new int[Gameluncher.getPlayerNum()];
	protected int playerId;       // 각 사람별 아이디
	protected int jobNum;       // 직업 번호
	
	
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