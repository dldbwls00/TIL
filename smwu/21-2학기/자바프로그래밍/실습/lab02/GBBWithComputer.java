// ������ (2016133)
// 2021-09-17
// Lab02 - �ǽ� 7. ��ǻ�Ϳ� ����������
import java.util.Scanner;

public class GBBWithComputer {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String str[] = {"����", "����", "��"};
		
		System.out.println("��ǻ�Ϳ� ���� ���� �� ������ �մϴ�.");
		while(true) {
			System.out.print("���� ���� ��!>>");
			String input = scanner.next(); //������� ���� �Է¹ޱ�
			
			if (input.equals("�׸�")) { //"�׸�"�� �Է��� ��� ���� ����
				System.out.println("������ �����մϴ�...");
				break;
			}
			
			int n = (int)(Math.random()*3); //0, 1, 2�߿� �����ϰ� ����
			System.out.print("����� = "+input+" , ��ǻ�� = "+str[n]+", ");
			
			if (str[n].equals("����")) {
				if (input.equals("����"))			System.out.println("�����ϴ�.");
				else if (input.equals("����"))	System.out.println("����ڰ� �̰���ϴ�.");
				else							System.out.println("��ǻ�Ͱ� �̰���ϴ�.");
			}
			else if (str[n].equals("����")) {
				if (input.equals("����"))			System.out.println("��ǻ�Ͱ� �̰���ϴ�.");
				else if (input.equals("����"))	System.out.println("�����ϴ�.");
				else							System.out.println("����ڰ� �̰���ϴ�.");
			}
			else {
				if (input.equals("����"))			System.out.println("����ڰ� �̰���ϴ�.");
				else if (input.equals("����"))	System.out.println("��ǻ�Ͱ� �̰���ϴ�.");
				else							System.out.println("�����ϴ�.");
			}
			
		}
		scanner.close();
	}

}
