//이유진 (2016133)
//2023-06-29
//Lab0629-2: java.util의 Iterator 인터페이스를 구현해 카드덱배열을 출력하는 프로그램

import java.util.Iterator;

class CardDeck implements Iterator {
	// 13장의 카드가 저장된 문자열 객체 배열 생성 >> "2", ... "Ace" 까지 저장
	String[] card = new String[] { "2", "3", "4", "5", "6", "7", "8", "9", "10", 
			"Jack", "Queen", "King", "Ace" };

	// 현재 위치를 위한 변수 선언 및 초기화
	private int now = 0;

	// 생성자
	public String[] getCard() {
		return card;
	}

	public void setCard(String[] card) {
		this.card = card;
	}

	public int getNow() {
		return now;
	}

	public void setI(int now) {
		this.now = now;
	}

	public boolean hasNext() { // 반환할 요소가 있으면 true를 반환하는 메서드
		if (now == card.length) // 현재 위치가 카드 배열의 끝까지 봤다면 (즉, 카드배열의 길이와 같다면)
			return false; // 더이상 다음 값은 존재하지 않으므로 false
		else // 그렇지 않으면 true
			return true;
	}

	public Object next() { // 반복의 다음 요소를 반환하는 메서드
		// 문자열 배열로부터 현재 위치의 값을 반환함
		// 현재 위치값 증가
		return card[now++]; // 반환 후 증가
	}

	public void remove() { // 이 반복자가 반환한 마지막 요소를 기본 컬렉션에서 제거하는 메서드
		// 구현하지 않고 {}로만 메서드를 구현함
	}
}

public class IteratorTest {

	public static void main(String[] args) {
		CardDeck i = new CardDeck();
		while (i.hasNext()) {
			System.out.println("next()가 반환하는 값: " + i.next());
		}
	}

}
