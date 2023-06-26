//이유진 (2016133)
//2023-06-26
//Lab0626-4: Student 클래스를 이용해 학생 정보를 입력받고 출력함

import java.util.Scanner;

class Student {

	// 필드 선언
	private String name;
	private String studentID;
	private int age;

	// 생성자 정의
	public Student(String name, String studentID, int age) {
		super();
		this.name = name;
		this.studentID = studentID;
		this.age = age;
	}

	// 각 필드에 대한 접근자, 생성자 메소드 작성
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStudentID() {
		return studentID;
	}

	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	// toString 메소드 작성
	@Override
	public String toString() {
		return "Student [이름=" + name + ", 학번=" + studentID + ", 나이=" + age + "]";
	}

}

public class StudentTest {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("학생의 이름: ");
		String name = sc.next();
		System.out.print("학생의 학번: ");
		String id = sc.next();
		System.out.print("학생의 나이: ");
		int age = sc.nextInt();

		Student s1 = new Student(name, id, age); //Student 객체 선언 후 생성
		System.out.println(s1);

		sc.close();
	}

}
