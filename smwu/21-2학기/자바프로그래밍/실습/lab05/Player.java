// ������ (2016133)
// 2021-10-08
// Lab05 - �ǽ� 4. ���� ����
import java.util.Scanner;

public class Player {
	private String name;
	private Scanner scanner = new Scanner(System.in);
	
	public Player(String name) { //������ �ʱ�ȭ
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public boolean turn() {
		System.out.print("["+name+"]:<Enter>");
		String input = scanner.nextLine();//�����ڰ� <Enter>Ű �Է��� ������ ��ٸ�
		
		int n1 = (int)(Math.random()*3+1); //3���� ���� ����: 1~3 ������ ���� ����
		int n2 = (int)(Math.random()*3+1);
		int n3 = (int)(Math.random()*3+1);
		
		System.out.print("\t\t"+ n1 + "\t" + n2 + "\t" + n3 + "\t"); //3���� ���� ���
		
		if (n1==n2 && n2==n3)//3���� ������ ������ ��
			return true; //3���� ������ ������ true ��ȯ
		else return false; //�׷��� ������ false ��ȯ
	}
}
