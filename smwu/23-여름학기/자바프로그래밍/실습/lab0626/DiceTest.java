//이유진 (2016133)
//2023-06-26
//Lab0626-6: Dice 클래스를 이용해 2개의 주사위를 그 눈의 합이 2가 될 때까지 반복해서 던짐

class Dice {
	//필드
	private int value;

	//생성자
	public Dice() {
		value = 0;
	}

	//접근자 (생성자 생략: roll()메서드로 랜덤값을 사용하므로)
	public int getValue() {
		// 주사위 변의 값을 반환
		return value;
	}
	
	//메서드
	public void roll() {
		// 랜덤함수를 사용하여 1~6 사이의 값을 저장
		value = (int) (Math.random() * 6 + 1);
	}

}

public class DiceTest {

	public static void main(String[] args) {

		// 주사위 객체 2개 생성
		Dice d1 = new Dice();
		Dice d2 = new Dice();

		// 주사위 굴린 횟수를 세는 변수 선언 및 초기화
		int count = 0;

		do {
			d1.roll(); // 주사위 2개를 각각 굴리는 메서드 호출
			d2.roll();
			
			//실행 결과와 같이 주사위의 각 면의 값을 출력
			System.out.println("주사위1=" + d1.getValue() + " 주사위2=" + d2.getValue());
			
			count++; // 실행 횟수 증가
		} while (d1.getValue() + d2.getValue() != 2);
		System.out.println("(1,1)이 나오는데 걸린 횟수 = " + count);
	}

}
