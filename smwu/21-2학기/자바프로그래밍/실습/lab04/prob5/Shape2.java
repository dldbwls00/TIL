// ������ (2016133)
// 2021-10-01
// Lab04 - �ǽ� 5. �߻� Ŭ���� �ǽ� - ������ ����
package prob5;

interface Shape2 {
	final double PI = 3.14;
	void draw(); //������ �׸��� �߻�޼���
	double getArea(); //������ ������ �����ϴ� �߻�޼���
	default public void redraw() { //����Ʈ �޼���
		System.out.print("--- �ٽ� �׸��ϴ�. ");
		draw();
	}
}
