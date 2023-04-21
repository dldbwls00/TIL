// ������ (2016133)
// 2021-10-08
// Lab06 - �ǽ� 4. �� ����Ʈ ���� ���� ���α׷�

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class CustomerManager {

	public static void main(String[] args) {
		HashMap<String, Integer> h = new HashMap<String, Integer>(); //�ؽ��� ��ü
		Scanner scanner = new Scanner(System.in); //scanner ��ü
		
		System.out.println("** ����Ʈ ���� ���α׷��Դϴ� **"); //��¹�
		while (true) {
			System.out.print("�̸��� ����Ʈ �Է� >> ");
			String n = scanner.nextLine(); //�Է¹ޱ�
			if (n.equals("�׸�"))	break; //"�׸�"�̶�� �Է��� ��� ����
			
			String []n2 = n.split(" "); //������ �������� ������

			if (h.get(n2[0]) != null) { //������ ����� ���� ���(���� �̸� �Էµ� ���)
				int temp = h.get(n2[0]); //�ӽ÷� ��Ƶδ� ������ �̿��Ͽ�
				temp += Integer.parseInt(n2[1]); //����Ʈ ���� (���ؼ� ������)
				n2[1] = Integer.toString(temp);
				h.put(n2[0], temp);
			}
			h.put(n2[0], Integer.parseInt(n2[1])); //���ڿ� -> ���� ����ȯ �� �ؽøʿ� �ֱ�
			
			Set<String> keys = h.keySet(); //key ���ڿ��� ���� ���� Set �÷��� ����
			Iterator<String> it = keys.iterator(); //key ���ڿ��� ������� ������ �� �ִ� Iterator ����
			while (it.hasNext()) { //�ؽ��� ���� ��� ����Ʈ ���
				String name = it.next();
				int score = h.get(name);
				System.out.print("(" + name + "," + score + ")");
			}
			System.out.println();
		}
		scanner.close();
	}

}
