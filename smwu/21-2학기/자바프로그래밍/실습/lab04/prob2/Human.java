// ������ (2016133)
// 2021-10-01
// Lab04 - �ǽ� 2. �л� �����
package prob2;

public class Human {
	private String name;
	private int age;
	
	public Human(String name, int age) {//�Ű������� ������ �ʵ带 �ʱ�ȭ
		this.name = name;
		this.age = age;
	}
	
	//�� �ʵ�(�̸�, ����)�� ���Ͽ� �����ڿ� ������ �޼ҵ带 �ۼ�
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() { //��ü�� ���� ������ ���ڿ��� ��ȯ
		return "�̸�: "+name+", ����: "+age;
	}
	
	
}
