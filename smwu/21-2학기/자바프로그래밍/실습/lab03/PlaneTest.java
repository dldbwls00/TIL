// ������ (2016133)
// 2021-09-24
// Lab03 - �ǽ� 6. �����
class Plane{
	private String model;//�ʿ��� ��� ����(�ʵ�) ����
	private int seats;
	static int planes; //���� ����
	
	public Plane() {//������ �ۼ�: ���� �� �ߺ� ����
		planes++;
	}
	public Plane(String model) {
		this.model = model;
		planes++;
	}
	public Plane(String model, int seats) {
		this.model = model;
		this.seats = seats;
		planes++;
	}
	public Plane(int seats) {
		this.seats = seats;
		planes++;
	}
	
	//��� ������ ������ �� �ִ� ������(getXXX)�� ������ �޼ҵ�(setXXX) �ۼ�
	public String getModel() { //������
		return model;
	}
	public int getSeats() { //������
		return seats;
	}
	public void setModel(String model) { //������
		this.model = model;
	}
	public void setSeats(int seats) { //������
		this.seats = seats;
	}

	public int getPlanes() {//���� ���� ������ �� �ִ� ������ �޼ҵ� getPlanes() �ۼ�
		return planes;
	}
	
	public String toString(){ //��ü�� ������ ���ڿ��� ��ȯ�ϴ� toString �޼ҵ� �ۼ�
		return "Plane [model = "+model+", seats = "+seats+"]";//�������̵��ؾߵ�
	}
}
public class PlaneTest {

	public static void main(String[] args) {
		Plane p1, p2, p3, p4; //Plane ��ü ���� �� ����
		p1 = new Plane();
		p1.setModel("���� 777");
		p1.setSeats(200);
		p2 = new Plane("���� 747");
		p2.setSeats(400);
		p3 = new Plane("������� A380", 500);
		p4 = new Plane(120);
		p4.setModel("���� 737");
		
		System.out.println("��ü ���� ����� ��: "+p1.getPlanes());//��ü ���� ����� �� ���
		
		//����� ���� ���
		System.out.println("==============��ü ����� ���==============");
		System.out.println(p1); //���������� toString �޼ҵ尡 ȣ���
		System.out.println(p2);
		System.out.println("Plane [model = " + p3.getModel() + ", seats = " + p3.getSeats() + "]");
		System.out.println(p4);
	}

}
