// ������ (2016133)
// 2021-09-10
// Lab01 - �ǽ� 6. �� ���� ���� ��ġ���� �Ǵ�
import java.util.Scanner;

public class Lab1_10 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		//���� ��� ���� (x1, y1), ������ �ϴ� ���� (x2, y2)�̵��� �Է¹���
		System.out.print("���� �߽� x1, y1, ������ radius1 >> ");
		int x1 = scanner.nextInt();
		int y1 = scanner.nextInt();
		int radius1 = scanner.nextInt();
		System.out.print("���� �߽� x2, y2, ������ radius2 >> ");
		int x2 = scanner.nextInt();
		int y2 = scanner.nextInt();
		int radius2 = scanner.nextInt();
		
		//��ǥ��� ���� �� �� ���� �Ÿ� ���ϴ� ����
		double distance = Math.sqrt(Math.pow((x2-x1),  2)+Math.pow(y2-y1, 2));
		
		// �� ���� ��ġ���� �Ǵ��ϴ� if-else�� (���ϴ� ��쵵 ��ġ�� ��쿡 ����)
		// �� �������� ���� �� ���� �߽� ���� �Ÿ����� Ŭ �� ��ġ�� �ʴ´�
		if (distance > radius1+radius2)	System.out.println("�� ���� ���� ��ġ�� �ʴ´�."); //��ġ�� �ʴ� ���
		else	System.out.println("�� ���� ���� ��ģ��."); //��ġ�� ���
	}

}
