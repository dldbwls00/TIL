//이유진 (2016133)
//2023-06-28
//Lab0628-5: Item 클래스를 상속받는 클래스들과 Buyer클래스를 이용해 구매 프로그램 구현 

class Item {
	private String name;
	private int price;

	// 생성자
	public Item(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}

	// 접근자, 설정자
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

class Food extends Item { // Item의 하위 클래스
	// 생성자: 이름과 가격을 매개변수로 받아서 설정
	public Food(String name, int price) {
		super(name, price); // 부모 클래스의 설정자를 받음
	}

	@Override
	public String toString() { // toString 메소드 재정의
		return "[Food]" + this.getName();
	}
}

class Book extends Item { // Item의 하위 클래스
	// 추가 속성
	private String author;

	// 생성자: 이름, 가격, 저자를 매개변수로 받아서 설정
	public Book(String name, int price, String author) {
		super(name, price);
		this.author = author;
	}

	// 접근자, 설정자
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() { // toString 메소드 재정의
		return "[Book]" + this.getName() + ", 저자: " + this.getAuthor();
	}
}

class Movie extends Item { // Item의 하위 클래스
	// 추가 속성
	private String director;

	// 생성자: 이름, 가격, 감독을 매개변수로 받아서 설정
	public Movie(String name, int price, String director) {
		super(name, price);
		this.director = director;
	}

	// 접근자, 설정자
	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	@Override
	public String toString() { // toString 메소드 재정의
		return "[Movie]" + this.getName() + ", 감독: " + this.getDirector();
	}
}

class Buyer {
	private int money;

	// 생성자: money를 매개변수로 받아서 멤버 변수 설정
	public Buyer(int money) {
		super();
		this.money = money;
	}

	// 접근자
	public int getMoney() {
		return money;
	}

//	public void setMoney(int money) {
//		this.money = money;
//	}

	// buy 메소드: Item과 개수를 매개변수로 받아서 출력 결과와 같은 형태로 내용 출력
	public void buy(Item t, int n) {
		System.out.print(t.toString());
		System.out.println("==>" + n + "개 구매");

		// 구매 가능 여부 체크하는 코드 작성 후 money에서 차감
		if (money >= t.getPrice() * n) {
			money -= t.getPrice() * n;
			System.out.println("구매 완료 후 잔액: " + money);
		} else {
			System.out.println("** 잔액 부족으로 구매 불가능 **");
			System.out.println("잔액: " + money);
		}
	}
}

public class BuyerTest {

	public static void main(String[] args) {

		// 초기 자금을 50000원 가진 Buyer 생성
		Buyer m = new Buyer(50000);

		// 총 5번의 구매 진행
		m.buy((new Food("비빔밥", 7000)), 3);
		m.buy((new Food("라면", 5000)), 2);
		m.buy((new Book("Java Programming", 12000, "이설명")), 1);
		m.buy((new Movie("부산행", 9000, "연상호")), 1);
		m.buy((new Food("김밥", 2000)), 3);
	}

}
