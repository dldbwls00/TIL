// ������ (2016133)
// 2021-09-17
// Lab02 - �ǽ� 3. ���� �׼��� �Է¹޾� ȯ���ϱ�
import java.util.Scanner;

public class ChangeMoney {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("�ݾ��� �Է��Ͻÿ�>>");
		int n = scanner.nextInt(); //���� �ݾ� �Է¹ޱ�
		
		int [] unit = {50000, 10000, 1000, 500, 100, 50, 10, 1}; //ȯ���� ���� ������ ���� �迭
		
		for (int i=0; i<unit.length; i++) {
			if (n/unit[i] > 0) { //�ݾ��� �ش� ������ ȯ���� �� �ִ� ��� -> ���� ������
				System.out.println(unit[i]+"�� ¥�� : " + n/unit[i] + "��");
				n %= unit[i]; //�ݾ��� �ش� ������ ȯ���ϸ� �������� ����
			}
		}
		scanner.close();
	}

}
