// ������ (2016133)
// 2021-10-01
// Lab04 - �ǽ� 6. ����
package prob6;

public class Book extends Item{ //Item Ŭ������ ���� Ŭ����
	private String author; //�Ӽ�: ����
	
	public Book(String name, int price, String author) {//�̸�, ����, ���ڸ� �Ű������� �޾� ������ �ۼ�
		super(name, price);
		this.author = author;
	}

	@Override
	public String toString() { //toString �޼ҵ� ������
		return "[Book]"+super.getName()+", ����: "+author;
	}
	
}
