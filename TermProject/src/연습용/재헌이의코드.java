package ������;
import java.util.*;
/*
 * 1. �л��� ���� ���
 * 2. ��û ȭ��
 * 2.1. ��ħ�� ������ �������� ������ -> �ϳ��� �ȸ����� ����Ʈ�� ��
 * 2.2. üũ��
 * 3.��û ����
 * 3.1. ��ϵ� ������ ���ٸ� ����
 * 3.1. �����ϰ� �ɽ� ����Ǵ� ����Ʈ Ȯ��
 * 4. ���α׷� ����.
 */

public class ���������ڵ� {
   static int i=0, chk_again=0, chk_id=0;   //�й�, ��й�ȣ ������ ���� ���� i, ��ûȮ���Ҷ� ���� ���� chk_again, �й��� �������� ������츦 üũ�ϴµ� ���� ������ chk_id
   static int student_num = 20;          //�л���, �л��� ������ �� ������ ���� �ٲ��ָ� ��.
   static String[] ID = new String[student_num];    //�й��� ��ϵ� �迭
   static String[] PASS = new String[student_num]; //��й�ȣ�� ��ϵ� �迭
   static int[] breakfast = new int[student_num];    //��ħ �Ļ� ���� Ȯ�ο� �迭
   static int[] dinner = new int[student_num];      //���� �Ļ� ���� Ȯ�ο� �迭
   static int[] point = new int[student_num];      //����Ʈ ���� �迭
   static int[] chk_change = new int[student_num]; //��û�� ���ϰ� �������� ���ϰ� �ϴ� �迭
   
   static Scanner q= new Scanner(System.in); //Y���� N������ �Է¹����� ���� ��ĳ��.
   
   public static void main(String[] args) {
      
      //�й����� ���� 0���� �ʱ�ȭ��. ���� 0���� �ʱ�ȭ�� �ȴ����� Ȥ�� ���ݾ�.
      for(i=0; i<student_num; i++) {
         ID[i]="0";
      }
      i=0;
      
      int say; //���⼭�� ���ϴ� ��ɿ� ���� ��ȣ ������ ���� ������.
      
      //�������� ���α׷� ����ȭ��
      while(true) {
         System.out.println("=================================");
         System.out.println("1.����ϱ� 2.��û�ϱ� 3.��û�����ϱ� 4.������");
         System.out.println("=================================");
         System.out.print("���ϴ� ��ɿ� �ش��ϴ� ��ȣ�� �Է����ּ��� : ");
         say = q.nextInt();
         
         //switch case���� ���ؼ� �� ��ȣ�� ���� ��ɵ��� �����Ϸ��� ����.
         switch(say) {
            case 1: //����ϱ�
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
               System.out.println("\n$�ٽ� �Է����ּ���.\n");
         }
         if(say==4) {
            System.out.println("���α׷��� �����մϴ�.");
            break;
         }
      }
      
   }
   
   //�л� �������
   public static void input() {
      
      String id, password;
      System.out.print("\n����� �й��� �����ּ��� : ");
      id = q.next();
      System.out.print("�� �й��� �����ϴ� ��й�ȣ�� �Է����ּ��� : ");
      password = q.next();
      ID[i] = id; //�Է¹����� �й� �迭�� ��й�ȣ �迭�� ���� ��ȣ�� ����. ex) 0��°�� 0��°, 1��°�� 1��°
      PASS[i] = password;
      i++;
   }
   
   //�л� ����Ʈ �ҷ�����
   public static void list() {
      int j;
      System.out.println("===========================");
      for(j=0; j<student_num; j++) {
         if(ID[0].equals("0")) { //�տ��� 0���� �ʱ�ȭ �����Ƿ� �� ù��°�� 0�̴�? -> �ƹ��͵� ��ϵǾ����� �ʴ�.
            System.out.println("�л������� �������� �ʽ��ϴ�.");
            break;
         }
         else if(ID[j].equals("0")){ //0��° ������ �й��� ��ϵǾ����� ������ for�� �����ϱ�.
            break;
         }
         else {
            System.out.printf("%d. %s\n", j+1, ID[j]); //���°������ �й��� ���
         }
         
      }
      System.out.println("===========================");
   }
   
   //����ϱ�
   public static void apply() {
      String yesno; //Y���� N���� �Է¹����� ���� ����
      while(true) {
         System.out.print("\n����� �Ͻðڽ��ϱ�?(Y/N) : ");
         yesno = q.next();
         if(yesno.equals("Y")) { //����Ʈ�� �����ְ�  �й�, ��й�ȣ�� �Է¹���.
            list();
            input();
         }
         else if(yesno.equals("N")) { //N�Ͻ� ����
            System.out.println("\n$����� �����մϴ�.\n");
            break;
         }
         else { //�߸��Է¹����� ������ ���� ���.
            System.out.print("Y�Ǵ� N�� �����ּ���.");
         }
      }
   }
   
   //��û�ϱ�
   public static void apply_check() {
      
      String id, password, say;
      int k;
      
      if(ID[0].equals("0")) {      //�տ��� 0���� �ʱ�ȭ �����Ƿ� �� ù��°�� 0�̴�? -> �ƹ��͵� ��ϵǾ����� �ʴ�.
         System.out.println("\n$�л������� �������� �ʽ��ϴ�.\n");
      }
      else {   //���� ��ϵǾ��ִٸ� ��û����.
         System.out.print("�й��� �Է����ּ��� : ");
         id = q.next();
         //��ü �л�����ŭ for���� �����鼭 �Է¹��� �й��� �����ϴ��� ã��. �ִٸ� chk_id�� 1�� �ٲ�. ���ٸ� chk_id = 0��.
         for(k=0; k<student_num; k++) {
            if(ID[k].equals(id)) { //�Է¹��� �й��̶� �´°� �ִٸ� ��й�ȣ �Է¹ޱ� 
               System.out.print("��й�ȣ�� �Է����ּ��� : ");
               password = q.next();
               
               //��й�ȣ�� ��Ȯ�ϴ�!! ��û�����ϱ�.
               if(password.equals(PASS[k])) {
                  while(true) {
                     System.out.printf("�����й����� ��û�� �����Ͻðڽ��ϱ�?(Y/N)\n�й� : %s \n--> ",ID[k]);
                     say = q.next();
                     
                     if(say.equals("Y")) {
                        apply_start(k); //��û����
                        
                        //chk_again�� 1�̶�� ��û�� �ùٸ��� �ѰŴϱ� �����ϱ�
                        if(chk_again==1) {
                           System.out.print("\n$��û�� �����մϴ�.\n");
                           chk_change[k]=1; //��û�����ϱ� �� �й��� �ش��ϴ� chk_change�� 1�� �ٲ�.
                           chk_id=1; //�´� �й��� �����Ƿ� chk_id�� 1�� �ٲٱ�.
                           break;
                        }
                        
                        //chk_again�� 0�̶�� ��û�� �ٽ��ϰ�����Ŵϱ� �ٽ� �����ϱ�
                        else if(chk_again==0) {
                           System.out.println("\n$�ٽ� ��û�� �����մϴ�.\n");
                        }
                     }
                     
                     else if(say.equals("N")) {
                        System.out.print("\n$��û�� �����մϴ�.\n");
                        chk_id=1; //chk_id�� 0�̸� �й� ���ٰ� �����ϱ� 1�� ������ֱ�.
                        break;
                     }
                     else {
                        System.out.println("Y�Ǵ� N���� �Է����ּ���.");
                     }
                  }
                  break;
               }
               //��й�ȣ �ȸ����� ����
               else if(!password.equals(PASS[k])) {
                  System.out.println("\n$��й�ȣ�� ��ġ���� �ʽ��ϴ�.\n");
                  chk_id=1; //chk_id�� 0�̸� �й� ���ٰ� �����ϱ� 1�� ������ֱ�.
               }
               else if(k==student_num-1) { //�̰� �� �־��ĸ� �ȳ����ϱ� �������� ���� �ڲ� �ȵȴ��ݾ�;;;
                  break;
               }
            }
         }
         //chk_id�� 0�̶�� �Է��� �й��� �������� �����Ƿ� ������ ���� ���.
         if(chk_id==0) {
         System.out.println("\n$�´� �й��� �������� �ʽ��ϴ�.\n");
         }
         else { //�ٽ� chk_id�� 0���� �ٲ��ֱ�.
            chk_id=0;
         }
      }   
   }
   
   //�������� ��û����
   public static void apply_start(int num) {
      String say;
      
      while(true) {
         while(true) {
            System.out.print("������ ��ðڽ��ϱ�?(Y/N) : ");
            say = q.next();
            
            //�ȸ����� ����Ʈ �޴°� �´�?? ��ư �׷��� ¥����.
            if(say.equals("Y")) { 
               breakfast[num]=1; //������ �й��� ���� ���Ĺ迭�� 1�� �ٲ��� ��ûȭ�� �����ٶ� Oǥ���ϰ� �Ϸ���.
               point[num]+=0;
               break;
            }
            else if(say.equals("N")) {
               breakfast[num]=0; //Ʋ���� �й��� ���� ���Ĺ迭�� 0���� �ٲ��� ��ûȭ�� �����ٶ� Xǥ���ϰ� �Ϸ���.
               point[num]+=100;
               break;
            }
            else {
               System.out.println("\n$����� 'Y'�Ǵ�'N'���θ� ���ּ���");
            }
         }
         //���� ���� ���
         while(true) {
            System.out.print("������ ��ðڽ��ϱ�?(Y/N) : ");
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
               System.out.println("\n$����� 'Y'�Ǵ�'N'���θ� ���ּ���\n");
            }
         }
         show_point(num); //��ûȭ�� �����ֱ�.
         System.out.print("�̴�� �����Ͻðڽ��ϱ�?(Y/N) : ");
         say=q.next();
         if(say.equals("Y")) {
            break;
         }
         else if(say.equals("N")) { //�̴�� ���� ���ϸ� �� �ʱ�ȭ ��Ű�� ��û �ٽ� �����ϱ�.
            System.out.println("\n$����,���� ���� �� ����Ʈ�� �ʱ�ȭ�մϴ�.");
            breakfast[num]=0;
            dinner[num]=0;
            point[num]=0;
            break;
         }
      }
      if(say.equals("N")) { //chk_again�� 0���� �ؼ� �ٽ� ��û�ϰ� �ϱ�
         chk_again = 0;
      }
      else if(say.equals("Y")){ //chk_again�� 1�� �ؼ� �ٷ� ����������.
         chk_again = 1;
      }
   }
   
   //��û�����ϱ�
   public static void change() {
      String id, password, say;
      int k;
      
      if(ID[0].equals("0")) { //�տ��� 0���� �ʱ�ȭ �����Ƿ� �� ù��°�� 0�̴�? -> �ƹ��͵� ��ϵǾ����� �ʴ�.
         System.out.println("\n$�л������� �������� �ʽ��ϴ�.\n");
      }
      
      else {
         System.out.print("�й��� �Է����ּ��� : ");
         id = q.next();
         for(k=0; k<student_num; k++) { 
            if(ID[k].equals(id)) {
               System.out.print("��й�ȣ�� �Է����ּ��� : ");
               password = q.next();
               if(chk_change[k]==0) { //�й��� �ش��ϴ� chk_change�� 0�̶�� ��û�� ���ϰ� �����Ϸ��ϴ°Ŵϱ� ����. 
                  System.out.println("\n$��û���� �ʾҴٸ� ���� �� �� �����ϴ�.\n");
                  chk_id=1;      //�̰� 1�� �ȹٲٸ� �ƽ���? �´� �й��� �������� �ʽ��ϴ�. <-- ��� ����
                  break;
               }
               
               else if(password.equals(PASS[k])) {
                  while(true) {
                     System.out.printf("�����й����� ��û������ �����Ͻðڽ��ϱ�?(Y/N)\n�й� : %s \n--> ",ID[k]);
                     say = q.next();
                     if(say.equals("Y")) {
                        point_change(k);//��û��������
                        if(chk_again==1) {
                           System.out.print("\n$��û�� �����մϴ�.\n");
                           chk_id=1;
                           break;
                        }
                        else if(chk_again==0) {
                           System.out.println("\n$�ٽ� ��û������ �����մϴ�.\n");
                        }
                     }
                     else if(say.equals("N")) {
                        System.out.print("\n$��û������ �����մϴ�.\n");
                        break;
                     }
                     else {
                        System.out.println("Y�Ǵ� N���� �Է����ּ���.");
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
         System.out.println("\n$�´� �й��� �������� �ʽ��ϴ�.\n");
         }
         else {
            chk_id=0;
         }
      }
   }
   
   //����Ʈ �����ֱ� �Լ�.
   public static void show_point(int num) {
      String yes = "O";
      String no = "X";
      System.out.printf("�й� : %s�� ��û��Ȳ�� ������ �����ϴ�.\n", ID[num]);
      System.out.println("===========================");
      if(breakfast[num]==1) { //1�̸� O 0�̸� X!!
         System.out.printf("���� : %s\n", yes);
      }
      else if(breakfast[num]==0) {
         System.out.printf("���� : %s\n", no);
      }
      if(dinner[num]==1) {
         System.out.printf("���� : %s\n", yes);
      }
      else if(dinner[num]==0) {
         System.out.printf("���� : %s\n", no);
      }
      System.out.println("---------");
      System.out.printf("�� ����Ʈ  = %d\n", point[num]);
      System.out.println("===========================");
   }
   
   // ��û���� ���������� �����ϱ�!!
   public static void point_change(int num) {
      String say;
      
      show_point(num);
      
      System.out.println("$��û������ �����մϴ�.\n");
      breakfast[num]=0;
      dinner[num]=0;
      point[num]=0;
      
      while(true) {
         while(true) {
            System.out.print("������ ��ðڽ��ϱ�?(Y/N) : ");
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
               System.out.println("\n$����� 'Y'�Ǵ�'N'���θ� ���ּ���");
            }
         }
         while(true) {
            System.out.print("������ ��ðڽ��ϱ�?(Y/N) : ");
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
               System.out.println("\n$����� 'Y'�Ǵ�'N'���θ� ���ּ���\n");
            }
         }
         System.out.print("�̴�� �����Ͻðڽ��ϱ�?(Y/N) : ");
         say=q.next();
         if(say.equals("Y")) {
            break;
         }
         else if(say.equals("N")) {
            System.out.println("\n$����,���� ���� �� ����Ʈ�� �ʱ�ȭ�մϴ�.");
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