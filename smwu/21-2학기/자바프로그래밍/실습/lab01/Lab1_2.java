// ������ (2016133)
// 2021-09-10
// Lab01 - �ǽ� 2. �� �ڸ� ���� �Է¹ް�, ���� �ڸ��� ���� �ڸ��� ������ �Ǻ��ϱ�
import java.util.Scanner;

public class Lab1_2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("2�ڸ��� ���� �Է�(10~99)>>");
		
		int num = scanner.nextInt(); //���� �Է¹ޱ�
		
		int ten = num / 10; //���� �ڸ� ���� ����
		int one = num % 10; //���� �ڸ� ���� ����
		
		// ���� �ڸ��� ���� �ڸ��� ������ �ٸ��� �Ǻ��ϴ� if-else��
		if (ten == one)	System.out.println("Yes! 10�� �ڸ��� 1�� �ڸ��� �����ϴ�");  //���� ���
		else System.out.println("No! 10�� �ڸ��� 1�� �ڸ��� �ٸ��ϴ�"); //�ٸ� ���
	}

}
