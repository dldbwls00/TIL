//이유진 (2016133)
//2023-06-29
//Lab0629-3: key와 value값을 쌍으로 가지는 Dictionary를 구현하는 프로그램

abstract class PairMap {
	protected String keyArray[]; // key들을 저장하는 배열
	protected String valueArray[]; // value들을 저장하는 배열

	abstract String get(String key); // key값으로 value를 검색

	abstract void put(String key, String value); // key와 value를 쌍으로 저장

	abstract String delete(String key); // key값을 가진 아이템(value와 함께)을 삭제, 삭제된 value값 리턴

	abstract int length(); // 현재 저장된 아이텡의 개수 리턴
}

class Dictionary extends PairMap {
	private int cnt = 0; // 현재 배열에 저장된 개수

	// 현재 저장된 아이템의 개수를 위한 변수 선언 및 초기화
	public Dictionary(int capacity) {
		// capacity만큼의 각 배열 생성
		keyArray = new String[capacity]; // key들을 저장하는 배열
		valueArray = new String[capacity]; // value들을 저장하는 배열
	}

	@Override
	String get(String key) { // key값으로 value를 검색
		// 현재 배열에 저장된 원소 개수만큼 반복하면서
		for (int i = 0; i < cnt; i++) {
			if (keyArray[i].equals(key)) // key와 같은 값이 있는지 key배열에서 찾아서
				return valueArray[i]; // 해당 value값 반환
		}

		// for문을 빠져나왔는데 반환값이 없어 함수가 종료되지 않음
		return null; // key를 발견할 수 없다면 null 리턴
	}

	@Override
	void put(String key, String value) { // key와 value를 쌍으로 저장
		boolean exist = false;

		for (int i = 0; i < cnt; i++) {// 현재 배열에 저장된 원소 개수만큼 반복하면서
			if (keyArray[i].equals(key)) {// key값이 이미 배열에 저장되어 있는 경우
				valueArray[i] = value;// 그 위치에 value값 저장
				exist = true;
				break;
			}
		}
		if (exist == false) {// key값이 배열에 저장되어 있지 않은 경우
			keyArray[cnt] = key; // 현재 배열에 마지막으로 저장된 원소 다음에 key값과 value값 저장
			valueArray[cnt] = value;
			cnt++; // 현재 배열에 저장된 개수 증가
		}
	}

	@Override
	String delete(String key) { // key값을 가진 아이템(value와 함께)을 삭제, 삭제된 value값 리턴
		for (int i = 0; i < cnt; i++) { // 현재 배열에 저장된 원소 개수만큼 반복하면서
			if (keyArray[i].equals(key)) { // key값이 이미 배열에 저장되어 있는 경우
				String temp = valueArray[i]; // 반환할 값 저장
				for (int j = i; j < cnt - i - 1; j++) {// 삭제된 위치의 뒤에 있는 원소들을 앞으로 한 칸씩 이동
					keyArray[j] = keyArray[j + 1];
					valueArray[j] = valueArray[j + 1];
				}
				cnt--;
				return temp;// value값 반환
			}
		}
		
		return null; // key값이 배열에 저장되어 있지 않은 경우 null 반환
	}

	@Override
	int length() { // 현재 저장된 아이텡의 개수 리턴
		return cnt;
	}
}

public class DictionaryApp {

	public static void main(String[] args) {
		
		Dictionary dic = new Dictionary(10);
		dic.put("김숙명", "자바");
		dic.put("이순헌", "파이썬");
		dic.put("이순헌", "C++"); // key값이 이미 배열에 저장되어 있는 경우 그 위치에 value값 저장
		dic.put("정명신", "react");
		System.out.println("이순헌의 값은 " + dic.get("이순헌"));
		System.out.println("김숙명의 값은 " + dic.get("김숙명"));
		dic.delete("김숙명");
		System.out.println("김숙명의 값은 " + dic.get("김숙명"));
		System.out.println("정명신의 값은 " + dic.get("정명신"));

	}

}
