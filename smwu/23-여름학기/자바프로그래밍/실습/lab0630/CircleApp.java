//이유진 (2016133)
//2023-07-02
//Lab0630-1: Object의 toString, equals 재정의: Circle 객체 판별

class Circle {
	private int x, y, radius;

	//생성자: 세 개의 필드로 초기화
	public Circle(int x, int y, int radius) {
		super();
		this.x = x;
		this.y = y;
		this.radius = radius;
	}

	//접근자, 설정자
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	//Object의 toString 재정의
	@Override
	public String toString() {
		return "Circle(" + x + "," + y + ") 반지름" + radius;
	}
	
	//Object의 equals 재정의
	public boolean equals(Circle c) { //중심이 같으면 같은 것으로 판별
		if (this.getX() == c.getX() && this.getY() == c.getY()) //정수값 ==비교
			return true;
		else
			return false;
	}
}

public class CircleApp {

	public static void main(String[] args) {
		Circle a = new Circle(2, 3, 5); // 중심 (2, 3)에 반지름 5인 원
		Circle b = new Circle(2, 3, 30); // 중심 (2, 3)에 반지름 30인 원
		System.out.println("원 a: " + a);
		System.out.println("원 b: " + b);
		if (a.equals(b))
			System.out.println("같은 원");
		else
			System.out.println("서로 다른 원");
	}

}
