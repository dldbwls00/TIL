// ������ (2016133)
// 2021-10-08
// Lab06 - �ǽ� 6. ��ȭ ���� ���α׷�

import java.util.Iterator;
import java.util.Scanner;
import java.util.Vector;

public class MovieTest {

	static int findIndex(Vector<Movie> v, String name) { //�ε��� ã�� �޼���
		int idx = -1;
		for (int i=0; i<v.size(); i++) {
			if (v.get(i).getName().equals(name)) idx = i; //�ε��� ����
		}
		return idx;
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); //scanner ��ü
		Vector<Movie> v = new Vector<Movie>(); //vector ��ü
		
		while (true) {
			System.out.println("========== ��ȭ ���� ���� ==========");
			System.out.println("1.�Է�/2.���/3.�˻�/4.����/5.����/6.����");
			System.out.print("�޴��Է�>>");
			int menu = scanner.nextInt();
			
			if (menu == 1) { //��ȭ ���� �Է�: ����ڷκ��� ������ �Է¹޾� �÷��ǿ� �����Ѵ�.
				System.out.print("����: ");
				String name = scanner.next();
				System.out.print("����: ");
				String director = scanner.next();
				System.out.print("�帣: ");
				String genre = scanner.next();
				System.out.print("�⵵: ");
				int year = scanner.nextInt();
				v.add(new Movie(name, director, genre, year)); //���Ϳ� ����
			}
			else if (menu == 2) { //��ȭ ���� ���: ��� ��ȭ�� ������ ȭ�鿡 ���
				Iterator<Movie> it = v.iterator();
				while(it.hasNext())	System.out.println(it.next());
			}
			else if (menu == 3) { //��ȭ ���� �˻�: �÷����� �˻�
				System.out.print("�˻��� ���� �Է�: ");
				String name = scanner.next();
				if (findIndex(v, name) != -1)	System.out.println("�˻� ��� "+v.get(findIndex(v, name))); //��ġ�ϴ� ����� �ִ� ���
			}
			else if (menu == 4) { //��ȭ ���� ����
				System.out.print("������ ���� �Է�: ");
				String name = scanner.next();
				if (findIndex(v, name) != -1)	System.out.println("�˻� ��� "+v.get(findIndex(v, name))); //��ġ�ϴ� ����� �ִ� ���
				
				System.out.print("����: ");
				String nname = scanner.next();
				System.out.print("����: ");
				String ndirector = scanner.next();
				System.out.print("�帣: ");
				String ngenre = scanner.next();
				System.out.print("�⵵: ");
				int nyear = scanner.nextInt();
				Movie nmovie = new Movie(nname, ndirector, ngenre, nyear); //���ο� ��ü
				v.set(findIndex(v, name), nmovie); //����: ���� ���� ���ο� ��ü�� ������
			}
			else if (menu == 5) { //��ȭ ���� ����
				System.out.print("������ ���� �Է�: ");
				String name = scanner.next();
				v.remove(findIndex(v, name));
			}
			else if (menu == 6) {
				System.out.println("���α׷��� �����մϴ�.");
				break;
			}
		}
		scanner.close();
	}
}
