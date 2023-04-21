// 이유진 (2016133)
// 2021-10-01
// Lab04 - 실습 6. 쇼핑
package prob6;

public class Food extends Item{ //Item 클래스의 하위 클래스
	
	public Food(String name, int price) { //이름, 가격을 매개변수로 받아서 생성자 작성
		super(name, price);
	}

	@Override
	public String toString() { //toString 메소드 재정의
		return "[Food]"+super.getName();
	}
	
}
