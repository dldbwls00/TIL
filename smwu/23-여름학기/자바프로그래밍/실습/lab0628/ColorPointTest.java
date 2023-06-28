//이유진 (2016133)
//2023-06-28
//Lab0628-3: Point 클래스를 상속받는 ColorPoint 클래스를 이용해 색깔있는 점의 정보를 출력함

class Point {
	private int x, y;

	// 생성자
	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	// 설정자, 접근자
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setXY(int x, int y) { // x, y의 set 메서드를 한 번에 작성
		this.x = y;
		this.y = y;
	}
}

class ColorPoint extends Point {
	private String color;

	public ColorPoint(int x, int y, String color) {
		super(x, y);
		this.color = color;
	}

	// 위치 설정 메서드는 부모 클래스에게 받아 사용함
	// 색깔 설정 메서드
	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return color + "색의 (" + super.getX() + ", " + super.getY() + ")의 점";
	}

}

public class ColorPointTest {

	public static void main(String[] args) {

		ColorPoint cp = new ColorPoint(5, 5, "YELLOW");
		cp.setXY(10, 20);
		cp.setColor("RED");
		System.out.println(cp.toString() + "입니다.");
	}

}
