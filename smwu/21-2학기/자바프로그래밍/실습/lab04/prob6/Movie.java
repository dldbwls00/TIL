// 이유진 (2016133)
// 2021-10-01
// Lab04 - 실습 6. 쇼핑
package prob6;

public class Movie extends Item{ //Item 클래스의 하위 클래스
	private String director; //속성: 감독
	
	public Movie(String name, int price, String director) { //이름, 가격, 감독을 매개변수로 받아서 생성자 작성
		super(name, price);
		this.director = director;
	}

	@Override
	public String toString() { //toString 메소드 재정의
		return "[Movie]"+super.getName()+", 감독: "+director;
	}
	
}
