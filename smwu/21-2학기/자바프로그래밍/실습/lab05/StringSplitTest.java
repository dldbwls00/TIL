// ������ (2016133)
// 2021-10-08
// Lab05 - �ǽ� 6. ���ڿ� �и�: split
import java.util.Scanner;

public class StringSplitTest {

	public static void main(String[] args) {
		System.out.print("���ڿ� �Է� : ");
		Scanner scanner = new Scanner(System.in);
		String s = scanner.nextLine();
		
		String ssplit [] = s.split(" "); //���ڿ� �и�
		
		for (int i=0; i<ssplit.length; i++) //���
			System.out.print(ssplit[i]+" / ");
		System.out.println();
		System.out.println("�ܾ� ����: "+ssplit.length);
		
		scanner.close();
	}

}
