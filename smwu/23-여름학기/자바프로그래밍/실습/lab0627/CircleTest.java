//이유진 (2016133)
//2023-06-27
//Lab0627-3: Circle 클래스를 이용해 객체 배열 활용 실습: 0~100사이의 반지름을 갖는 원 객체 3개를 담은 객체배열 구현

class Circle {
	int radius;

	// 생성자
	public Circle(int radius) {
		super();
		this.radius = radius;
	}

	@Override
	public String toString() {
		return "Circle [radius=" + radius + "]";
	}

}

public class CircleTest {

	public static void main(String[] args) {

		// 크기가 3인 Circle 객체 배열 생성
		Circle[] circle = new Circle[3];

		// Circle 객체 3개 생성해 배열에 저장
		for (int i=0; i<circle.length; i++) {
			// [0,100] 범위의 난수: 100을 포함하게 하기 위해 101로 mod 연산
			int radius = (int) (Math.random() * 1000) % 101;
			circle[i] = new Circle(radius); // 객체를 배열에 저장
		}

		// 저장된 객체를 꺼내서 화면에 출력
		for (Circle i : circle) {
			System.out.println(i);
		}

	}

}
