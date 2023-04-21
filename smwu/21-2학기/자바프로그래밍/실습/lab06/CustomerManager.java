// 이유진 (2016133)
// 2021-10-08
// Lab06 - 실습 4. 고객 포인트 점수 관리 프로그램

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class CustomerManager {

	public static void main(String[] args) {
		HashMap<String, Integer> h = new HashMap<String, Integer>(); //해쉬맵 객체
		Scanner scanner = new Scanner(System.in); //scanner 객체
		
		System.out.println("** 포인트 관리 프로그램입니다 **"); //출력문
		while (true) {
			System.out.print("이름과 포인트 입력 >> ");
			String n = scanner.nextLine(); //입력받기
			if (n.equals("그만"))	break; //"그만"이라고 입력한 경우 종료
			
			String []n2 = n.split(" "); //공백을 기준으로 나누기

			if (h.get(n2[0]) != null) { //기존에 저장된 고객인 경우(동일 이름 입력된 경우)
				int temp = h.get(n2[0]); //임시로 담아두는 변수를 이용하여
				temp += Integer.parseInt(n2[1]); //포인트 갱신 (더해서 저장함)
				n2[1] = Integer.toString(temp);
				h.put(n2[0], temp);
			}
			h.put(n2[0], Integer.parseInt(n2[1])); //문자열 -> 정수 형변환 후 해시맵에 넣기
			
			Set<String> keys = h.keySet(); //key 문자열을 가진 집합 Set 컬렉션 리턴
			Iterator<String> it = keys.iterator(); //key 문자열을 순서대로 접근할 수 있는 Iterator 리턴
			while (it.hasNext()) { //해쉬맵 내의 모든 포인트 출력
				String name = it.next();
				int score = h.get(name);
				System.out.print("(" + name + "," + score + ")");
			}
			System.out.println();
		}
		scanner.close();
	}

}
