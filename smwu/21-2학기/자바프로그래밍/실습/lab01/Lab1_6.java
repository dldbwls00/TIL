// ������ (2016133)
// 2021-09-10
// Lab01 - �ǽ� 4. 369����
import java.util.Scanner;

public class Lab1_6 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("1~99 ������ ������ �Է��Ͻÿ�>>");
		int num = scanner.nextInt(); //���� �Է¹ޱ� 
		
		int ten = num / 10; //���� �ڸ� ���� ����
		int one = num % 10; //���� �ڸ� ���� ����
		
		System.out.print("�ڼ�");
		if (ten==3 || ten==6 || ten==9)	System.out.print("¦"); //���� �ڸ��� 3,6,9�� ���
		if (one==3 || one==6 || one==9)	System.out.print("¦"); //���� �ڸ��� 3,6,9�� ���
		if (ten!=3 && ten!=6 && ten!=9 && one!=3 && one!=6 && one!=9) System.out.println("����"); //3,6,9�� �� ���� ���� ���
	}

}
