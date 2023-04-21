// 이유진 (2016133)
// 2021-10-01
// Lab04 - 실습 6. 쇼핑
package prob6;

public class Book extends Item{ //Item 클래스의 하위 클래스
	private String author; //속성: 저자
	
	public Book(String name, int price, String author) {//이름, 가격, 저자를 매개변수로 받아 생성자 작성
		super(name, price);
		this.author = author;
	}

	@Override
	public String toString() { //toString 메소드 재정의
		return "[Book]"+super.getName()+", 저자: "+author;
	}
	
}
