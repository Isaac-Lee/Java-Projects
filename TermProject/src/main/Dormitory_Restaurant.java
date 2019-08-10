/*
 * 7조 자바 텀프로젝트
 * 이태홍, 이예성, 노유정
 * 
 * 프로그램의 설명
 * 이유: 
*기숙사를 사용하는 기숙사생들에게는 공통적인 불편함에서 착안함.
*식당의 입장에서 급식 인원을 정확히 알 수 있게 할 수 있음.

*간단한 설명:
*기숙사 식당을 이용하지 않을 때를 미리 신청하면 포인트를 학생에게 지급하고 포인트를 통해 상품을 구매할 수 있게 함.

*기능들:
*-학생
*급식 조회, 포인트 환급 신청/수정, 포인트로 구매 가능한 항목 조회

*-관리자
*급식 조회/수정, 포인트 구매항목 조회/수정, 학생 정보 조회

 * 역할 분담:
*이태홍
*-Student클래스
*-MealList클래스
*-Main함수 내에 Student 클래스 관련 메서드 구현
*-실행오류 예외처리

*이예성
*-Main함수 내에 로그인 회원가입 관련 기능 구현
*-Admin클래스
*-Main함수 내에 Admin 관련 메서드 구현
*-실행오류 예외처리

*노유정
*-PurchaseList클래스
*–Main함수 논리 오류 / 실행 오류 발견 및  예외처리
*-프로그램의 부족한 기능, 문제상황 해결에 필요한 기능 아이디어 제공

 * 
 * 현재 상태 / 개선방안:
*현재 모든 기능들은 오류없이 실행가능

*급식 메뉴들과 포인트 구매 항목들을 상속을 이용해서 구현

*포인트 구매 항목을 실제로 구매할 수 있는 형태로 바꿔 구현

*관리자가 특정한 특징을 가진 학생들을 조회가능하게 구현

*학생의 필드에 이름과 나이 등 기초적인 신상 정보를 명시

 * 
 * main 함수가 있는 class
*/

package main;

import java.util.*;
import main.Admin;

public class Dormitory_Restaurant {
	private static int studentNumber = 0; // 학생수는 정적 변수
	private static int totalStudent = 20; // 20명이 최대 이용가능

	private static Student[] students = new Student[totalStudent]; // 학생(멤버) 객체가 담길 배열

	public static Student[] getMembers() {
		return students;
	}

	public static int getStudentNumber() {
		return studentNumber;
	}

	public static void main(String[] args) { // main함수

		boolean login = false; // 로그인이 성공하면 true
		int memberId = 0; // 누가 로그인 했는지 체크
		boolean admin = false; // 어드민이 로그인 했는지 체크

		Admin Ad1 = new Admin();

		Scanner input = new Scanner(System.in);
		/*
		 * 전체 프로그램의 반복문, 특정 사용자가 로그아웃을 해도 프로그램이 종료 되지 않고 로그인 회원가입 인터페이스에서 종료를 해야 종료가 되게
		 * 구현
		 */
		Enter: while (true) {
			entering: while (true) { // 로그인 회원가입 인터페이스
				int user_input = 0;

				while (true) {
					// 문자등 Int형 외에 다른 자료형이 입력되면 다시 입력받게하는 예외처리
					try {
						System.out.println("\n\n        &기숙사 식당 이용프로그램&");
						System.out.println("===================================");
						System.out.println("1.로그인/관리자 로그인        2.회원가입        3.종료");
						System.out.println("===================================");
						System.out.print("\n# 원하는 기능에 해당하는 번호를 입력해주세요 : ");
						user_input = input.nextInt();
						break;
					}

					catch (InputMismatchException e) {
						System.out.println("# 입력이 잘못 되었습니다. 다시 입력해주세요.");
						input = new Scanner(System.in);
						continue;
					}
				}

				if (user_input == 1) {
					String yes_no; // Y인지 N인지 입력받을때 쓰는 변수
					String id = null; // 사용자가 입력하는 아이디
					String pass = null; // 사용자가 입력하는 비밀번호

					login: // 반복문 레이블링
					while (login == false || admin == false) { // 수정이 필요합니다
						System.out.print("# 로그인 하시겠습니까?(Y/N) : ");
						yes_no = input.next();

						if (yes_no.equals("Y")) {
							System.out.print("\n\n# 아이디를 입력하세요(학번): ");
							id = input.next();
							System.out.print("# 패스워드를 입력하세요: ");
							pass = input.next();

							// 먼저 관리자로 로그인 가능한지 확인하는 코드
							if (id.equals(Ad1.getId())) {
								if (pass.equals(Ad1.getPass())) {
									System.out.println("\n\n# 관리자로 로그인 되었습니다.");
									admin = true;
									break entering;
								}

								else {
									System.out.println("\n# 로그인에 실패 하였습니다.");
									continue login;
								}
							}

							// 등록된 학생이 없으면 로그인창으로 복귀하게 하는 코드
							if (studentNumber == 0) {
								System.out.println("\n# 등록된 정보가 없습니다. 정보를 먼저 등록하세요.\n");
								continue entering;
							}

							int index = 0; // 몇번째 학생인지 찾는 용도의 변수

							for (int i = 0; i < Dormitory_Restaurant.getStudentNumber(); i++) { // 로그인 시스템
								if (id.equals(students[i].getId())) { // 아이디가 있는 검색
									if (pass.equals(students[i].getPass())) { // 그 아이디의 암호인지 확인
										System.out.println("\n\n# 로그인 되었습니다.");
										login = true;
										memberId = index;
										break entering; // 로그인 인터페이스에서 탈출
									}

									else {
										System.out.println("\n\n# 로그인에 실패 하였습니다.");
										continue login;
									}
								}

								else {
									index++;
									continue;
								}
							}
							System.out.println("\n# 아이디나 비밀번호를 다시 입력해주세요.");
							continue login;
						}

						else if (yes_no.equals("N")) { // N일시 종료
							login = false;
							break;
						}

						else { // 잘못입력받을시 다음과 같이 출력.
							System.out.print("\n# Y또는 N만 적어주세요.");
							login = false;
						}
					}
				}

				else if (user_input == 2) {
					String yes_no; // Y인지 N인지 입력받을때 쓰는 변수
					String id = null;
					String pass = null;

					submit: while (true) {
						System.out.print("\n# 등록하시겠습니까?(Y/N) : ");
						yes_no = input.next();

						if (yes_no.equals("Y")) {
							System.out.print("\n# 등록할 아이디를 입력하세요(학번) : ");
							id = input.next();

							// 중복된 아이디가 없게하기 위해 전에 등록된 아이디와 대조 후 같으면 다시 입력받게 하는 코드
							for (int i = 0; i < Dormitory_Restaurant.getStudentNumber(); i++) {
								if (id.equals(students[i].getId())) {
									System.out.println("\n\n# 사용할 수 없는 아이디 입니다. 다시 입력해 주새요.");
									continue submit;
								}
							}

							if (id.length() < 9) {
								System.out.println("\n# 학번을 올바르게 입력해 주세요.");
								continue submit;
							} else if (id.length() > 9) {
								System.out.println("\n# 학번을 올바르게 입력해 주세요.");
								continue submit;
							}

							System.out.print("# 등록할 패스워드를 입력하세요 : ");
							pass = input.next();
							System.out.println("\n# 등록되었습니다. 등록한 정보로 로그인 해주세요.");
							Student stu = new Student(id, pass); // 새로운 스튜던트 객체 생성
							students[studentNumber] = stu; // 스튜던트 객체를 맴버배열에 저장
							studentNumber++; // 등록된 학생수를 1증가
							break;
						}

						else if (yes_no.equals("N")) { // N일시 종료
							System.out.println("\n# 등록을 종료합니다.");
							break;
						}

						else { // 잘못입력받을시 다음과 같이 출력.
							System.out.print("\n# Y또는 N만 적어주세요.");
						}
					}
				}

				else if (user_input == 3) {
					System.out.println("\n# 시스템을 종료합니다.");
					break Enter;
				}

				else {
					System.out.println("\n# 다시 입력해 주세요.");
				}
			}

			// 학생으로 로그인시 샐행되는 코드
			student: while (login) { // 로그인이 트루 일때 사용됨
				int function; // 사용자가 입력하는 기능을 알아보는 변수
				int day;
				int time;
				String yes_no;

				System.out.println("\n\n====================================================");
				System.out.println("1. 식단검색    2. 신청    3. 신청수정    4. 포인트 구매항목 조회    5. 종료");
				System.out.println("====================================================\n");

				System.out.print("\n# 원하는 기능에 해당하는 번호를 입력해주세요 : ");
				function = input.nextInt();

				if (function == 1) {
					while (true) {
						System.out.print(
								"\n# 검색할 요일에 해당하는 번호를 입력해주세요.(1.월요일  2.화요일  3.수요일  4.목요일  5.금요일  6.토요일  7.일요일): ");
						// Int형 외에 다른 입력이 되는 경우 예외처리
						try {
							day = input.nextInt();
							break;
						}

						catch (InputMismatchException e) {
							System.out.println("\n# 입력이 잘못 되었습니다. 다시 입력해주세요.");
							input = new Scanner(System.in);
							continue;
						}
					}
					System.out.println("\n");
					students[memberId].chk_meal_list(day - 1); // 입력한 요일의 모든 시간대의 메뉴를 검색
					continue;
				}

				else if (function == 2) {
					while (true) {
						System.out.print(
								"\n# 신청할 요일에 해당하는 번호를 입력해주세요.(1.월요일  2.화요일  3.수요일  4.목요일  5.금요일  6.토요일  7.일요일): ");
						// Int형 외에 다른 입력이 되는 경우 예외처리
						try {
							day = input.nextInt();
						}

						catch (InputMismatchException e) {
							System.out.println("\n# 입력이 잘못 되었습니다. 다시 입력해주세요.");
							input = new Scanner(System.in);
							continue;
						}
						if (day > 7) {
							System.out.println("\n# 입력이 잘못 되었습니다. 다시 입력해주세요.");
							continue;
						}
						break;
					}
					while (true) {
						System.out.print("# 신청할 시간에 해당하는 번호를 입력해주세요. (1.조식  2.중식  3.석식): ");
						// Int형 외에 다른 입력이 되는 경우 예외처리
						try {
							time = input.nextInt();
							System.out.println("");
						}

						catch (InputMismatchException e) {
							System.out.println("\n# 입력이 잘못 되었습니다. 다시 입력해주세요.");
							continue;
						}
						if (time > 3) {
							System.out.println("\n# 입력이 잘못 되었습니다. 다시 입력해주세요.");
							continue;
						}
						break;
					}

					// 입력받은 날짜 시간의 메뉴를 출력
					for (String menu : MealList.getMealList(day - 1, time - 1)) {
						System.out.println(menu);
					}

					System.out.print("\n# 신청하시겠습니까?(Y/N): ");
					yes_no = input.next();
					if (yes_no.equals("Y")) {
						students[memberId].setChkList(day - 1, time - 1); // 신청 날짜 시간의 신청상태를 true로 전환
						System.out.println("\n# 신청되었습니다.");
						students[memberId].earnPoint(); // 로그인 된 학생 포인트 추가
						continue;
					}

					else if (yes_no.equals("N")) { // N일시 종료
						System.out.println("\n# 등록을 종료합니다.\n");
					}

					else { // 잘못입력받을시 다음과 같이 출력.
						System.out.print("\n# Y또는 N만 적어주세요.");
					}
				}

				else if (function == 3) {
					boolean thereEx = false; // 신청된 식단이 있는지 확인하는 코드
					System.out.println("\n# 현재 신청된 식단");
					for (int i = 0; i <= 6; i++) {
						for (int j = 0; j <= 2; j++) {
							if (students[memberId].getChkList(i, j)) { // 신청 배열의 값들중 신청상태가 트루이면 실행된다.
								switch (i) {
								case 0:
									System.out.print("<월요일  ");
									break;
								case 1:
									System.out.print("<화요일  ");
									break;
								case 2:
									System.out.print("<수요일  ");
									break;
								case 3:
									System.out.print("<목요일  ");
									break;
								case 4:
									System.out.print("<금요일  ");
									break;
								case 5:
									System.out.print("<토요일  ");
									break;
								case 6:
									System.out.print("<일요일  ");
									break;
								}
								switch (j) {
								case 0:
									System.out.println("조식>");
									break;
								case 1:
									System.out.println("중식>");
									break;
								case 2:
									System.out.println("석식>");
								}
								thereEx = true; // 하나라도 신청 식단이 있으면 true
								students[memberId].chk_meal_list(i, j);

							}

						}
					}

					 if (thereEx == false) {
		                  System.out.println("\n# 현재 신청된 식단이 없습니다.");
		                  continue student;
		               }
					 while (true) {
		                  System.out.print("\n# 수정할 요일에 해당하는 번호를 입력해주세요. (1.월요일  2.화요일  3.수요일  4.목요일  5.금요일  6.토요일  7.일요일): ");
		                  try {
		                     day = input.nextInt();
		                  }
		                  catch (InputMismatchException e) {
		                     System.out.println("\n# 입력이 잘못 되었습니다. 다시 입력해주세요.");
		                     input = new Scanner(System.in);
		                     continue;
		                  }
		                  if (day > 7) {
		                      System.out.println("\n# 입력이 잘못 되었습니다. 다시 입력해주세요.");
		                      continue;
		                   }
		                   
		                   System.out.print("# 수정할 시간에 해당하는 번호를 입력해주세요. (1.조식  2.중식  3.석식): ");
		                   try {
		                      time = input.nextInt();
		                   }

		                   catch (InputMismatchException e) {
		                      System.out.println("\n# 입력이 잘못 되었습니다. 다시 입력해주세요.");
		                      continue;
		                   }
						if (time > 3) {
		                     System.out.println("\n# 입력이 잘못 되었습니다. 다시 입력해주세요.");
		                     continue;
		                  }
		                  break;
		               }
					for (String menu : MealList.getMealList(day - 1, time - 1)) {
						System.out.println(menu);
					}
					System.out.print("\n# 수정하시겠습니까?(Y/N): ");
		               yes_no = input.next();

		               if (yes_no.equals("Y")) {
		                  students[memberId].setReChkList(day - 1, time - 1); // 신청 날짜 시간 false 로 전환
		                  System.out.println("\n# 수정되었습니다.");
		                  students[memberId].subtractPoint(); // 로그인 된 학생 포인트 감소
		                  continue;
		               } else if (yes_no.equals("N")) { // N일시 종료
		                  System.out.println("\n# 수정을 종료합니다.\n");
		               } else { // 잘못입력받을시 다음과 같이 출력.
		                  System.out.print("\n# Y또는 N만 적어주세요.");
		               }
		            }

				else if (function == 4) {
		               System.out.print("\n# 현재 보유하고 있는 포인트는 <");
		               System.out.print(students[memberId].getBalance());
		               System.out.print("pt>입니다.\n");

		               System.out.println("<포인트로 구매가능한 상품 목록> \n");
		               students[memberId].chkPurchaseList();
		            }

				else if (function == 5) {
					continue Enter;
				}

				else {
					System.out.println("\n# 다시 입력해 주세요.");
					continue;
				}

			}

			while (admin) { // 어드민일때 작동하는 메인
				int function;
				int day = 0;
				int time = 0;

				String yes_no;

				System.out.println("\n\n============================================================================================");
	            System.out.println("1. 식단검색    2. 식단수정    3. 학생 조회    4. 학생 정보 조회    5. 포인트 구매가능 항목 수정    6. 포인트 구매가능 항목 조회    7. 종료");
	            System.out.println("============================================================================================\n");

	            System.out.print("\n# 원하는 기능에 해당하는 번호를 입력해주세요 : ");
				// Int형 외에 다른 입력이 되는 경우 예외처리
	            try {
	                function = input.nextInt();
	             } catch (InputMismatchException e) {
	                System.out.println("\n# 입력이 잘못 되었습니다. 다시 입력해주세요.");
	                input = new Scanner(System.in);
	                continue;
	             }

	            if (function == 1) {
	                while (true) {
	                   System.out.print("# 검색할 요일에 해당하는 번호를 입력해주세요.(1.월요일  2.화요일  3.수요일  4.목요일  5.금요일  6.토요일  7.일요일): ");
	                   // Int형 외에 다른 입력이 되는 경우 예외처리
	                   try {
	                      day = input.nextInt();
	                      break;
	                   } catch (InputMismatchException e) {
	                      System.out.println("\n# 입력이 잘못 되었습니다. 다시 입력해주세요.");
	                      input = new Scanner(System.in);
	                      continue;
	                   }
	                }
	                while (true) {
	                    System.out.print("검색할 시간에 해당하는 번호를 입력해주세요. (1.조식  2.중식 3.석식): ");
	                    // Int형 외에 다른 입력이 되는 경우 예외처리
	                    try {
	                       time = input.nextInt();
	                    }

	                    catch (InputMismatchException e) {
	                       System.out.println("\n# 입력이 잘못 되었습니다. 다시 입력해주세요.");
	                       continue;
	                    }
	                    if (time > 3) {
	                       System.out.println("\n# 입력이 잘못 되었습니다. 다시 입력해주세요.");
	                       continue;
	                    }
	                    break;
	                 }
					Admin.chkMealList(day, time);
				}

	            else if (function == 2) {
	                while (true) {
	                   System.out.print("\n# 수정할 요일에 해당하는 번호를 입력해주세요. (1.월요일  2.화요일  3.수요일  4.목요일  5.금요일  6.토요일  7.일요일): ");
	                   // Int형 외에 다른 입력이 되는 경우 예외처리
	                   try {
	                      day = input.nextInt();
	                   }

	                   catch (InputMismatchException e) {
	                      System.out.println("\n# 입력이 잘못 되었습니다. 다시 입력해주세요.");
	                      input = new Scanner(System.in);
	                      continue;
	                   }
	                   if (day > 7) {
	                       System.out.println("\n# 입력이 잘못 되었습니다. 다시 입력해주세요.");
	                       continue;
	                    }
	                    break;
	                 }
	                while (true) {
	                    System.out.print("수정할 시간에 해당하는 번호를 입력해주세요. (1.조식 2.중식 3.석식): ");
	                    // Int형 외에 다른 입력이 되는 경우 예외처리
	                    try {
	                       time = input.nextInt();
	                    }

	                    catch (InputMismatchException e) {
	                       System.out.println("\n# 입력이 잘못 되었습니다. 다시 입력해주세요.");
	                       continue;
	                    }
	                    if (time > 3) {
	                       System.out.println("\n# 입력이 잘못 되었습니다. 다시 입력해주세요.");
	                       continue;
	                    }
	                    break;
	                 }
					Admin.chkMealList(day, time);
					System.out.print("\n# 수정하시겠습니까?(Y/N): ");
		               yes_no = input.next();
		               if (yes_no.equals("Y")) {
		                  System.out.print("\n# 수정할 식단의 메뉴 수를 입력하세요: ");
		                  int num = input.nextInt();

		                  String[] meal = new String[num];

		                  for (int i = 0; i < num; i++) {
		                     System.out.print("# 메뉴를 입력해주세요: ");
		                     String food = input.next();
		                     meal[i] = food;
		                  }
		                  MealList.setMealList(day, time, meal);
		                  System.out.println("\n# 수정되었습니다.");
		                  continue;
		               } else if (yes_no.equals("N")) { // N일시 종료
		                  System.out.println("\n# 수정을 취소합니다.\n");
		               } else { // 잘못입력받을시 다음과 같이 출력.
		                  System.out.print("\n# Y또는 N만 적어주세요.");
		               }
				}

	            else if (function == 3) {

	                if (studentNumber == 0) {
	                   System.out.println("\n# 등록된 학생이 없습니다.\n");
	                   continue;
	                }

	                System.out.print("\n# 학생 학번 조회를 시작합니다.");
	                System.out.print("<학생 학번 목록>");
	                Admin.chkStuId();
	                continue;
	             }

	            else if (function == 4) {
	                if (studentNumber == 0) {
	                   System.out.println("\n# 등록된 학생이 없습니다.\n");
	                   continue;
	                }

	                System.out.print("\n# 원하시는 학생의 학번을 입력하세요: ");
	                String id = input.next();
	                Admin.chkStuInfo(id);
	                continue;
	             }

	             else if (function == 5) {
	                //모든 메뉴에 번호를 붙여 출력하는 코드
	                for (int i = 0; i < PurchaseList.getNumOfMenu(); i++) {
	                   System.out.print(i + 1);
	                   System.out.print(" 번째 메뉴: ");
	                   System.out.print(PurchaseList.getPurchaseList()[i][0]);
	                   System.out.println("\n");
	                }

	                System.out.print("\n# 수정하고 싶은 메뉴 번호를 입력하세요: ");
	                int menu = input.nextInt();

	                System.out.print("# 무슨 메뉴로 수정할지 메뉴 이름을 입력하세요: ");
	                String newMenu = input.next();
	                System.out.println("");
	                System.out.print("# 새 메뉴의 가격을 입력하세요: ");
	                String newPrice = input.next();
	                PurchaseList.setPurchaseList(menu, newMenu, newPrice);
	                continue;
	             }

	             else if (function == 6) {
	                Admin.chkPurchaseList();
	                continue;
	             }

	             else if (function == 7) {
	                continue Enter;
	             }

	             else {
	                System.out.println("\n\n다시 입력해 주세요.");
	                continue;
				}
			}
		}
		input.close();
	}
}
