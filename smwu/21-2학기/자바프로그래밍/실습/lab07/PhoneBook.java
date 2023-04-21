// 이유진 (2016133)
// 2021-10-22
// Lab07 - 실습 5. 해시맵을 이용한 전화번호 검색
import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class PhoneBook {

	public static void main(String[] args) throws IOException{
		HashMap<String, String> map = new HashMap<String, String>(); //해시맵 객체
		Scanner scanner = new Scanner(System.in); //스캐너 객체
		
		FileReader file = new FileReader("c:\\temp\\phone.txt"); //파일 객체 생성
		BufferedReader reader = new BufferedReader(file); //버퍼로 읽기
		
		String line;
		while((line = reader.readLine()) != null) { //한줄씩 읽는다
			String[] st = line.split(" ");
			if (st.length >= 2)	map.put(st[0], st[1]);
		}

		System.out.println("총 " + map.size() + "개의 전화번호를 읽었습니다.");
		while(true) {
			System.out.print("이름>> ");
			String name = scanner.next();
			if (name.equals("그만"))	break;
			
			if (map.get(name) == null) {
				System.out.println("찾는 이름이 없습니다.");
				continue;
			}
			System.out.println(map.get(name)); //key값을 이용해 value값 출력
		}
		scanner.close();
		reader.close();
	}

}
