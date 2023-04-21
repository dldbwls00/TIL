// 이유진 (2016133)
// 2021-10-01
// Lab04 - 실습 1. Magazine 만들기
package prob1;

public class Book1 {
	private String title; //제목
	private int pages;
	private String author;
	private int count = 0;
	
	public Book1(String title, int pages, String author, int count) {
		super();
		this.title = title;
		this.pages = pages;
		this.author = author;
		count++; //책이 생성될 때마다 책의 수(count)증가
	}
	
	//각 필드에 대하여 접근자와 설정자 메소드를 작성
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
	
	//책의 개수에 대해서는 접근자 메소드만 클래스 메소드로 작성 -> set 없음
	public int getCount() {
		return count;
	}
}
