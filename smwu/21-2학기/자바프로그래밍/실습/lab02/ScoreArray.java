// ������ (2016133)
// 2021-09-17
// Lab02 - �ǽ� 6. ���� �̸��� ���� ����ϱ�
import java.util.Scanner;

public class ScoreArray {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		//����� ������ ¦�� �̷�� �� ���� �迭
		String course[] = {"Java", "C++", "HTML5", "��ǻ�ͱ���", "�ȵ���̵�"};
		int score[] = {95, 88, 76, 62, 55};
		
		while(true) {
			System.out.print("���� �̸�>>");
			String name = scanner.next(); //���� �̸� �Է� �ޱ�
			
			if (name.equals("�׸�")) break; //"�׸�"�� �Է¹޴� ��� ����
			
			for (int i=0; i<course.length; i++) {
				if (course[i].equals(name)) {//��ġ�ϴ� ���� �̸��� �ִ� ���
					System.out.println(name+"�� ������ "+score[i]); //���� ���
					break;
				}
				if (i==course.length-1) { //�迭 ������ ���Ҵµ� ��ġ�ϴ� ���� �̸��� ���� ���
					System.out.println("���� �����Դϴ�.");
					break;
				}
			}
			
		}
		scanner.close();
	}

}
