// ������ (2016133)
// 2021-10-01
// Lab04 - �ǽ� 6. ����
package prob6;

public class Food extends Item{ //Item Ŭ������ ���� Ŭ����
	
	public Food(String name, int price) { //�̸�, ������ �Ű������� �޾Ƽ� ������ �ۼ�
		super(name, price);
	}

	@Override
	public String toString() { //toString �޼ҵ� ������
		return "[Food]"+super.getName();
	}
	
}
