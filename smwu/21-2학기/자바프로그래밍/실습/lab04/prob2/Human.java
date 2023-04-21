// 이유진 (2016133)
// 2021-10-01
// Lab04 - 실습 2. 학생 만들기
package prob2;

public class Human {
	private String name;
	private int age;
	
	public Human(String name, int age) {//매개변수의 값으로 필드를 초기화
		this.name = name;
		this.age = age;
	}
	
	//각 필드(이름, 나이)에 대하여 접근자와 변경자 메소드를 작성
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
	public String toString() { //객체의 현재 값들을 문자열로 반환
		return "이름: "+name+", 나이: "+age;
	}
	
	
}
