package 연습용;
import java.util.*;
/*
 * 1. 학생의 정보 등록
 * 2. 신청 화면
 * 2.1. 아침과 저녁을 먹을건지 말건지 -> 하나라도 안먹으면 포인트를 줌
 * 2.2. 체크함
 * 3.신청 수정
 * 3.1. 등록된 정보가 없다면 빠꾸
 * 3.1. 수정하게 될시 변경되는 포인트 확인
 * 4. 프로그램 종료.
 */

public class 재헌이의코드 {
   static int i=0, chk_again=0, chk_id=0;   //학번, 비밀번호 저장을 위한 변수 i, 신청확인할때 쓰는 변수 chk_again, 학번이 존재하지 않을경우를 체크하는데 쓰는 변수인 chk_id
   static int student_num = 20;          //학생수, 학생수 조절은 이 변수의 수만 바꿔주면 됨.
   static String[] ID = new String[student_num];    //학번이 등록될 배열
   static String[] PASS = new String[student_num]; //비밀번호가 등록될 배열
   static int[] breakfast = new int[student_num];    //아침 식사 여부 확인용 배열
   static int[] dinner = new int[student_num];      //저녁 식사 여부 확인용 배열
   static int[] point = new int[student_num];      //포인트 적립 배열
   static int[] chk_change = new int[student_num]; //신청도 안하고 수정하지 못하게 하는 배열
   
   static Scanner q= new Scanner(System.in); //Y인지 N인지를 입력받을때 쓰는 스캐너.
   
   public static void main(String[] args) {
      
      //학번들을 전부 0으로 초기화함. 원래 0으로 초기화가 된다지만 혹시 모르잖아.
      for(i=0; i<student_num; i++) {
         ID[i]="0";
      }
      i=0;
      
      int say; //여기서는 원하는 기능에 대한 번호 받을때 쓰는 변수임.
      
      //본격적인 프로그램 시작화면
      while(true) {
         System.out.println("=================================");
         System.out.println("1.등록하기 2.신청하기 3.신청수정하기 4.끝내기");
         System.out.println("=================================");
         System.out.print("원하는 기능에 해당하는 번호를 입력해주세요 : ");
         say = q.nextInt();
         
         //switch case문을 통해서 각 번호에 대한 기능들을 실행하려고 했음.
         switch(say) {
            case 1: //등록하기
               apply();
               break;
            case 2:
               apply_check();
               break;
            case 3:
               change();
               break;
            case 4:
               break;
            default:
               System.out.println("\n$다시 입력해주세요.\n");
         }
         if(say==4) {
            System.out.println("프로그램을 종료합니다.");
            break;
         }
      }
      
   }
   
   //학생 정보등록
   public static void input() {
      
      String id, password;
      System.out.print("\n등록할 학번을 적어주세요 : ");
      id = q.next();
      System.out.print("위 학번에 대응하는 비밀번호를 입력해주세요 : ");
      password = q.next();
      ID[i] = id; //입력받은걸 학번 배열과 비밀번호 배열의 같은 번호에 저장. ex) 0번째와 0번째, 1번째와 1번째
      PASS[i] = password;
      i++;
   }
   
   //학생 리스트 불러오기
   public static void list() {
      int j;
      System.out.println("===========================");
      for(j=0; j<student_num; j++) {
         if(ID[0].equals("0")) { //앞에서 0으로 초기화 했으므로 맨 첫번째가 0이다? -> 아무것도 등록되어있지 않다.
            System.out.println("학생정보가 존재하지 않습니다.");
            break;
         }
         else if(ID[j].equals("0")){ //0번째 이후의 학번이 등록되어있지 않으면 for문 종료하기.
            break;
         }
         else {
            System.out.printf("%d. %s\n", j+1, ID[j]); //몇번째인지와 학번을 출력
         }
         
      }
      System.out.println("===========================");
   }
   
   //등록하기
   public static void apply() {
      String yesno; //Y인지 N인지 입력받을때 쓰는 변수
      while(true) {
         System.out.print("\n등록을 하시겠습니까?(Y/N) : ");
         yesno = q.next();
         if(yesno.equals("Y")) { //리스트를 보여주고  학번, 비밀번호를 입력받음.
            list();
            input();
         }
         else if(yesno.equals("N")) { //N일시 종료
            System.out.println("\n$등록을 종료합니다.\n");
            break;
         }
         else { //잘못입력받을시 다음과 같이 출력.
            System.out.print("Y또는 N만 적어주세요.");
         }
      }
   }
   
   //신청하기
   public static void apply_check() {
      
      String id, password, say;
      int k;
      
      if(ID[0].equals("0")) {      //앞에서 0으로 초기화 했으므로 맨 첫번째가 0이다? -> 아무것도 등록되어있지 않다.
         System.out.println("\n$학생정보가 존재하지 않습니다.\n");
      }
      else {   //무언가 등록되어있다면 신청시작.
         System.out.print("학번을 입력해주세요 : ");
         id = q.next();
         //전체 학생수만큼 for문을 돌리면서 입력받은 학번이 존재하는지 찾기. 있다면 chk_id를 1로 바꿈. 없다면 chk_id = 0임.
         for(k=0; k<student_num; k++) {
            if(ID[k].equals(id)) { //입력받은 학번이랑 맞는게 있다면 비밀번호 입력받기 
               System.out.print("비밀번호를 입력해주세요 : ");
               password = q.next();
               
               //비밀번호가 정확하다!! 신청시작하기.
               if(password.equals(PASS[k])) {
                  while(true) {
                     System.out.printf("다음학번으로 신청을 시작하시겠습니까?(Y/N)\n학번 : %s \n--> ",ID[k]);
                     say = q.next();
                     
                     if(say.equals("Y")) {
                        apply_start(k); //신청시작
                        
                        //chk_again이 1이라면 신청을 올바르게 한거니까 종료하기
                        if(chk_again==1) {
                           System.out.print("\n$신청을 종료합니다.\n");
                           chk_change[k]=1; //신청했으니까 그 학번에 해당하는 chk_change를 1로 바꿈.
                           chk_id=1; //맞는 학번이 있으므로 chk_id를 1로 바꾸기.
                           break;
                        }
                        
                        //chk_again이 0이라면 신청을 다시하고싶은거니까 다시 시작하기
                        else if(chk_again==0) {
                           System.out.println("\n$다시 신청을 시작합니다.\n");
                        }
                     }
                     
                     else if(say.equals("N")) {
                        System.out.print("\n$신청을 종료합니다.\n");
                        chk_id=1; //chk_id가 0이면 학번 없다고 나오니까 1로 만들어주기.
                        break;
                     }
                     else {
                        System.out.println("Y또는 N으로 입력해주세요.");
                     }
                  }
                  break;
               }
               //비밀번호 안맞으면 빠꾸
               else if(!password.equals(PASS[k])) {
                  System.out.println("\n$비밀번호가 일치하지 않습니다.\n");
                  chk_id=1; //chk_id가 0이면 학번 없다고 나오니까 1로 만들어주기.
               }
               else if(k==student_num-1) { //이거 왜 넣었냐면 안넣으니까 오류나서 넣음 자꾸 안된다잖아;;;
                  break;
               }
            }
         }
         //chk_id가 0이라면 입력한 학번이 존재하지 않으므로 다음과 같이 출력.
         if(chk_id==0) {
         System.out.println("\n$맞는 학번이 존재하지 않습니다.\n");
         }
         else { //다시 chk_id를 0으로 바꿔주기.
            chk_id=0;
         }
      }   
   }
   
   //본격적인 신청시작
   public static void apply_start(int num) {
      String say;
      
      while(true) {
         while(true) {
            System.out.print("조식을 드시겠습니까?(Y/N) : ");
            say = q.next();
            
            //안먹을시 포인트 받는게 맞니?? 암튼 그렇게 짜보림.
            if(say.equals("Y")) { 
               breakfast[num]=1; //맞을시 학번에 대한 조식배열을 1로 바꿔줌 신청화면 보여줄때 O표시하게 하려면.
               point[num]+=0;
               break;
            }
            else if(say.equals("N")) {
               breakfast[num]=0; //틀릴시 학번에 대한 조식배열을 0으로 바꿔줌 신청화면 보여줄때 X표시하게 하려면.
               point[num]+=100;
               break;
            }
            else {
               System.out.println("\n$대답은 'Y'또는'N'으로만 해주세요");
            }
         }
         //위와 같은 얘기
         while(true) {
            System.out.print("석식을 드시겠습니까?(Y/N) : ");
            say = q.next();
            if(say.equals("Y")) {
               dinner[num]=1;
               point[num]+=0;
               break;
            }
            else if(say.equals("N")) {
               dinner[num]=0;
               point[num]+=100;
               break;
            }
            else {
               System.out.println("\n$대답은 'Y'또는'N'으로만 해주세요\n");
            }
         }
         show_point(num); //신청화면 보여주기.
         System.out.print("이대로 진행하시겠습니까?(Y/N) : ");
         say=q.next();
         if(say.equals("Y")) {
            break;
         }
         else if(say.equals("N")) { //이대로 진행 못하면 다 초기화 시키고 신청 다시 시작하기.
            System.out.println("\n$조식,석식 여부 및 포인트를 초기화합니다.");
            breakfast[num]=0;
            dinner[num]=0;
            point[num]=0;
            break;
         }
      }
      if(say.equals("N")) { //chk_again을 0으로 해서 다시 신청하게 하기
         chk_again = 0;
      }
      else if(say.equals("Y")){ //chk_again을 1로 해서 바로 끝내보리기.
         chk_again = 1;
      }
   }
   
   //신청수정하기
   public static void change() {
      String id, password, say;
      int k;
      
      if(ID[0].equals("0")) { //앞에서 0으로 초기화 했으므로 맨 첫번째가 0이다? -> 아무것도 등록되어있지 않다.
         System.out.println("\n$학생정보가 존재하지 않습니다.\n");
      }
      
      else {
         System.out.print("학번을 입력해주세요 : ");
         id = q.next();
         for(k=0; k<student_num; k++) { 
            if(ID[k].equals(id)) {
               System.out.print("비밀번호를 입력해주세요 : ");
               password = q.next();
               if(chk_change[k]==0) { //학번에 해당하는 chk_change가 0이라면 신청도 안하고 수정하려하는거니까 빠꾸. 
                  System.out.println("\n$신청하지 않았다면 수정 할 수 없습니다.\n");
                  chk_id=1;      //이거 1로 안바꾸면 아시죠? 맞는 학번이 존재하지 않습니다. <-- 요거 나옴
                  break;
               }
               
               else if(password.equals(PASS[k])) {
                  while(true) {
                     System.out.printf("다음학번으로 신청수정을 시작하시겠습니까?(Y/N)\n학번 : %s \n--> ",ID[k]);
                     say = q.next();
                     if(say.equals("Y")) {
                        point_change(k);//신청수정시작
                        if(chk_again==1) {
                           System.out.print("\n$신청을 종료합니다.\n");
                           chk_id=1;
                           break;
                        }
                        else if(chk_again==0) {
                           System.out.println("\n$다시 신청수정을 시작합니다.\n");
                        }
                     }
                     else if(say.equals("N")) {
                        System.out.print("\n$신청수정을 종료합니다.\n");
                        break;
                     }
                     else {
                        System.out.println("Y또는 N으로 입력해주세요.");
                     }
                  }
                  break;
               }
               else if(k==student_num-1) {
                  break;
               }
            }
         }
         if(chk_id==0) {
         System.out.println("\n$맞는 학번이 존재하지 않습니다.\n");
         }
         else {
            chk_id=0;
         }
      }
   }
   
   //포인트 보여주기 함수.
   public static void show_point(int num) {
      String yes = "O";
      String no = "X";
      System.out.printf("학번 : %s의 신청현황은 다음과 같습니다.\n", ID[num]);
      System.out.println("===========================");
      if(breakfast[num]==1) { //1이면 O 0이면 X!!
         System.out.printf("조식 : %s\n", yes);
      }
      else if(breakfast[num]==0) {
         System.out.printf("조식 : %s\n", no);
      }
      if(dinner[num]==1) {
         System.out.printf("석식 : %s\n", yes);
      }
      else if(dinner[num]==0) {
         System.out.printf("조식 : %s\n", no);
      }
      System.out.println("---------");
      System.out.printf("총 포인트  = %d\n", point[num]);
      System.out.println("===========================");
   }
   
   // 신청수정 본격적으로 시작하기!!
   public static void point_change(int num) {
      String say;
      
      show_point(num);
      
      System.out.println("$신청수정을 시작합니다.\n");
      breakfast[num]=0;
      dinner[num]=0;
      point[num]=0;
      
      while(true) {
         while(true) {
            System.out.print("조식을 드시겠습니까?(Y/N) : ");
            say = q.next();
            if(say.equals("Y")) {
               breakfast[num]=1;
               point[num]+=0;
               break;
            }
            else if(say.equals("N")) {
               breakfast[num]=0;
               point[num]+=100;
               break;
            }
            else {
               System.out.println("\n$대답은 'Y'또는'N'으로만 해주세요");
            }
         }
         while(true) {
            System.out.print("석식을 드시겠습니까?(Y/N) : ");
            say = q.next();
            if(say.equals("Y")) {
               dinner[num]=1;
               point[num]+=0;
               break;
            }
            else if(say.equals("N")) {
               dinner[num]=0;
               point[num]+=100;
               break;
            }
            else {
               System.out.println("\n$대답은 'Y'또는'N'으로만 해주세요\n");
            }
         }
         System.out.print("이대로 진행하시겠습니까?(Y/N) : ");
         say=q.next();
         if(say.equals("Y")) {
            break;
         }
         else if(say.equals("N")) {
            System.out.println("\n$조식,석식 여부 및 포인트를 초기화합니다.");
            breakfast[num]=0;
            dinner[num]=0;
            point[num]=0;
            break;
         }
      }
      if(say.equals("N")) {
         chk_again = 0;
      }
      else if(say.equals("Y")){
         chk_again = 1;
      }
   }
}