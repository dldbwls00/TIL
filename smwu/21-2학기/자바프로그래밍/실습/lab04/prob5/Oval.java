// ������ (2016133)
// 2021-10-01
// Lab04 - �ǽ� 5. �߻� Ŭ���� �ǽ� - ������ ����
package prob5;

public class Oval implements Shape2{
	private int a, b;
	
	public Oval(int a, int b) {
		this.a = a;
		this.b = b;
	}
	
	@Override
	public void draw() {
		System.out.println("�ʺ�: "+a+", ����: "+b+"�� �����ϴ� Ÿ���Դϴ�.");
	}

	@Override
	public double getArea() {
		return PI*a*b/4;
	}

}
