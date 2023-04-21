// 이유진 (2016133)
// 2021-10-08
// Lab05 - 실습 1. 원
public class Circle {
	int x, y, radius;
	
	public Circle(int x, int y, int radius) {
		this.x = x;
		this.y = y;
		this.radius = radius;
	}

	public boolean equals(Object o) { //중심이 같으면 같은 것으로 판별하도록 재정의
		Circle c = (Circle)o;
		if (x==c.x && y==c.y)	return true;
		else return false;
	}

	@Override
	public String toString() { //재정의
		return "Circle(" + x + "," + y + ")반지름" + radius;
	}
	
}
