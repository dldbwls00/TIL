// ������ (2016133)
// 2021-09-10
// Lab01 - �ǽ� 3. ���� 3�� �Է¹ް� �߰� ũ�� �� ����ϱ�
import java.util.Scanner;

public class Lab1_4 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("���� 3�� �Է�>>");
		
		//�� ���� ���� �Է¹ޱ�
		int n1 = scanner.nextInt();
		int n2 = scanner.nextInt();
		int n3 = scanner.nextInt();
		
		int mid;
		
		//��ø if-else������ �߰����� ã�� ���� mid�� ��´�
		if (n1 > n2) {
			if (n2 > n3)	mid = n2; //n1 > n2 > n3�� ���
			else {
				if (n1 > n3)	mid = n3; //n1 > n3 > n2�� ���
				else	mid = n1; //n3 > n1 > n2�� ���
			}
		}
		else {
			if (n1 > n3)	mid = n1; //n2 > n1 > n3�� ���
			else {
				if (n2 > n3)	mid = n3; //n2 > n3 > n1�� ���
				else	mid = n2; //n3 > n2 > n1�� ���
			}
		}

		System.out.println("�߰� ���� " + mid); //��� ���
	}
}
