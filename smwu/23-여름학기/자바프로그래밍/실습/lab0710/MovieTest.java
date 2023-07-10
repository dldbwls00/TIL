// 이유진(2016133)
// 2023-07-11
// Lab0710-3: 컬렉션 활용 - 영화 정보 프로그램

import java.util.*;

class Movie { // 영화 클래스
	private String title, director, genre;
	private int year;

	// 생성자
	public Movie(String title, String director, String genre, int year) {
		super();
		this.title = title;
		this.director = director;
		this.genre = genre;
		this.year = year;
	}

	// 접근자, 설정자
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "[제목: " + title + "/ 감독: " + director + "/ 장르: " + genre + "/ 개봉년도: " + year + " ]";
	}
}

public class MovieTest {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		ArrayList<Movie> movieList = new ArrayList<Movie>(); // 영화 컬렉션
		Movie m;
		String title, director, genre;
		int year;

		while (true) {
			System.out.println("========== 영화 정보 관리 ==========");
			System.out.println("1.입력 / 2.출력 / 3.검색 / 4.수정 / 5.삭제 / 6.종료");
			System.out.print("메뉴 입력>> ");
			int menu = scan.nextInt();
			scan.nextLine();

			switch (menu) {
			case 1:
				System.out.print("제목: ");
				title = scan.nextLine();
				System.out.print("감독: ");
				director = scan.nextLine();
				System.out.print("장르: ");
				genre = scan.nextLine();
				System.out.print("년도: ");
				year = scan.nextInt();

				m = new Movie(title, director, genre, year); // Movie 객체 생성
				movieList.add(m); // 컬렉션에 저장
				continue;

			case 2:
				for (int i = 0; i < movieList.size(); i++)
					System.out.println(movieList.get(i));
				continue;

			case 3:
				System.out.print("검색할 제목 입력: ");
				String search = scan.nextLine();

				for (int i = 0; i < movieList.size(); i++) {
					if (movieList.get(i).getTitle().equals(search)) // 해당 내용으로 컬렉션 검색: 있으면 출력
						System.out.println("검색 결과 " + movieList.get(i));
				}
				continue;

			case 4:
				System.out.print("수정할 제목 입력: ");
				String modify = scan.nextLine();

				for (int i = 0; i < movieList.size(); i++) {
					if (movieList.get(i).getTitle().equals(modify)) { // 해당 내용으로 컬렉션 검색: 있으면 수정
						System.out.println(movieList.get(i));

						System.out.print("제목: "); // 새로운 정보 받기
						title = scan.nextLine();
						System.out.print("감독: ");
						director = scan.nextLine();
						System.out.print("장르: ");
						genre = scan.nextLine();
						System.out.print("년도: ");
						year = scan.nextInt();

						m = new Movie(title, director, genre, year); // 새 Movie 객체 만들기
						movieList.set(i, m); // 컬렉션에서 해당 인덱스의 객체 수정
						System.out.println(movieList.get(i) + "로 수정되었습니다.");
					}
				}
				continue;

			case 5:
				System.out.print("삭제할 제목 입력: ");
				String delete = scan.nextLine();

				for (int i = 0; i < movieList.size(); i++) {
					if (movieList.get(i).getTitle().equals(delete)) { // 해당 내용으로 컬렉션 검색: 있으면 삭제
						System.out.println(movieList.get(i) + "이 삭제되었습니다.");
						movieList.remove(i);
					}
				}
				continue;

			case 6:
				System.out.println("프로그램을 종료합니다.");
				break;
			}
			break;
		}
	}
}
