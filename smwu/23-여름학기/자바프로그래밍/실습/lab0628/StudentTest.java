//이유진 (2016133)
//2023-06-28
//Lab0628-4: Human 클래스와 Human 클래스를 상속받는 Student 클래스로 
//			사람과 학생의 정보를 객체배열에 저장 후 출력함

import java.util.Scanner;

class Human {
	// 속성
	private String name;
	private int age;

	// 생성자: 매개변수로 이름, 나이를 받아와서 멤버 변수 값 초기화
	public Human(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	// 접근자, 변경자
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() { // 객체의 현재 값들을 문자열로 반환
		return "이름: " + name + ", 나이: " + age;
	}

}

class Student extends Human {
	// 추가 속성 정의
	private String major;
	private int sID;

	// 생성자
	public Student(String name, int age, String major, int sID) {
		super(name, age); // 부모 클래스의 생성자 호출

		// 매개변수로 받아온 값으로 멤버 변수의 전공과 학번을 초기화
		this.major = major;
		this.sID = sID;
	}

	// 필드(전공)에 대한 접근자, 설정자
	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public int getsID() {
		return sID;
	}

	public void setsID(int sID) {
		this.sID = sID;
	}

	@Override
	public String toString() { // 부모의 toString()을 호출해 받아온 문자열 값에 추가로 전공값 연결
		return "[학생 정보]" + super.toString() + ", 전공: " + major + ", 학번: " + sID;
	}

}

public class StudentTest {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		// 크기 3의 Human 객체와 Student 객체 배열 생성
		Human[] human = new Human[3];
		Student[] student = new Student[3];

		// 사용자로부터 이름과 나이를 입력받아서 3명의 Human 객체를 생성
		for (int i = 0; i < human.length; i++) {
			System.out.print("[" + i + "] Human 입력: ");
			String name = scan.next();
			int age = scan.nextInt();

			human[i] = new Human(name, age);
		}

		// 사용자로부터 이름, 나이, 전공, 학번을 입력받아서 3명의 Student 객체 생성
		for (int i = 0; i < student.length; i++) {
			System.out.print("[" + i + "] Student 입력: ");
			String name = scan.next();
			int age = scan.nextInt();
			String major = scan.next();
			int sID = scan.nextInt();
			student[i] = new Student(name, age, major, sID);
		}

		// 각 객체 참조변수 이름으로 출력문 작성
		for (int i = 0; i < human.length; i++)
			System.out.println(human[i]);
		for (int i = 0; i < student.length; i++)
			System.out.println(student[i]);
		scan.close();
	}

}
