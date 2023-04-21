// ������ (2016133)
// 2021-09-24
// Lab03 - �ǽ� 5. �ֻ��� ������
class Dice{
	private int value;
	
	public Dice() { //������ -> �ʱ�ȭ
		value = 0;
	}
	void roll() { //�����Լ��� ����Ͽ� 1~6 ������ ���� ����
		value = (int)(Math.random()*6+1); 
	}
	int getValue() { //�ֻ��� ���� ���� ��ȯ
		return value; 
	}
}
public class DiceTest {
	
	public static void main(String[] args) {
		Dice d1 = new Dice(); //�ֻ��� 2�� ��ü ����
		Dice d2 = new Dice();
		
		int count = 0; //�ֻ��� ���� Ƚ���� ���� ���� ���� �� �ʱ�ȭ
		
		do {
			d1.roll();//�ֻ��� 2�� ���� ������ �޼ҵ� ȣ��
			d2.roll();
			System.out.println("�ֻ���1="+d1.getValue()+" �ֻ���2="+d2.getValue());//�������� ���� �ֻ����� �� ���� ���� ���
			count++;//���� Ƚ�� ����
		} while(d1.getValue() + d2.getValue() != 2); //�ݺ�����(��������) �ۼ�
		System.out.println("(1,1)�� �����µ� �ɸ� Ƚ�� = " + count);
	}

}
