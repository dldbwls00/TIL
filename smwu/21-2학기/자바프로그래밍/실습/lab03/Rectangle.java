// ������ (2016133)
// 2021-09-24
// Lab03 - �ǽ� 2. ���簢�� ǥ��
public class Rectangle {
	int x, y,  width, height; //int Ÿ���� x, y, width, height �ʵ�: �簢���� �����ϴ� ���� ũ�� ����
	
	public Rectangle(int x, int y, int width, int height) {// x, y, width, height ���� �Ű� ������ �޾� �ʵ带 �ʱ�ȭ�ϴ� ������
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public int square() {//�簢�� ���� ����
		return width * height;
	}
	
	public void show() {//�簢���� ��ǥ�� ���̸� ȭ�鿡 ���
		System.out.println("(" + x + "," + y + ")���� ũ�Ⱑ " + width + "x" + height + "�� �簢��");
	}
	
	public boolean contains(Rectangle r) {//�Ű������� ���� r�� �� �簢�� �ȿ� ������ true ����
		if (this.x < r.x && r.x < this.x+this.width //����: r�� ����������� �����ϴ����� ��� �� �簢�� �ȿ� �־����
				&& this.y < r.y && r.y < this.y+this.height
				&& r.x+r.width < this.x+this.width
				&& r.y+r.height< this.y+this.height)	return true;
		return false;
	}
	
	public static void main(String[] args) {
		Rectangle r = new Rectangle(2, 2, 8, 7); //��ü ����
		Rectangle s = new Rectangle(5, 5, 6, 6);
		Rectangle t = new Rectangle(1, 1, 10, 10);
		
		r.show(); //�޼��� ȣ��
		System.out.println("s�� ������ " + s.square());
		if (t.contains(r))	System.out.println("t�� r�� �����մϴ�.");
		if (t.contains(s))	System.out.println("t�� s�� �����մϴ�.");
	}

}
