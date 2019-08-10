package main;

public class PurchaseList {	
	//포인트로 구매가능한 항목을 저장한 배열
	private static String[][] purchaseList = { { "설빙_초코브라우니설빙", "9900" }, { "설빙_애플망고치즈설빙", "11900" },
			{ "설빙_인절미설빙", "7900" },

			{ "투썸_오리지널팥빙수", "10500" }, { "투썸_초코아이스크림콘빙수", "12500" }, { "투썸_베리아이스크림콘빙수", "12500" },

			{ "베라_싱글킹 아이스크림", "3500" }, { "베라_파인트 아이스크림", "7200" },

			{ "스벅_아메리카노 Tall", "4100" }, { "스벅_카페라떼 Tall", "4600" },

			{ "이디야_아메리카노", "3200" }, { "이디야_카페라떼", "3700" }, { "이디야_녹차라떼", "3700" },

			{ "공차_블랙밀크티+펄", "4500" }, { "공차_타로밀크티+펄", "4500" }, { "공차_초콜렛밀크티+밀크폼", "4500" },
			{ "공차_망고요구르트+화이트펄", "5500" }, { "공차_청포도그린티에이드+알로에", "4800" }, { "공차_밀크폼 얼그레이티", "4000" },
			{ "공차_밀크폼 그린티", "4000" }, { "공차_망고주스", "4600" } };

	//전체 메뉴의 수를 나타내는 변수
	private static int numOfMenu = purchaseList.length;

	public static int getNumOfMenu() {
		return numOfMenu;
	}

	public static String[][] getPurchaseList() {
		return purchaseList;
	}
	
	//특정 메뉴를 수정할 수 있게하는 메서드
	public static void setPurchaseList(int menu,String newMenu, String newPrice) {
		//메뉴를 수정하는 부분
		purchaseList[menu - 1][0] = newMenu;
		purchaseList[menu - 1][1] = newPrice;
	}

}
