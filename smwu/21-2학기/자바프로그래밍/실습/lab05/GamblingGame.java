// ������ (2016133)
// 2021-10-08
// Lab05 - �ǽ� 4. ���� ����
import java.util.Scanner;

public class GamblingGame{
	private Player [] p = new Player[2];
	private Scanner scanner = new Scanner(System.in);
	public GamblingGame() {
		for (int i=0; i<p.length; i++) {
			System.out.print((i+1)+"��° ���� �̸�>>");
			String name = scanner.nextLine(); //����ڷκ��� �̸��� �Է¹޾Ƽ� Player ��ü ����
			p[i] = new Player(name);
		}
	}
	public void run() {
		for (int i=0; ; i++) {//�ݺ����� ���鼭
			if(p[i%2].turn()) {//�� ������ �� ���� ��� ���� ���(��, �� ������ turn()�� ȣ���ؼ� true�� ���)
				System.out.println(p[i%2].getName()+"���� �̰���ϴ�!");//������ �޼��� ��� �� ����
				break;
			}
			else {//�� ������ �� ���� ��� ���� ���� ���
				System.out.println("�ƽ�����!");//������ �޼��� ��� �� �ݺ��� ��� �ݺ�
			}
		}
	}
	public static void main(String[] args) {
		GamblingGame game = new GamblingGame();
		game.run();
		
	}
}
