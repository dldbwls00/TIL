// 이유진 (2016133)
// 2021-10-01
// Lab04 - 실습 6. 쇼핑
package prob6;

public class Buyer {
	private int money; //속성: money

	public Buyer(int money) { //Money를 매개변수로 받아서 멤버 변수 설정
		this.money = money;
	}
	
	public int getMoney() {
		return money;
	}
	
	public void buy(Item t, int n) { //Item과 개수를 매개변수로 받는 메소드
		System.out.print(t.toString());
		System.out.println("==>"+n+"개 구매");
		if (money >= t.getPrice()*n){//구매 가능 여부 체크하는 코드 작성 후 money에서 차감
			money -= t.getPrice()*n;
			System.out.println("구매 완료 후 잔액: "+money);
		}
		else System.out.println("잔액 부족: "+money);
	}
	
}
