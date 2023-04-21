// ������ (2016133)
// 2021-09-24
// Lab03 - �ǽ� 3. ���� ���� ���
import java.util.Scanner;

class Circle {
	private double x, y;
	private int radius;
	
	public Circle(double x, double y, int radius) {//x, y, radius �ʱ�ȭ
		this.x = x;
		this.y = y;
		this.radius = radius;
	}
	public void show() {//ȭ�鿡 ���: (x, y) radius ��������
		System.out.println("(" + (double)x + ", " + (double)y + ") " + radius);
	}
	public double getArea() { //���� ����Ͽ� ��ȯ, ���̰��� MathŬ������ PI ��� Ȱ�� > Math.PI
		return Math.PI * radius * radius;
	}
}
public class CircleManager {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); //�Է��� ���� Scanner ��ü ����
		
		Circle [] c = new Circle[3]; //Circle ��ü �迭 ����
		
		
		for (int i=0; i<c.length; i++) { //�迭�� �ݺ����� Ȱ���Ͽ� ����ڷκ��� x, y, radius �Է¹޾Ƽ� Circle ��ü ����
			System.out.print("x, y, radius >>");
			int x = scanner.nextInt();
			int y = scanner.nextInt();
			int radius = scanner.nextInt();
			c[i] = new Circle(x, y, radius);
		}
		
		System.out.println("[��ü Circle ���]");
		
		for (int i=0; i<c.length; i++)	c[i].show(); //show() �Լ��� �̿��ؼ� ��� Circle ��ü ���
			
		int biggestIndex = 0;
		for (int i=0; i<c.length; i++) {//�����Լ��� ���� ���ؼ� ���� ū ������ ���� index�� biggestIndex�� ����
			if (c[biggestIndex].getArea() < c[i].getArea())	biggestIndex = i;
		}
		
		System.out.print("���� ������ ū ���� ");
		c[biggestIndex].show();
		scanner.close();
	}

}
