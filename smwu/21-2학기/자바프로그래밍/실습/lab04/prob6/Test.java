// 이유진 (2016133)
// 2021-10-01
// Lab04 - 실습 6. 쇼핑
package prob6;

public class Test {

	public static void main(String[] args) {
		Buyer m = new Buyer(40000);
		m.buy((new Food("비빔밥", 5000)), 3);
		m.buy((new Food("라면", 3000)), 2);
		m.buy((new Book("Java Programming", 7000, "자바")), 1);
		m.buy((new Movie("부산행", 8000, "연상호")), 1);
		m.buy((new Food("김밥", 2000)), 3);
	}

}
