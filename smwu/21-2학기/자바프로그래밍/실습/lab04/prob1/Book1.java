// ������ (2016133)
// 2021-10-01
// Lab04 - �ǽ� 1. Magazine �����
package prob1;

public class Book1 {
	private String title; //����
	private int pages;
	private String author;
	private int count = 0;
	
	public Book1(String title, int pages, String author, int count) {
		super();
		this.title = title;
		this.pages = pages;
		this.author = author;
		count++; //å�� ������ ������ å�� ��(count)����
	}
	
	//�� �ʵ忡 ���Ͽ� �����ڿ� ������ �޼ҵ带 �ۼ�
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
	
	//å�� ������ ���ؼ��� ������ �޼ҵ常 Ŭ���� �޼ҵ�� �ۼ� -> set ����
	public int getCount() {
		return count;
	}
}
