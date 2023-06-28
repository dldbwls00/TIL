//이유진 (2016133)
//2023-06-28
//Lab0628-1: Circle클래스를 상속받는 Pizza 클래스를 이용해 피자에 대한 청보를 출력함

class Circle {
	protected int radius;

	public Circle(int r) {
		radius = r;
	}
}

class Pizza extends Circle {
	String pizzaName;

	//생성자
	public Pizza(String pizzaName, int r) {
		super(r); //부모의 생성자
		this.pizzaName = pizzaName;
	}

	//접근자, 설정자
	public String getPizzaName() {
		return pizzaName;
	}
	
	public void setPizzaName(String pizzaName) {
		this.pizzaName = pizzaName;
	}
	
	@Override
	public String toString() {
		//Circle로부터 상속받은 radius를 super 키워드로 사용
		return "피자의 종류: " + pizzaName + ", 피자의 크기: " + super.radius;
	}

}

public class PizzaTest {

	public static void main(String[] args) {
		
		Pizza obj = new Pizza("Pepperoni", 20);
		System.out.println(obj);
	}

}
