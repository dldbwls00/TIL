// ������ (2016133)
// 2021-10-08
// Lab05 - �ǽ� 3. ���ڿ� ȸ��
import java.util.Scanner;

public class StringRotate {

	public static void main(String[] args) {
		System.out.println("���ڿ��� �Է��ϼ���. ��ĭ�� �־ �ǰ� ���� �ѱ� ��� �˴ϴ�.");
		Scanner scanner = new Scanner(System.in);
		String s = scanner.nextLine(); // ���ڿ� �� �� �Է�
		for (int i=1; i<=s.length(); i++) {
			System.out.print(s.substring(i)); //substring �޼��� ���
 			System.out.println(s.substring(0,i)); //0���� i����x
		}
		scanner.close();
	}

}
