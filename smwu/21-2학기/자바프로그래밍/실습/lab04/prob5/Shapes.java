// ������ (2016133)
// 2021-10-01
// Lab04 - �ǽ� 5. �߻� Ŭ���� �ǽ� - ������ ����
package prob5;

public class Shapes {

	public static void main(String[] args) {
		Shape2 [] list = new Shape2[3]; //Shape�� ��ӹ��� Ŭ���� ��ü�� ���۷��� �迭
		
		list[0] = new Circle(10); //�������� 10�� �� ��ü
		list[1] = new Oval(20, 30); //20x30 �簢���� �����ϴ� Ÿ��
		list[2] = new Rect(10, 40); //10x40 ũ���� �簢�� 
		
		for (int i=0; i<list.length; i++)
			list[i].redraw();
		for (int i=0; i<list.length; i++)
			System.out.println("������ "+list[i].getArea());
	}

}
