// ������ (2016133)
// 2021-11-12
// Lab09 - �ǽ� 4. Ŭ�� ������ ���� ���α׷�
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ClickPracticeFrame extends JFrame{

	public ClickPracticeFrame() {
		setTitle("Ŭ�� ������ ���� ���α׷�"); //Ÿ��Ʋ
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(null); //��ġ������ ����
		JLabel la = new JLabel("C");
		la.setLocation(100, 100); //�ʱ� ��ġ ����
		la.setSize(10, 10);
		c.add(la);
		
		la.addMouseListener(new MouseAdapter() { //�͸� Ŭ������ ����� ����
			public void mouseClicked(MouseEvent e) {
				int x = (int)(Math.random()*getWidth()); //��ġ �����ϰ�, â ���� ������
				int y = (int)(Math.random()*getHeight());
				la.setLocation(x,y);
			}
		});
		setSize(300,300); //������ ũ��
		setVisible(true); //�������� ȭ�鿡 ���
	}
	public static void main(String[] args) {
		new ClickPracticeFrame();
	}

}
