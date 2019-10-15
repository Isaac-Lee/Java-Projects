package 과제;
import java.util.*;

public class GradeToScore {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		ArrayList<String> gradeList = new ArrayList<String>();
		double[] gradeScore = {4.0, 3.0, 2.0, 1.0, 0.0};
		String[] grades = {"A" , "B" , "C" , "D" , "F"};
		
		while (true) {
			System.out.print("학점을 입력하세요(A, B, C, D, F): ");
			String grade = input.nextLine().toUpperCase();
			if (grade.equals("A") || grade.equals("B") || grade.equals("C") || grade.equals("D") || grade.equals("F")) {
				gradeList.add(grade);
				continue;
			}
			else if (grade.equals("")) {
				break;
			}
			else {
				System.out.println("잘못된 학점 입력입니다.");
				
				continue;
			}
		}
		
		System.out.println("---------------------------------------------");
		
		for (String grd : gradeList) {
			int index = 0;
			for (int i =0; i < grades.length; i++) {
			    if (grades[i].equals(grd)) {
			        index = i;
			        break;
			    }
			}
			System.out.println("저장된 학점: " + grd + " 변환한 점수: "+ gradeScore[index]);
		}
	}

}
