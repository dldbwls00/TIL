// 이유진 (2016133)
// 2021-09-17
// Lab02 - 실습 6. 과목 이름과 점수 출력하기
import java.util.Scanner;

public class ScoreArray {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		//과목과 점수가 짝을 이루는 두 개의 배열
		String course[] = {"Java", "C++", "HTML5", "컴퓨터구조", "안드로이드"};
		int score[] = {95, 88, 76, 62, 55};
		
		while(true) {
			System.out.print("과목 이름>>");
			String name = scanner.next(); //과목 이름 입력 받기
			
			if (name.equals("그만")) break; //"그만"을 입력받는 경우 종료
			
			for (int i=0; i<course.length; i++) {
				if (course[i].equals(name)) {//일치하는 과목 이름이 있는 경우
					System.out.println(name+"의 점수는 "+score[i]); //점수 출력
					break;
				}
				if (i==course.length-1) { //배열 끝까지 돌았는데 일치하는 과목 이름이 없는 경우
					System.out.println("없는 과목입니다.");
					break;
				}
			}
			
		}
		scanner.close();
	}

}
