// ������ (2016133)
// 2021-10-01
// Lab04 - �ǽ� 2. �л� �����
package prob2;

public class Student extends Human{ //Human Ŭ������ ���
	private String major; //�߰� �Ӽ�: ����
	private int sID; //�߰� �Ӽ�: �й�
	
	public Student(String name, int age, String major, int sID) { //������
		//�Ű������� �̸�, ����, ����, �й��� �޾ƿͼ� �ʱ�ȭ
		super(name, age); //�θ� Ŭ������ ������ ȣ�� (�̸�, ����)
		this.major = major; //�Ű������� �޾ƿ� ������ ��� ������ ������ �й��� �ʱ�ȭ
		this.sID = sID;
	}
	
	//�ʵ�(����)�� ���Ͽ� �����ڿ� ������ �޼ҵ带 �ۼ�
	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	@Override
	public String toString() {
		//�θ��� toString()�� ȣ���Ͽ� �޾ƿ� ���ڿ� ���� �߰��� ���� �� �����Ͽ� ���ڿ� ��ȯ
		return "[�л� ����]�̸�: "+super.getName()+", ����: "+super.getAge()+", ����: "+major+", �й�: "+sID+"]";
	}
}
