// ������ (2016133)
// 2021-10-22
// Lab07 - �ǽ� 1. ����ó ���� ���� �� ���
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class PhoneSave {

	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in); //��ĳ�� ��ü
		FileWriter fout = null; //Ű���� �Է��� ���Ϸ� �����ϱ� ����
		System.out.println("��ȭ��ȣ �Է� ���α׷��Դϴ�.");

		fout = new FileWriter("c:\\temp\\phone.txt"); // fout�� ��ġ�� �Բ� ���� ����
		while(true) {
			System.out.print("�̸� ��ȭ��ȣ >> ");
			String in = scanner.nextLine();
			
			if (in.equals("�׸�"))	break;
			if (in.length() == 0)	break; //�Է��� ���� ��� -> �ٹٲ�
			fout.write(in, 0, in.length()); //���ڵ鸸 �����
			fout.write("\r\n", 0, 2); //�� �� ���
		}
		System.out.println("c:\\temp\\phone.txt�� �����Ͽ����ϴ�.");
		fout.close();
		scanner.close();
	}

}
