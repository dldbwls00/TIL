// 이유진 (2016133)
// 2021-09-24
// Lab03 - 실습 5. 주사위 굴리기
class Dice{
	private int value;
	
	public Dice() { //생성자 -> 초기화
		value = 0;
	}
	void roll() { //랜덤함수를 사용하여 1~6 사이의 값을 저장
		value = (int)(Math.random()*6+1); 
	}
	int getValue() { //주사위 면의 값을 반환
		return value; 
	}
}
public class DiceTest {
	
	public static void main(String[] args) {
		Dice d1 = new Dice(); //주사위 2개 객체 생성
		Dice d2 = new Dice();
		
		int count = 0; //주사위 굴린 횟수를 세는 변수 선언 및 초기화
		
		do {
			d1.roll();//주사위 2개 각각 굴리는 메소드 호출
			d2.roll();
			System.out.println("주사위1="+d1.getValue()+" 주사위2="+d2.getValue());//실행결과와 같이 주사위의 각 면의 값을 출력
			count++;//실행 횟수 증가
		} while(d1.getValue() + d2.getValue() != 2); //반복조건(종료조건) 작성
		System.out.println("(1,1)이 나오는데 걸린 횟수 = " + count);
	}

}
