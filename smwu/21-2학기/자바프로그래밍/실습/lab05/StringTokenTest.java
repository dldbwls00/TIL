// ������ (2016133)
// 2021-10-08
// Lab05 - �ǽ� 6. ���ڿ� �и�: token
import java.util.Scanner;
import java.util.StringTokenizer;

public class StringTokenTest {

	public static void main(String[] args) {
		System.out.print("���ڿ� �Է� : ");
		Scanner scanner = new Scanner(System.in);
		String s = scanner.nextLine();
		
		StringTokenizer st = new StringTokenizer(s, " "); //���ڿ� �и�
		int cnt = st.countTokens(); //��ū�� ������ ��Ƶδ� ����
		
		while (st.hasMoreTokens()) //���
			System.out.print(st.nextToken()+" / ");
		System.out.println();
		System.out.println("�ܾ� ����: "+cnt);
		
		scanner.close();
	}

}
