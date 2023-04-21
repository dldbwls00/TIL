// ������ (2016133)
// 2021-10-08
// Lab06 - �ǽ� 5. ���� �ܾ� �׽�Ʈ ���α׷�

import java.util.Scanner;
import java.util.Vector;

public class WordTest {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); //scanner ��ü
		Vector<Word> v = new Vector<Word>(); //vector ��ü
		v.add(new Word("love", "���")); //17���� Word ��ü ����
		v.add(new Word("animal", "����"));
		v.add(new Word("emotion", "����"));
		v.add(new Word("human", "�ΰ�"));
		v.add(new Word("stock", "�ֽ�"));
		v.add(new Word("trade", "�ŷ�"));
		v.add(new Word("society", "��ȸ"));
		v.add(new Word("baby", "�Ʊ�"));
		v.add(new Word("honey", "��"));
		v.add(new Word("doll", "����"));
		v.add(new Word("bear", "��"));
		v.add(new Word("picture", "����"));
		v.add(new Word("painting", "�׸�"));
		v.add(new Word("fault", "����"));
		v.add(new Word("example", "����"));
		v.add(new Word("eye", "��"));
		v.add(new Word("statue", "������"));
		
		System.out.println("\"��ǰ����\"�� �ܾ� �׽�Ʈ�� �����մϴ�. -1�� �Է��ϸ� �����մϴ�.\n"
				+ "���� " + v.size() + "���� �ܾ ��� �ֽ��ϴ�.");
		while (true) {
			int n = (int)(Math.random()*v.size()); //0 ~ ����size() ������ ���� ����
			System.out.println(v.get(n).getEng() + "?");
			
			int one, three, four;
			while(true) {
				one = (int)(Math.random()*v.size());
				three = (int)(Math.random()*v.size());
				four = (int)(Math.random()*v.size());
				if (one==n || three==n || four==n)
					continue; //���⿡ ���� �ܾ ������ �ʰ� �ϱ� ����
				break;
			}
			System.out.print("(1)"+v.get(one).getKor()
					+" (2)"+v.get(n).getKor()
					+" (3)"+v.get(three).getKor()
					+" (4)"+v.get(four).getKor()+ " :>");
			
			int ans = scanner.nextInt(); //���� �Է¹ޱ�
			if (ans == -1) { //-1�� �Է��� ��� ����
				System.out.println("\"��ǰ����\"�� �����մϴ�...");
				break;
			}
			if (ans == 2) //��� ��� : ����(2�� ����)�� �Է��� ���
				System.out.println("Excellent!"); 
			else System.out.println("No. !!"); //������ �Է��� ���
		}
		
		scanner.close();
	}

}
