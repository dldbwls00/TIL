// ������ (2016133)
// 2021-09-24
// Lab03 - �ǽ� 1. Grade Ŭ���� �ۼ� : �� ������ ��� ���ϱ�
import java.util.Scanner;

public class Grade {
	int math, science, english; //��� ���� ����
	
	public Grade(int math, int science, int english) {//������ �ۼ� (����, ����, ���� ������ ���� �Ű� ���� 3�� �޾Ƽ� ��� ������ ����)
		this.math = math;
		this.science = science;
		this.english = english;
	}
	
	public int average() {// �� ������ ����� �����ϴ� average() �޼ҵ� �ۼ�
		return (math + science + english)/3;
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); //��ĳ�� ��ü
		
		System.out.print("����, ����, ���� ������ 3���� ���� �Է�>>");
		int math = scanner.nextInt(); //�Է¹ޱ�
		int science = scanner.nextInt();
		int english = scanner.nextInt();
		
		Grade me = new Grade(math, science, english); //��ü ����
		
		System.out.println("����� " + me.average()); //��� ���
		
		scanner.close();
	}

}
