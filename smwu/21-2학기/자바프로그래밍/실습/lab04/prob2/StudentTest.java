// 이유진 (2016133)
// 2021-10-01
// Lab04 - 실습 2. 학생 만들기
package prob2;

import java.util.Scanner;

public class StudentTest {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		//크기 3의 Human 객체와 Student 객체 배열 생성
		Human [] human = new Human[3];
		Student [] student = new Student[3];
		
		//사용자로부터 이름과 나이를 입력받아서 3명의 Human 객체를 생성
		for (int i=1; i<=3; i++) {
			System.out.print("["+i+"] Human 입력:");
			String name = scanner.next();
			int age = scanner.nextInt();
			human[i-1] = new Human(name, age); //배열 원소 객체 생성
		}
		
		//사용자로부터 이름, 나이, 전공, 학번을 입력받아서 3명의 Student 객체 생성
		for (int i=1; i<=3; i++) {
			System.out.print("["+i+"] Student 입력:");
			String name = scanner.next();
			int age = scanner.nextInt();
			String major = scanner.next();
			int sID = scanner.nextInt();
			student[i-1] = new Student(name, age, major, sID); //배열 원소 객체 생성
		}
		
		//각 객체참조변수 이름으로 출력문 작성
		for (int i=0; i<human.length; i++)	System.out.println(human[i]);
		for (int i=0; i<student.length; i++)System.out.println(student[i]);
		
		scanner.close();
	}

}
