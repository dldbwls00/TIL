// ������ (2016133)
// 2021-10-22
// Lab07 - �ǽ� 4. ũ�Ⱑ ���� ū ���� ã��
import java.io.*;

public class FileSize {

	public static void main(String[] args) {
		File dir = new File("c:\\"); //���� ��ü ����: ���͸���
		File[] subfiles = dir.listFiles(); //�������ϵ� ���
		
		long max = 0; //�ִ��� ã�� ����
		String maxname = null;
		for (int i=0; i<subfiles.length; i++) {
			File f = subfiles[i];
			if (f.length() > max) { //�ִ� �뷮 ã��
				max = f.length();
				maxname = f.getName();
			}
		}
		System.out.println("���� ū ������ c:\\" + maxname + " " + max + "����Ʈ");
	}

}
