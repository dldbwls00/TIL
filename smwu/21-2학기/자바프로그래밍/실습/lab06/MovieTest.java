// 이유진 (2016133)
// 2021-10-08
// Lab06 - 실습 6. 영화 정보 프로그램

import java.util.Iterator;
import java.util.Scanner;
import java.util.Vector;

public class MovieTest {

	static int findIndex(Vector<Movie> v, String name) { //인덱스 찾는 메서드
		int idx = -1;
		for (int i=0; i<v.size(); i++) {
			if (v.get(i).getName().equals(name)) idx = i; //인덱스 저장
		}
		return idx;
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); //scanner 객체
		Vector<Movie> v = new Vector<Movie>(); //vector 객체
		
		while (true) {
			System.out.println("========== 영화 정보 관리 ==========");
			System.out.println("1.입력/2.출력/3.검색/4.수정/5.삭제/6.종료");
			System.out.print("메뉴입력>>");
			int menu = scanner.nextInt();
			
			if (menu == 1) { //영화 정보 입력: 사용자로부터 정보를 입력받아 컬렉션에 저장한다.
				System.out.print("제목: ");
				String name = scanner.next();
				System.out.print("감독: ");
				String director = scanner.next();
				System.out.print("장르: ");
				String genre = scanner.next();
				System.out.print("년도: ");
				int year = scanner.nextInt();
				v.add(new Movie(name, director, genre, year)); //벡터에 저장
			}
			else if (menu == 2) { //영화 정보 출력: 모든 영화의 정보를 화면에 출력
				Iterator<Movie> it = v.iterator();
				while(it.hasNext())	System.out.println(it.next());
			}
			else if (menu == 3) { //영화 정보 검색: 컬렉션을 검색
				System.out.print("검색할 제목 입력: ");
				String name = scanner.next();
				if (findIndex(v, name) != -1)	System.out.println("검색 결과 "+v.get(findIndex(v, name))); //일치하는 결과가 있는 경우
			}
			else if (menu == 4) { //영화 정보 수정
				System.out.print("수정할 제목 입력: ");
				String name = scanner.next();
				if (findIndex(v, name) != -1)	System.out.println("검색 결과 "+v.get(findIndex(v, name))); //일치하는 결과가 있는 경우
				
				System.out.print("제목: ");
				String nname = scanner.next();
				System.out.print("감독: ");
				String ndirector = scanner.next();
				System.out.print("장르: ");
				String ngenre = scanner.next();
				System.out.print("년도: ");
				int nyear = scanner.nextInt();
				Movie nmovie = new Movie(nname, ndirector, ngenre, nyear); //새로운 객체
				v.set(findIndex(v, name), nmovie); //수정: 기존 값을 새로운 객체로 덮어씌우기
			}
			else if (menu == 5) { //영화 정보 삭제
				System.out.print("삭제할 제목 입력: ");
				String name = scanner.next();
				v.remove(findIndex(v, name));
			}
			else if (menu == 6) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
		}
		scanner.close();
	}
}
