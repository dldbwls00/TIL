// ������ (2016133)
// 2021-10-01
// Lab04 - �ǽ� 5. �߻� Ŭ���� �ǽ� - ������ ����
package prob5;

public class Circle implements Shape2{
	private int r;
	
	public Circle(int r) {
		this.r = r;
	}
	@Override
	public void draw() {//������ �׸��� �޼���
		System.out.println("�������� "+r+"�� ���Դϴ�.");
	}

	@Override
	public double getArea() {//������ ������ �����ϴ� �޼���
		return PI*r*r;
	} 
		
}
