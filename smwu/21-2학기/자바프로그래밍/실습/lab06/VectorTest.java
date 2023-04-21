// ������ (2016133)
// 2021-10-08
// Lab06 - �ǽ� 1. ���� �ǽ�

import java.util.Scanner;
import java.util.Vector;

public class VectorTest {
	public static void printVector(Vector<Integer> v) { //���͸� �Ű������� �޴� �޼ҵ�
		System.out.print("[");
		for (int i=0; i<v.size()-1; i++)	System.out.print(v.get(i) + ", ");
		System.out.print(v.get(v.size()-1));
		System.out.println("]");
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); //scanner ��ü
		Vector<Integer> v = new Vector<Integer>(); //vector ��ü
		
		int max = 0;
		System.out.print("����(-1�� �Էµ� ������)>> "); //��¹�
		while (true) {//�ݺ���
			int n = scanner.nextInt();
			if (n == -1)	break; //-1�� �Էµ� �� �ݺ����� ��������
			v.add(n); //���Ϳ� �Է� ���� ����
			if (n > max)	max = n; //���� ū �� ã��
		}
		
		System.out.print("���� ��:"); //��¹� 1
		printVector(v);
		
		System.out.println("���� ū �� "+ max + " ����"); //���� �޽���
		v.remove(v.indexOf(max)); //����
		
		printVector(v); //��¹� 2
	
		int min = v.get(0);
		for (int i=0; i<v.size(); i++){//���� ���� �� ã��
			if (v.get(i) < min)	min = v.get(i);
		}
		System.out.println("���� ���� �� "+ min + " ����"); //���� �޽���
		v.remove(v.indexOf(min)); //����
		
		System.out.print("���� ��:"); //��¹� 3
		printVector(v);
		
		scanner.close();
	}

}
