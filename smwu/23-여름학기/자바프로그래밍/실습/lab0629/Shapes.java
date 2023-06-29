//이유진 (2016133)
//2023-06-29
//Lab0629-1: 도형의 구성을 묘사하는 인터페이스를 이용해 도형을 그리는 프로그램

interface Shape {
	final double PI = 3.14;

	void draw(); // 도형을 그리는 추상 메서드

	double getArea(); // 도형의 면적을 리턴하는 추상 메서드

	default public void redraw() { // 디폴트 메서드
		System.out.print("--- 다시 그립니다. ");
		draw();
	}
}

class Circle implements Shape {
	private int radius;

	public Circle(int radius) { // 생성자
		super();
		this.radius = radius;
	}

	@Override
	public void draw() {
		System.out.println("반지름이 " + radius + "인 원입니다.");
	}

	@Override
	public double getArea() { // 면적
		return radius * radius * PI;
	}

}

class Oval implements Shape {
	private int x, y; // 가로 x, 세로 y인 직사각형에 내접하는 타원

	public Oval(int x, int y) { // 생성자
		super();
		this.x = x;
		this.y = y;
	}

	@Override
	public void draw() {
		System.out.println("너비: " + x + ", 높이: " + y + "에 내접하는 타원입니다.");
	}

	@Override
	public double getArea() { // 면적
		return x * y / 4 * PI; // 타원의 넓이 공식: pi*반지름1*반지름2
	}

}

class Rect implements Shape {

	private int x, y;

	public Rect(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	@Override
	public void draw() {
		System.out.println("너비: " + x + ", 높이: " + y + "의 사각형입니다.");
	}

	@Override
	public double getArea() {
		return x * y;
	}

}

public class Shapes {
	public static void main(String[] args) {
		Shape[] list = new Shape[3]; // Shape을 상속받은 클래스

		// 객체의 레퍼런스 개별
		list[0] = new Circle(10); // 반지름이 10인 원 객체
		list[1] = new Oval(20, 30); // 20x30 사각형에 내접하는 타원
		list[2] = new Rect(10, 40); // 10x40 크기의 사각형

		for (int i = 0; i < list.length; i++)
			list[i].redraw();
		for (int i = 0; i < list.length; i++)
			System.out.println("면적은 " + list[i].getArea());
	}

}
