// ������ (2016133)
// 2021-10-22
// Lab07 - �ǽ� 3. �ؽ�Ʈ ���� �����Ͽ� ���̱�
import java.io.*;
import java.util.Scanner;

public class FileAppend {

	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("��ü ��θ��� �ƴ� ���� �̸��� �Է��ϴ� ���, ������ ������Ʈ ������ �־�� �մϴ�.");
		System.out.print("ù��° ���� �̸��� �Է��ϼ���>>");
		File name1 = new File(scanner.next()); //ù ��° ���� ��ü ����
		FileReader fr1 = new FileReader(name1); //�о����
		
		System.out.print("�ι�° ���� �̸��� �Է��ϼ���>>");
		File name2 = new File(scanner.next()); //�� ��° ���� ��ü ����
		FileReader fr2 = new FileReader(name2); //�о����
		
		System.out.print("��ġ�� ���� �̸��� �Է��ϼ���>>");
		File newname = new File(scanner.next()); //��ġ�� ���� ��ü ����
		FileWriter fw = new FileWriter(newname); //���Ϸκ��� �Է¹޾� �����ϱ� ����
		
		int c;
		while((c = fr1.read()) != -1)	fw.write((char)c); //���� �ϳ� �а� �ϳ� ����
		fw.write("\n"); 
		while((c = fr2.read()) != -1)	fw.write((char)c);
		
		System.out.println("������Ʈ ���� �ؿ� c.txt ���Ͽ� �����Ͽ����ϴ�.");
		scanner.close();
		fr1.close(); 
		fr2.close(); 
		fw.close();
	}

}
