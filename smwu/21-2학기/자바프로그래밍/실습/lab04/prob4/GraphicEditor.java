// ������ (2016133)
// 2021-10-01
// Lab04 - �ǽ� 4. �߻� Ŭ���� �ǽ� : �׷��� ������
package prob4;

import java.util.Scanner;

public class GraphicEditor {
	private String name;
	public GraphicEditor(String name) {
		this.name = name;
	}
	private Scanner scanner = new Scanner(System.in);
	private Shape start = null, end = null;
	private int cnt=0;
	
	
	public void run() {
		System.out.println("�׷��� ������ beauty�� �����մϴ�.");
		int choice = 0;
		
		while(true) { //�ݺ����� ���鼭 �޴� ��� �� �޴� ��� ����
			System.out.print("����(1), ����(2), ��� ����(3), ����(4)>>");
			choice = scanner.nextInt();
			
			if (choice == 1 ) { //������ ��� insert �޼ҵ� ȣ��
				System.out.print("Line(1), Rect(2), Circle(3)>>");
				insert(scanner.nextInt());
			}
			else if (choice == 2) { //������ ��� delete �޼ҵ� ȣ��
				System.out.print("������ ������ ��ġ>>");
				delete(scanner.nextInt());
			}
			else if (choice == 3) {//��� ������ ��� ���� ����Ʈ �̵��ϸ鼭 �ش� �� ���
				Shape p = start;
				while(p != null) {
					p.draw(); //��ü�� ���� �ٸ� draw ȣ���
					p = p.getNext();
				}
			}
			else if (choice == 4)	break;//������ ��� �ݺ��� ����������
		}
		System.out.println("beauty�� �����մϴ�.");
	}
	
	private boolean delete(int index) {
		int temp = cnt; //�ӽ� ����
		if (start == null || index > cnt) {//����Ʈ�� �� ��� �Ǵ� �ش� ��ġ�� ���Ұ� ���� ���
			return false;
		}
		//���� ����Ʈ���� �ش� ��ġ�� �̵� �� �ش� ���� ����
		if (cnt == 0) {//����Ʈ�� ���Ұ� �� ���ۿ� ���� ���
			start = null;
			end = null;
		}
		else if (index == 0) {//ù ��° ���Ҹ� �����ϴ� ���
			start = start.getNext(); //������ �̵�
		}
		else if (index == cnt) {//������ ���Ҹ� �����ϴ� ���
			Shape  a = start, p = start;
			while(temp == cnt-index-1) {
				a = p;
				p = p.getNext();
				temp--;
			}
			a.setNext(p.getNext());
		}
		else {//�߰� ���Ҹ� �����ϴ� ���
			Shape  a = start, p = start;
			while(temp == cnt-index-1) {
				a = p;
				p = p.getNext();
				temp--;
			}
			a.setNext(p.getNext());
		}
		cnt--; //��ü ���� ����
		return true; //���������� �������� ��� true ��ȯ
	}
	
	private void insert(int choice) {
		if (start == null) { //ù ������ ���
			if (choice == 1) {//choice���� ���� ��ü�� ����
				start = new Line(); //Line ��ü ����
				end = start;
			}
			else if (choice == 2) {
				start = new Rect2(); //Rect2 ��ü ����
				end = start;
			}
			else if (choice == 3) {
				start = new Circle2(); //Circle2 ��ü ����
				end = start;
			}
		}
		else {
			Shape obj;
			if (choice == 1) {
				obj = new Line();
				end.setNext(obj);
				end = obj;
			}
			else if (choice == 2) {
				obj = new Rect2();
				end.setNext(obj);
				end = obj;
			}
			else if (choice == 3) {
				obj = new Circle2();
				end.setNext(obj);
				end = obj;
			}
		}
		cnt++; //�ε��� �������� ��ġ
	}
	
	public static void main(String [] args) {
		GraphicEditor ge = new GraphicEditor("beauty");
		ge.run();
	}
}
