// ������ (2016133)
// 2021-09-10
// Lab01 - �ǽ� 5. ���簢�� �浹 �Ǻ� ���α׷�
import java.util.Scanner;

public class Lab1_8 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		//���� ��� ���� (x1, y1), ������ �ϴ� ���� (x2, y2)�̵��� �Է¹���
		System.out.print("x1, y1 �Է�>>");
		int x1 = scanner.nextInt();
		int y1 = scanner.nextInt();
		System.out.print("x2, y2 �Է�>>");
		int x2 = scanner.nextInt();
		int y2 = scanner.nextInt();
		
		//��ġ���� ���θ� �Ǻ��ϴ� if-else��
		if (x1>200 || y1>200 || x2<100 || y2<100)	System.out.println("�浹 ����"); //��ġ�� �ʴ� ���
		else	System.out.println("�浹 �߻�"); //��ġ�� ��� 
		
	}
}
