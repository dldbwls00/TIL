// ������ (2016133)
// 2021-10-08
// Lab06 - �ǽ� 6. ��ȭ ���� ���α׷�

public class Movie {
	private String name, director, genre; //����, ����, �帣, �⵵
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
		return "[����: "+name+"/ ����: "+director+"/ �帣: "+genre+"/ �⵵: "+year+"]";
	}
	
}
