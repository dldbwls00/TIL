// ������ (2016133)
// 2021-11-26
// Lab11 - �ǽ� 3. ���� �׸��� �� ĥ�ϱ�
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DrawFillTest extends JFrame{
	
	public DrawFillTest() {
		setTitle("Draw Fill ��� ����"); //Ÿ��Ʋ
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new GridLayout(0, 3));
		c.add(new MyPanel1());//3���� ����� ���� JPanel�� ���� ���� ����
		c.add(new MyPanel2());
		c.add(new MyPanel3());
		setSize(800, 300); //������ ũ��
		setVisible(true); //�������� ȭ�鿡 ���
	}
	class MyPanel1 extends JPanel{ //����׷��� : fillRect 4��
		public void paintComponent(Graphics g) { //������
			super.paintComponent(g);
			g.setColor(Color.BLACK);
			g.drawRoundRect(20, 20, 220, 220, 40, 40); //�ձ� �簢�� �׵θ�
			
			g.setColor(Color.RED);
			g.drawRect(45, 45, 30, 180); //���� �簢��
			g.fillRect(45, 45, 30, 180); //��ĥ
			g.setColor(Color.BLUE);
			g.drawRect(90, 90, 30, 135); //�Ķ� �簢��
			g.fillRect(90, 90, 30, 135); //��ĥ
			g.setColor(Color.ORANGE);
			g.drawRect(135, 135, 30, 90); //��Ȳ�� �簢��
			g.fillRect(135, 135, 30, 90); //��ĥ
			g.setColor(Color.GREEN);
			g.drawRect(180, 90, 30, 135); //�ʷϻ� �簢��
			g.fillRect(180, 90, 30, 135); //��ĥ
		}
	}
	class MyPanel2 extends JPanel{ //������Ʈ : fillArc 4��
		public void paintComponent(Graphics g) { //������
			super.paintComponent(g);
			g.setColor(Color.BLACK);
			g.drawRoundRect(20, 20, 220, 220, 40, 40); //�ձ� �簢�� �׵θ�
			
			g.setColor(Color.RED);
			g.fillArc(40, 40, 180, 180, 70, 140); //���� ��ȣ ä���
			g.setColor(Color.BLUE);
			g.fillArc(40, 40, 180, 180, 210, 30); //�Ķ� ��ȣ ä���
			g.setColor(Color.YELLOW);
			g.fillArc(40, 40, 180, 180, 240, 80); //��� ��ȣ ä���
			g.setColor(Color.GREEN);
			g.fillArc(40, 40, 180, 180, 320, 110); //�ʷϻ� ��ȣ ä���
		}
	}
	class MyPanel3 extends JPanel{ //�� : fillPolygon, 10 ũ���� x,y �迭
		public void paintComponent(Graphics g) { //������
			super.paintComponent(g);
			g.setColor(Color.BLACK);
			g.drawRoundRect(20, 20, 220, 220, 40, 40); //�ձ� �簢�� �׵θ�
			
			g.setColor(Color.MAGENTA);
			int []x = {230, 155, 130, 105, 30, 90, 70, 130, 190, 170}; //����� �迭
			int []y = {110, 108, 35, 108, 110, 150, 220, 180, 220, 150};
			g.fillPolygon(x, y, 10); //����� �ٰ��� ä���
		}
	}
	public static void main(String[] args) {
		new DrawFillTest();
	}

}
