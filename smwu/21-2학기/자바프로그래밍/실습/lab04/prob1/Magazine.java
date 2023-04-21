// 이유진 (2016133)
// 2021-10-01
// Lab04 - 실습 1. Magazine 만들기
package prob1;

public class Magazine extends Book1{ //Book1에 대한 하위클래스
	private String date; //추가 속성: 발매일

	public Magazine(String title, int pages, String author, int count, String date) { //생성자
		super(title, pages, author, count); //생성자 내에서 부모 생성자 호출
		this.date = date;
	}

	//각 필드에 대하여 접근자 메소드와 설정자 메소드를 작성
	public String getDate() { //접근자
		return date;
	}

	public void setDate(String date) { //설정자
		this.date = date;
	}
}
