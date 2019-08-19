package mafGame;

import java.util.Scanner;

public class Gameluncher {
	private static int playerNum;


	public static int getPlayerNum() {
		return playerNum;
	}

	public static void setPlayerNum(int playerNum) {
		Gameluncher.playerNum = playerNum;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("게임 인원 수 입력: ");
		int p_num = input.nextInt();
		Gameluncher.setPlayerNum(p_num);
	}
}
