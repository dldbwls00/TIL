// 이유진(2016133)
// 2023-07-11
// Lab0710-1: HashMap 활용 예제 - (국가, 수도)를 갖는 Map

import java.util.*;

public class HashmapTest {

	public static void main(String[] args) {
		
		Map<String, String> nation = new HashMap<String, String>(); // HashMap 선언
		nation.put("USA", "Washington"); // HashMap에 데이터 삽입: (key, value) 쌍
		nation.put("Japan", "Tokyo");
		nation.put("China", "Beijing");
		nation.put("UK", "London");
		nation.put("Korea", "Seoul");

		nation.forEach((key, value) -> { // 전체 요소 출력: for-each Stream 라이브러리 사용
			System.out.println("Key: " + key + ", Value: " + value);
		});

		Scanner scan = new Scanner(System.in); // 국가 이름 입력받아서 검색
		System.out.print("국가 이름을 입력하시오: ");
		String key = scan.next();
		System.out.println(key + "의 수도: " + nation.get(key));
		
		scan.close();
	}

}
