// ������ (2016133)
// 2021-10-01
// Lab04 - �ǽ� 5. �߻� Ŭ���� �ǽ� - ������ ����
package prob5;

public class Rect implements Shape2{
	private int a, b;
	
	public Rect(int a, int b) {
		this.a = a;
		this.b = b;
	}
	
	@Override
	public void draw() {
		System.out.println("�ʺ�: "+a+", ����: "+b+"�� �簢���Դϴ�.");
	}

	@Override
	public double getArea() {
		return a*b;
	}

}
