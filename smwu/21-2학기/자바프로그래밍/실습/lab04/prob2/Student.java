// 이유진 (2016133)
// 2021-10-01
// Lab04 - 실습 2. 학생 만들기
package prob2;

public class Student extends Human{ //Human 클래스를 상속
	private String major; //추가 속성: 전공
	private int sID; //추가 속성: 학번
	
	public Student(String name, int age, String major, int sID) { //생성자
		//매개변수로 이름, 나이, 전공, 학번을 받아와서 초기화
		super(name, age); //부모 클래스의 생성자 호출 (이름, 나이)
		this.major = major; //매개변수로 받아온 값으로 멤버 변수의 전공과 학번을 초기화
		this.sID = sID;
	}
	
	//필드(전공)에 대하여 접근자와 변경자 메소드를 작성
	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	@Override
	public String toString() {
		//부모의 toString()을 호출하여 받아온 문자열 값에 추가로 전공 값 연결하여 문자열 반환
		return "[학생 정보]이름: "+super.getName()+", 나이: "+super.getAge()+", 전공: "+major+", 학번: "+sID+"]";
	}
}
