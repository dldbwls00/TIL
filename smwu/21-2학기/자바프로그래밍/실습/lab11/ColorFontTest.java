// ������ (2016133)
// 2021-11-26
// Lab11 - �ǽ� 1. Color, Font �ǽ�
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ColorFontTest extends JFrame{
	private MyPanel panel = new MyPanel();
	
	public ColorFontTest() {
		setTitle("Color, Font ��� ����"); //Ÿ��Ʋ
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel); //���� ���� ��ȭ��(�ǳ�)�� �⺻���� ����
		setSize(600, 250); //������ ũ��
		setVisible(true); //�������� ȭ�鿡 ���
	}
	class MyPanel extends JPanel{ //���� Ŭ������ �ǳ��� �Ӽ� ǥ��
		public void paintComponent(Graphics g) { //������
			super.paintComponent(g);
			g.setColor(Color.BLUE); //�÷� ����
			g.setFont(new Font("�ü�", Font.BOLD, 25)); //��Ʈ ����
			g.drawString("����: ���ѹα�(�ü� ��Ʈ)", 30, 50); //���ڿ� �ۼ�
			
			g.setColor(Color.RED);
			g.setFont(new Font("�������üB", Font.ITALIC, 30));
			g.drawString("�ּ�: ����� ������(�������üB ��Ʈ)", 30, 100);
			
			g.setColor(Color.ORANGE);
			g.setFont(new Font("�޸ո���ü", Font.ITALIC, 45));
			g.drawString("����: ȫ�浿(�޸ո���ü ��Ʈ)", 30, 150);
			
			g.setColor(Color.BLACK);
			g.setFont(new Font("HY����B", Font.PLAIN, 17));
			g.drawString("�й�: 2016133(HY����B ��Ʈ)", 30, 200);
		}
	}
	
	public static void main(String[] args) {
		new ColorFontTest();
	}

}
