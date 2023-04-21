// 이유진 (2016133)
// 2021-10-01
// Lab04 - 실습 5. 추상 클래스 실습 - 도형의 면적
package prob5;

public class Oval implements Shape2{
	private int a, b;
	
	public Oval(int a, int b) {
		this.a = a;
		this.b = b;
	}
	
	@Override
	public void draw() {
		System.out.println("너비: "+a+", 높이: "+b+"에 내접하는 타원입니다.");
	}

	@Override
	public double getArea() {
		return PI*a*b/4;
	}

}
