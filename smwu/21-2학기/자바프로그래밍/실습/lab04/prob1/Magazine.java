// ������ (2016133)
// 2021-10-01
// Lab04 - �ǽ� 1. Magazine �����
package prob1;

public class Magazine extends Book1{ //Book1�� ���� ����Ŭ����
	private String date; //�߰� �Ӽ�: �߸���

	public Magazine(String title, int pages, String author, int count, String date) { //������
		super(title, pages, author, count); //������ ������ �θ� ������ ȣ��
		this.date = date;
	}

	//�� �ʵ忡 ���Ͽ� ������ �޼ҵ�� ������ �޼ҵ带 �ۼ�
	public String getDate() { //������
		return date;
	}

	public void setDate(String date) { //������
		this.date = date;
	}
}
