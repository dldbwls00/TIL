// 이유진 (2016133)
// 2021-10-01
// Lab04 - 실습 6. 쇼핑
package prob6;

public class Item {
	private String name; //속성: 이름, 가격
	private int price;
	
	public Item(String name, int price) { //생성자 초기화
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
