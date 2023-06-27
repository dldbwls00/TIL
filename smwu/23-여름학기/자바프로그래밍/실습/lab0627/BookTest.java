//이유진 (2016133)
//2023-06-27
//Lab0627-5: Book 클래스와 ArrayList를 활용한 책과 평점 저장 프로그램

import java.util.ArrayList;
import java.util.Scanner;

class Book {
	private String title;
	private int score;
	private static int cnt = 0; // 현재까지 등록된 책의 수

	// 생성자
	public Book(String title, int score) {
		super();
		this.title = title;
		this.score = score;
		cnt++;
	}

	// 설정자, 접근자
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public static int getCnt() {
		return cnt;
	}

	//setCnt() 설정자는 생성자에서 cnt를 올리므로 사용하지 않음

	@Override
	public String toString() {
		return "Book [title=" + title + ", score=" + score + "]";
	}

}

public class BookTest {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		ArrayList<Book> bookList = new ArrayList<>(); // 동적으로 추가하기 위해 ArrayList 사용

		while (true) {
			System.out.println("===============================");
			System.out.println("1. 책 등록");
			System.out.println("2. 책 검색");
			System.out.println("3. 모든 책 출력");
			System.out.println("4. 종료");
			System.out.println("===============================");
			System.out.print("메뉴를 선택하시오: ");
			int menu = scan.nextInt();
			scan.nextLine(); // 메뉴 입력 후 입력스트림에 남아있는 줄바꿈문자를 지우기 위함

			switch (menu) {
			case 1:
				System.out.print("책 제목: ");
				String t = scan.nextLine();
				System.out.print("책 평점: ");
				int s = scan.nextInt();

				Book b = new Book(t, s); // 객체 생성
				bookList.add(b); // ArrayList에 추가
				break;

			case 2:
				System.out.print("책 제목: ");
				String key = scan.nextLine();
				for (int i = 0; i < bookList.size(); i++) {
					if (key.equals(bookList.get(i).getTitle())) // ArrayList에 key를 이름으로 갖는 책이 있는 경우
						System.out.println(bookList.get(i));
				}
				break;

			case 3:
				for (int i = 0; i < bookList.size(); i++) { // ArrayList를 순회하며 출력
					System.out.println(bookList.get(i));
				}
//				System.out.println("현재까지 등록된 책의 수: " + Book.getCnt());
				break;

			case 4:
				System.out.println("종료!");
				break;

			// default 생략
			}

			if (menu == 4)
				break;
		}
		scan.close();
	}

}
