// ������ (2016133)
// 2021-10-08
// Lab05 - �ǽ� 1. ��
public class Circle {
	int x, y, radius;
	
	public Circle(int x, int y, int radius) {
		this.x = x;
		this.y = y;
		this.radius = radius;
	}

	public boolean equals(Object o) { //�߽��� ������ ���� ������ �Ǻ��ϵ��� ������
		Circle c = (Circle)o;
		if (x==c.x && y==c.y)	return true;
		else return false;
	}

	@Override
	public String toString() { //������
		return "Circle(" + x + "," + y + ")������" + radius;
	}
	
}
