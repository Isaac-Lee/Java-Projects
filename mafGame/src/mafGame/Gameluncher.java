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
		System.out.print("���� �ο� �� �Է�: ");
		int p_num = input.nextInt();
		Gameluncher.setPlayerNum(p_num);
	}
}
