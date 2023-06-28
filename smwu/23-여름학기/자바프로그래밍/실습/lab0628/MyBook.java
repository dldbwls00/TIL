//이유진 (2016133)
//2023-06-28
//Lab0628-2: MyBook 클래스를 상속받는 Magazine 클래스를 구현함

class MyBook {
	// 속성 정보
	private String title; // 제목
	private int pages; // 페이지 수
	private String author; // 저자
	private static int count = 0; // 책의 개수

	// 생성자 (하나 이상 정의)
	public MyBook(String title, int pages, String author) {
		super();
		this.title = title;
		this.pages = pages;
		this.author = author;
		count++; // 책이 생성될 때마다 책의 수 증가
	}

	// 설정자, 접근자
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	// count에 대해서는 접근자 메소드만 클래스 메소드로 작성 -> set 없음
	public static int getCount() {
		return count;
	}
}

class Magazine extends MyBook { // MyBook에 대한 하위 클래스
	// 추가 속성: 발매일
	private String date; // 추가 속성: 발매일

	// 생성자 (한 개 이상)
	public Magazine(String title, int pages, String author, String date) {
		super(title, pages, author); // 생성자 내에서 부모 생성자 호출
		this.date = date;
	}

	// 설정자, 접근자
	// 부모 클래스에서 받은 필드들은 별도의 메서드 작성 없이 사용 가능하므로 작성하지 않음
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
