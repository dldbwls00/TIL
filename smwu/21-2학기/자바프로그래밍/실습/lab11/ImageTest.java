// ������ (2016133)
// 2021-11-26
// Lab11 - �ǽ� 5. �̹��� �׸���
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ImageTest extends JFrame{
	private MyPanel panel = new MyPanel();
	
	public ImageTest() {
		setTitle("�׷��� �̹��� ����"); //Ÿ��Ʋ
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel); //���� ���� ��ȭ��(�ǳ�)�� �⺻���� ����
		setSize(300, 300); //������ ũ��
		setVisible(true); //�������� ȭ�鿡 ���
	}
	class MyPanel extends JPanel{//���� Ŭ������ �ǳ��� �Ӽ� ǥ��
		private ImageIcon icon = new ImageIcon("back.jpg"); //�̹��� �ҷ�����
		private Image img = icon.getImage();
		public void paintComponent(Graphics g) { //������
			super.paintComponent(g);
			//�̹����� getWidth, getHeight�� �Ű������� �� image observer�� this�� ����
			g.drawImage(img, 0, 0, getWidth()/2-5, getHeight()/2-5, //���� ��
					0, 0, img.getWidth(this)/2, img.getHeight(this)/2, this);
			g.drawImage(img, getWidth()/2+5, 0, getWidth(), getHeight()/2-5, //������ ��
					img.getWidth(this)/2, 0, img.getWidth(this), img.getHeight(this)/2, this);
			g.drawImage(img, 0, getHeight()/2+5, getWidth()/2-5, getHeight(), //���� �Ʒ�
					0, img.getHeight(this)/2, img.getWidth(this)/2, img.getHeight(this), this);
			g.drawImage(img, getWidth()/2+5, getHeight()/2+5, getWidth(), getHeight(), //������ �Ʒ�
					img.getWidth(this)/2, img.getHeight(this)/2, img.getWidth(this), img.getHeight(this), this);
		}	
	}
	public static void main(String[] args) {
		new ImageTest();
	}

}
