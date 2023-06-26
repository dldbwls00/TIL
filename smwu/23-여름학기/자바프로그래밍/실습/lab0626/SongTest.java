//이유진 (2016133)
//2023-06-26
//Lab0626-2: Song 클래스를 이용해 노래 정보를 출력함

class Song {
	// 필드 정의
	private String title;
	private String artist;
	private int length;

	// 생성자 중복 정의 : this() 호출 활용
	public Song() {
		this("제목 없음", "정보 없음", 0);
	}

	public Song(String title) {
		this(title, "정보 없음", 0);
	}

	public Song(String title, String artist) {
		this(title, artist, 0);
	}

	public Song(String title, String artist, int length) {
		super();
		this.title = title;
		this.artist = artist;
		this.length = length;
	}

	// 접근자, 설정자
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	// toString 메서드 재정의
	@Override
	public String toString() {
		return "Song [제목:" + title + ", 가수:" + artist + ", 곡의 길이:" + length + "]";
	}

}

public class SongTest {

	public static void main(String[] args) {

		//Song 객체 선언 후 생성
		Song s1 = new Song("Ountward Bound", "Nana", 180);
		Song s2 = new Song("Jambalya", "Carpenters");
		Song s3 = new Song("Yesterday");
		Song s4 = new Song();

		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		System.out.println(s4);

	}

}
