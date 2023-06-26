//이유진 (2016133)
//2023-06-26
//Lab0626-3: Movie 클래스를 이용해 영화 정보를 입력받고 결과를 출력함

import java.util.Scanner;

class Movie {
	// 필드 선언
	private String title;
	private double rating;
	private String director;
	private int year;

	// 생성자 정의
	public Movie(String title, double rating, String director, int year) {
		super();
		this.title = title;
		this.director = director;
		this.rating = rating;
		this.year = year;
	}

	// 접근자, 생성자
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	// toString 메서드 작성
	@Override
	public String toString() {
		return "Movie [title=" + title + ", rating=" + rating + ", director=" + director + ", year=" + year + "]";
	}

}

public class MovieTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//입력받기
		System.out.print("제목: ");
		String s = sc.nextLine();
		System.out.print("감독: ");
		String d = sc.nextLine();
		System.out.print("연도: ");
		int year = sc.nextInt();
		System.out.print("평점: ");
		double rating = sc.nextDouble();

		Movie m = new Movie(s, rating, d, year); //Movie 객체 선언 후 생성
		System.out.println(m);

		sc.close();
	}

}
