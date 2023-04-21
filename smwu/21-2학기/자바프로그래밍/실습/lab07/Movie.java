// 이유진 (2016133)
// 2021-10-22
// Lab07 - 실습 6. movieTest 파일저장, 파일열기
import java.io.Serializable;

public class Movie implements Serializable { //직렬화된 데이터로 사용하기 위해
	private String name, director, genre; //제목, 감독, 장르, 년도
	private int year;
	
	public Movie(String name, String director, String genre, int year) {
		this.name = name;
		this.director = director;
		this.genre = genre;
		this.year = year;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
		return "[제목: "+name+"/ 감독: "+director+"/ 장르: "+genre+"/ 년도: "+year+"]";
	}
	
}
