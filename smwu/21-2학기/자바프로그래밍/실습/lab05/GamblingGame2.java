// ������ (2016133)
// 2021-10-08
// Lab05 - �ǽ� 5. ���� ���� Ȯ��
import java.util.Scanner;

public class GamblingGame2 {
	private Player [] p;
	private Scanner scanner = new Scanner(System.in);
	static int num; //������ Ŭ������ ��� ��ü�� ���� �����Ǵ� static ����
	public GamblingGame2() {
		p = new Player[num];
		for (int i=0; i<p.length; i++) {
			System.out.print((i+1)+"��° ���� �̸�>>");
			String name = scanner.nextLine(); //����ڷκ��� �̸��� �Է¹޾Ƽ� Player ��ü ����
			p[i] = new Player(name);
		}
	}
	public void run() {
		for (int i=0; ; i++) {//�ݺ����� ���鼭
			if(p[i%num].turn()) {//�� ������ �� ���� ��� ���� ���(��, �� ������ turn()�� ȣ���ؼ� true�� ���)
				System.out.println(p[i%num].getName()+"���� �̰���ϴ�!");//������ �޼��� ��� �� ����
				break;
			}
			else {//�� ������ �� ���� ��� ���� ���� ���
				System.out.println("�ƽ�����!");//������ �޼��� ��� �� �ݺ��� ��� �ݺ�
			}
		}
	}
	public static void main(String[] args) {
		System.out.print("���� ���ӿ� ������ ���� ����>>");
		Scanner scanner = new Scanner(System.in);
		num = scanner.nextInt();
		
		GamblingGame2 game = new GamblingGame2();
		game.run();
		
		scanner.close();
	}

}
