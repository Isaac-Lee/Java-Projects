package main;

public class PurchaseList {	
	//����Ʈ�� ���Ű����� �׸��� ������ �迭
	private static String[][] purchaseList = { { "����_���ں���ϼ���", "9900" }, { "����_���ø���ġ���", "11900" },
			{ "����_�����̼���", "7900" },

			{ "����_���������Ϻ���", "10500" }, { "����_���ھ��̽�ũ���ܺ���", "12500" }, { "����_�������̽�ũ���ܺ���", "12500" },

			{ "����_�̱�ŷ ���̽�ũ��", "3500" }, { "����_����Ʈ ���̽�ũ��", "7200" },

			{ "����_�Ƹ޸�ī�� Tall", "4100" }, { "����_ī��� Tall", "4600" },

			{ "�̵��_�Ƹ޸�ī��", "3200" }, { "�̵��_ī���", "3700" }, { "�̵��_������", "3700" },

			{ "����_����ũƼ+��", "4500" }, { "����_Ÿ�ι�ũƼ+��", "4500" }, { "����_���ݷ���ũƼ+��ũ��", "4500" },
			{ "����_����䱸��Ʈ+ȭ��Ʈ��", "5500" }, { "����_û�����׸�Ƽ���̵�+�˷ο�", "4800" }, { "����_��ũ�� ��׷���Ƽ", "4000" },
			{ "����_��ũ�� �׸�Ƽ", "4000" }, { "����_�����ֽ�", "4600" } };

	//��ü �޴��� ���� ��Ÿ���� ����
	private static int numOfMenu = purchaseList.length;

	public static int getNumOfMenu() {
		return numOfMenu;
	}

	public static String[][] getPurchaseList() {
		return purchaseList;
	}
	
	//Ư�� �޴��� ������ �� �ְ��ϴ� �޼���
	public static void setPurchaseList(int menu,String newMenu, String newPrice) {
		//�޴��� �����ϴ� �κ�
		purchaseList[menu - 1][0] = newMenu;
		purchaseList[menu - 1][1] = newPrice;
	}

}
