// 이유진 (2016133)
// 2021-10-08
// Lab06 - 실습 3. 도시 위,경도 정보 저장

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class LocationManager{

	public static void main(String[] args) {
		HashMap<String, Location> h = new HashMap<String, Location>(); //해쉬맵 객체
		Scanner scanner = new Scanner(System.in); //scanner 객체
		
		System.out.println("도시, 위도, 경도를 입력하세요."); //출력문
		for (int i=0; i<4; i++) { //4개의 도시 저장
			System.out.print(">> ");
			String n = scanner.nextLine(); //입력받기
			
			String []n2 = n.split(","); //,를 기준으로 나눠서
			//Location 객체 생성
			Location location = new Location(n2[0], Double.parseDouble(n2[1]), Double.parseDouble(n2[2]));
			h.put(location.getName(), location); //해시맵에 저장
		}
		
		System.out.println("--------------------------------------------------");
		Set<String> keys = h.keySet(); //key문자열을 가진 집합 Set 컬렉션 리턴
		Iterator<String> it = keys.iterator(); //key문자열을 순서대로 접근할 수 있는 Iterator 리턴
		while(it.hasNext()) { //해시맵에 있는 모든 도시 출력
			String name = it.next();
			double lat = h.get(name).getLat();
			double lon = h.get(name).getLon();
			System.out.println(name + "\t" + lat + "\t" + lon);
		}
		System.out.println("--------------------------------------------------");
		
		while (true) { //도시 이름을 반복해서 검색
			System.out.print("도시 이름 >> ");
			String input = scanner.next();
			
			if (input.equals("그만"))	break; //"그만"을 입력하면 검색 종료
			if (h.get(input) == null) {//해쉬맵에 없는 경우
				System.out.println(input + "은(는) 없습니다."); 
				continue;
			}
			
			double lat = h.get(input).getLat();
			double lon = h.get(input).getLon();
			System.out.println(input + "\t" + lat + "\t" + lon);
		}
		scanner.close();
	}

}
