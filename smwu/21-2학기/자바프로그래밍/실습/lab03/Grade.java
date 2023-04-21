// 이유진 (2016133)
// 2021-09-24
// Lab03 - 실습 1. Grade 클래스 작성 : 세 과목의 평균 구하기
import java.util.Scanner;

public class Grade {
	int math, science, english; //멤버 변수 선언
	
	public Grade(int math, int science, int english) {//생성자 작성 (수학, 과학, 영어 점수를 위한 매개 변수 3개 받아서 멤버 변수에 저장)
		this.math = math;
		this.science = science;
		this.english = english;
	}
	
	public int average() {// 세 과목의 평균을 리턴하는 average() 메소드 작성
		return (math + science + english)/3;
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); //스캐너 객체
		
		System.out.print("수학, 과학, 영어 순으로 3개의 점수 입력>>");
		int math = scanner.nextInt(); //입력받기
		int science = scanner.nextInt();
		int english = scanner.nextInt();
		
		Grade me = new Grade(math, science, english); //객체 생성
		
		System.out.println("평균은 " + me.average()); //결과 출력
		
		scanner.close();
	}

}
