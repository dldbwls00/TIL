// ������ (2016133)
// 2021-11-26
// Lab11 - �ǽ� 2. DrawLine �ǽ� - ����Ʈ�ҿ� ������ ������ 10�� �׸���
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DrawLineTest2 extends JFrame{
	private MyPanel panel = new MyPanel();
	
	public DrawLineTest2() {
		setTitle("�׷��� �ٰ��� ����"); //Ÿ��Ʋ
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel); //���� ���� ��ȭ��(�ǳ�)�� �⺻���� ����
		setSize(300, 300); //������ ũ��
		setVisible(true); //�������� ȭ�鿡 ���
	}
	class MyPanel extends JPanel{ //���� Ŭ������ �ǳ��� �Ӽ� ǥ��
		public void paintComponent(Graphics g) { //������
			super.paintComponent(g);
			for (int i=0; i<10; i++) { //������ �׸���
				int []x = {getWidth()/2, getWidth()-i*10, getWidth()/2, i*10};
				int []y = {i*10, getHeight()/2, getHeight()-i*10, getHeight()/2};
				g.drawPolygon(x, y, 4);
			}
		}
	}
	public static void main(String[] args) {
		new DrawLineTest2();
	}

}
