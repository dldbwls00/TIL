// ������ (2016133)
// 2021-10-01
// Lab04 - �ǽ� 2. �л� �����
package prob2;

import java.util.Scanner;

public class StudentTest {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		//ũ�� 3�� Human ��ü�� Student ��ü �迭 ����
		Human [] human = new Human[3];
		Student [] student = new Student[3];
		
		//����ڷκ��� �̸��� ���̸� �Է¹޾Ƽ� 3���� Human ��ü�� ����
		for (int i=1; i<=3; i++) {
			System.out.print("["+i+"] Human �Է�:");
			String name = scanner.next();
			int age = scanner.nextInt();
			human[i-1] = new Human(name, age); //�迭 ���� ��ü ����
		}
		
		//����ڷκ��� �̸�, ����, ����, �й��� �Է¹޾Ƽ� 3���� Student ��ü ����
		for (int i=1; i<=3; i++) {
			System.out.print("["+i+"] Student �Է�:");
			String name = scanner.next();
			int age = scanner.nextInt();
			String major = scanner.next();
			int sID = scanner.nextInt();
			student[i-1] = new Student(name, age, major, sID); //�迭 ���� ��ü ����
		}
		
		//�� ��ü�������� �̸����� ��¹� �ۼ�
		for (int i=0; i<human.length; i++)	System.out.println(human[i]);
		for (int i=0; i<student.length; i++)System.out.println(student[i]);
		
		scanner.close();
	}

}
