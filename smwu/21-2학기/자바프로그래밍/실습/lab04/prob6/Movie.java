// ������ (2016133)
// 2021-10-01
// Lab04 - �ǽ� 6. ����
package prob6;

public class Movie extends Item{ //Item Ŭ������ ���� Ŭ����
	private String director; //�Ӽ�: ����
	
	public Movie(String name, int price, String director) { //�̸�, ����, ������ �Ű������� �޾Ƽ� ������ �ۼ�
		super(name, price);
		this.director = director;
	}

	@Override
	public String toString() { //toString �޼ҵ� ������
		return "[Movie]"+super.getName()+", ����: "+director;
	}
	
}
