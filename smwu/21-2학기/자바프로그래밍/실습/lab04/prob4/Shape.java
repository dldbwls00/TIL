// ������ (2016133)
// 2021-10-01
// Lab04 - �ǽ� 4. �߻� Ŭ���� �ǽ� : �׷��� ������
package prob4;

public abstract class Shape {
	private Shape next;
	public Shape() {
		next = null;
	}
	
	public void setNext(Shape obj) { //��ũ ����
		next = obj;
	}
	
	public Shape getNext() {
		return next;
	}
	
	public abstract void draw();
}
