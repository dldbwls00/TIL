// ������ (2016133)
// 2021-10-08
// Lab06 - �ǽ� 2. ������ ���� ���α׷�

import java.util.Scanner;
import java.util.Vector;

public class VectorRainfall {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); //scanner ��ü
		Vector<Integer> v = new Vector<Integer>(); //vector ��ü
		int sum = 0, cnt = 0, ave = 0;
		
		while (true) {
			System.out.print("������ �Է�(0 �Է½� ����)>> ");
			int n = scanner.nextInt();
			if (n == 0) break;
			
			cnt++;
			sum += n; //�� ����
			ave = sum/cnt; //��� ���
			v.add(n); //���Ϳ� �߰�
			
			for (int i=0; i<v.size(); i++)	System.out.print(v.get(i)+" "); //��¹�
			System.out.println();
			System.out.println("���� ��� " + ave);
		}
		scanner.close();
	}

}
