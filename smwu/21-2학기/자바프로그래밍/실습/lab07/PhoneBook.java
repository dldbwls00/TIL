// ������ (2016133)
// 2021-10-22
// Lab07 - �ǽ� 5. �ؽø��� �̿��� ��ȭ��ȣ �˻�
import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class PhoneBook {

	public static void main(String[] args) throws IOException{
		HashMap<String, String> map = new HashMap<String, String>(); //�ؽø� ��ü
		Scanner scanner = new Scanner(System.in); //��ĳ�� ��ü
		
		FileReader file = new FileReader("c:\\temp\\phone.txt"); //���� ��ü ����
		BufferedReader reader = new BufferedReader(file); //���۷� �б�
		
		String line;
		while((line = reader.readLine()) != null) { //���پ� �д´�
			String[] st = line.split(" ");
			if (st.length >= 2)	map.put(st[0], st[1]);
		}

		System.out.println("�� " + map.size() + "���� ��ȭ��ȣ�� �о����ϴ�.");
		while(true) {
			System.out.print("�̸�>> ");
			String name = scanner.next();
			if (name.equals("�׸�"))	break;
			
			if (map.get(name) == null) {
				System.out.println("ã�� �̸��� �����ϴ�.");
				continue;
			}
			System.out.println(map.get(name)); //key���� �̿��� value�� ���
		}
		scanner.close();
		reader.close();
	}

}
