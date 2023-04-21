// 이유진 (2016133)
// 2021-09-24
// Lab03 - 실습 3. 원의 정보 출력
import java.util.Scanner;

class Circle {
	private double x, y;
	private int radius;
	
	public Circle(double x, double y, int radius) {//x, y, radius 초기화
		this.x = x;
		this.y = y;
		this.radius = radius;
	}
	public void show() {//화면에 출력: (x, y) radius 형식으로
		System.out.println("(" + (double)x + ", " + (double)y + ") " + radius);
	}
	public double getArea() { //면적 계산하여 반환, 파이값은 Math클래스의 PI 상수 활용 > Math.PI
		return Math.PI * radius * radius;
	}
}
public class CircleManager {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); //입력을 위한 Scanner 객체 생성
		
		Circle [] c = new Circle[3]; //Circle 객체 배열 생성
		
		
		for (int i=0; i<c.length; i++) { //배열과 반복문을 활용하여 사용자로부터 x, y, radius 입력받아서 Circle 객체 생성
			System.out.print("x, y, radius >>");
			int x = scanner.nextInt();
			int y = scanner.nextInt();
			int radius = scanner.nextInt();
			c[i] = new Circle(x, y, radius);
		}
		
		System.out.println("[전체 Circle 출력]");
		
		for (int i=0; i<c.length; i++)	c[i].show(); //show() 함수를 이용해서 모든 Circle 객체 출력
			
		int biggestIndex = 0;
		for (int i=0; i<c.length; i++) {//면적함수를 통해 비교해서 가장 큰 면적을 가진 index를 biggestIndex에 저장
			if (c[biggestIndex].getArea() < c[i].getArea())	biggestIndex = i;
		}
		
		System.out.print("가장 면적이 큰 원은 ");
		c[biggestIndex].show();
		scanner.close();
	}

}
