// ������ (2016133)
// 2021-09-24
// Lab03 - �ǽ� 4. ��ȭ��ȣ��
import java.util.Scanner;

class Phone{
	private String name, tel;
	
	public Phone(String name, String tel) { //������ -> �ʱ�ȭ 
		this.name = name;
		this.tel = tel;
	}
	public String getName() { //private������ �����ϱ� ���� get
		return name;
	}
	public void printTel(String s) { //��¸޼���
		System.out.println(s+"�� ��ȣ�� "+tel+" �Դϴ�.");
	}
}
public class PhoneBook {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); //��ĳ�� ��ü 
		System.out.print("�ο���>>"); //������ ����� �� �Է¹ޱ�
		int n = scanner.nextInt();
		
		Phone [] p = new Phone[n]; //Phone ��ü �迭 ����
		
		for (int i=0; i<p.length; i++) {//�� ����� ������ �ϳ��� Phone ��ü�� ����
			System.out.print("�̸��� ��ȭ��ȣ(�̸��� ��ȣ�� ��ĭ���� �Է�)>>");
			String name = scanner.next();
			String tel = scanner.next();
			p[i] = new Phone(name, tel);
		}
		System.out.println("����Ǿ����ϴ�...");
		
		while(true) {
			System.out.print("�˻��� �̸�>>");
			String s = scanner.next();
			if (s.equals("�׸�"))	break; //���ڿ� a�� b�� ������ ���� �� a.equals(b)�� �������� �Ǵ�
			
			for (int i=0; i<p.length; i++) { //��ȣ ��¹�
				if (s.equals(p[i].getName()))	p[i].printTel(s);
			}
		}
		scanner.close();
	}

}
