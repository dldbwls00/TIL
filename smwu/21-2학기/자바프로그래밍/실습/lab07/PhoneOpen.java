// ������ (2016133)
// 2021-10-22
// Lab07 - �ǽ� 1. ����ó ���� ���� �� ���
import java.io.FileReader;
import java.io.IOException;

public class PhoneOpen {

	public static void main(String[] args) throws IOException {
		FileReader fin = null; //file reader�� �̿��� ���� �б�
		System.out.println("c:\\temp\\phone.txt�� ����մϴ�.");

		fin = new FileReader("c:\\temp\\phone.txt");
		int c;
		while ((c = fin.read()) != -1) //���� ������ ����Ʈ�� c�� �о����
			System.out.print((char)c); //����Ʈ c�� ���ڷ� ��ȯ�Ͽ� ȭ�鿡 ���
		
		fin.close(); //��Ʈ���� ���� �ݱ� -> ���� ����
	}

}
