// ������ (2016133)
// 2021-10-01
// Lab04 - �ǽ� 6. ����
package prob6;

public class Item {
	private String name; //�Ӽ�: �̸�, ����
	private int price;
	
	public Item(String name, int price) { //������ �ʱ�ȭ
		super();
		this.name = name;
		this.price = price;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

}
