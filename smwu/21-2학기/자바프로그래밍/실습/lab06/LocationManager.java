// ������ (2016133)
// 2021-10-08
// Lab06 - �ǽ� 3. ���� ��,�浵 ���� ����

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class LocationManager{

	public static void main(String[] args) {
		HashMap<String, Location> h = new HashMap<String, Location>(); //�ؽ��� ��ü
		Scanner scanner = new Scanner(System.in); //scanner ��ü
		
		System.out.println("����, ����, �浵�� �Է��ϼ���."); //��¹�
		for (int i=0; i<4; i++) { //4���� ���� ����
			System.out.print(">> ");
			String n = scanner.nextLine(); //�Է¹ޱ�
			
			String []n2 = n.split(","); //,�� �������� ������
			//Location ��ü ����
			Location location = new Location(n2[0], Double.parseDouble(n2[1]), Double.parseDouble(n2[2]));
			h.put(location.getName(), location); //�ؽøʿ� ����
		}
		
		System.out.println("--------------------------------------------------");
		Set<String> keys = h.keySet(); //key���ڿ��� ���� ���� Set �÷��� ����
		Iterator<String> it = keys.iterator(); //key���ڿ��� ������� ������ �� �ִ� Iterator ����
		while(it.hasNext()) { //�ؽøʿ� �ִ� ��� ���� ���
			String name = it.next();
			double lat = h.get(name).getLat();
			double lon = h.get(name).getLon();
			System.out.println(name + "\t" + lat + "\t" + lon);
		}
		System.out.println("--------------------------------------------------");
		
		while (true) { //���� �̸��� �ݺ��ؼ� �˻�
			System.out.print("���� �̸� >> ");
			String input = scanner.next();
			
			if (input.equals("�׸�"))	break; //"�׸�"�� �Է��ϸ� �˻� ����
			if (h.get(input) == null) {//�ؽ��ʿ� ���� ���
				System.out.println(input + "��(��) �����ϴ�."); 
				continue;
			}
			
			double lat = h.get(input).getLat();
			double lon = h.get(input).getLon();
			System.out.println(input + "\t" + lat + "\t" + lon);
		}
		scanner.close();
	}

}
