// ������ (2016133)
// 2021-10-01
// Lab04 - �ǽ� 3. �߻� Ŭ���� �ǽ� - ����
package prob3;

public class DictionaryApp {

	public static void main(String[] args) {
		Dictionary dic = new Dictionary(10);
		dic.put("�����", "�ڹ�"); 
		dic.put("�̼���", "���̽�"); 
		dic.put("�̼���", "c++"); //�̼����� value ����
		dic.put("�����", "react"); 
		System.out.println("�̼����� ���� "+dic.get("�̼���"));
		System.out.println("������� ���� "+dic.get("�����"));
		dic.delete("�����");
		System.out.println("������� ���� "+dic.get("�����"));
		System.out.println("������� ���� "+dic.get("�����"));
	}

}
