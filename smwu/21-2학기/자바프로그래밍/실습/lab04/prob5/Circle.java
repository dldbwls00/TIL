// 이유진 (2016133)
// 2021-10-01
// Lab04 - 실습 5. 추상 클래스 실습 - 도형의 면적
package prob5;

public class Circle implements Shape2{
	private int r;
	
	public Circle(int r) {
		this.r = r;
	}
	@Override
	public void draw() {//도형을 그리는 메서드
		System.out.println("반지름이 "+r+"인 원입니다.");
	}

	@Override
	public double getArea() {//도형의 면적을 리턴하는 메서드
		return PI*r*r;
	} 
		
}
