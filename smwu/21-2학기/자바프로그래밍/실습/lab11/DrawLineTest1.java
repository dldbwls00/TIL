// ������ (2016133)
// 2021-11-26
// Lab11 - �ǽ� 2. DrawLine �ǽ� - ����Ʈ���� 10x10���� ������ ���� �׸���
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DrawLineTest1 extends JFrame{
	private MyPanel panel = new MyPanel();
	
	public DrawLineTest1() {
		setTitle("���� �׸���"); //Ÿ��Ʋ
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel); //���� ���� ��ȭ��(�ǳ�)�� �⺻���� ����
		setSize(300, 300); //������ ũ��
		setVisible(true); //�������� ȭ�鿡 ���
	}
	class MyPanel extends JPanel{ //���� Ŭ������ �ǳ��� �Ӽ� ǥ��
		public void paintComponent(Graphics g) { //������
			super.paintComponent(g);
			for (int i=1; i<10; i++) { //���μ�
				int x1 = 0, y1 = getHeight()/10*i, x2 = getWidth(), y2 = getHeight()/10*i;
				g.drawLine(x1, y1, x2, y2);
			}
			for (int i=1; i<10; i++) { //���μ�
				int x1 = getWidth()/10*i, y1 = 0, x2 = getWidth()/10*i, y2 = getHeight();
				g.drawLine(x1, y1, x2, y2);
			}
		}
	}
	public static void main(String[] args) {
		new DrawLineTest1();
	}

}
