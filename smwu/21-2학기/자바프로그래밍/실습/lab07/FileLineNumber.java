// ������ (2016133)
// 2021-10-22
// Lab07 - �ǽ� 2. ���Ͽ� ���ι�ȣ ���̱�
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class FileLineNumber {

	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(new FileReader("c:\\windows\\system.ini"));
		//��ĳ�� ��ü -> ���� �о����
		
		System.out.println("c:\\windows\\system.ini ������ �о� ����մϴ�.");
		int cnt = 1; //�ε��� 
		while(scanner.hasNext()) { //������ �ִ� ��� ��� �ݺ�
			System.out.printf("%4d: ", cnt); //����������
			System.out.println(scanner.nextLine()); //�� �پ�
			cnt++;
		}
		scanner.close();
	}

}
