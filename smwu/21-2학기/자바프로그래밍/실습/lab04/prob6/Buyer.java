// ������ (2016133)
// 2021-10-01
// Lab04 - �ǽ� 6. ����
package prob6;

public class Buyer {
	private int money; //�Ӽ�: money

	public Buyer(int money) { //Money�� �Ű������� �޾Ƽ� ��� ���� ����
		this.money = money;
	}
	
	public int getMoney() {
		return money;
	}
	
	public void buy(Item t, int n) { //Item�� ������ �Ű������� �޴� �޼ҵ�
		System.out.print(t.toString());
		System.out.println("==>"+n+"�� ����");
		if (money >= t.getPrice()*n){//���� ���� ���� üũ�ϴ� �ڵ� �ۼ� �� money���� ����
			money -= t.getPrice()*n;
			System.out.println("���� �Ϸ� �� �ܾ�: "+money);
		}
		else System.out.println("�ܾ� ����: "+money);
	}
	
}
