// ������ (2016133)
// 2021-11-05
// Lab08 - �ǽ� 1. Border Layout ����
import javax.swing.*;
import java.awt.*;

public class BorderLayoutTest extends JFrame {
	public BorderLayoutTest() {
		setTitle("BorderLayout Practice"); //Ÿ��Ʋ
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new BorderLayout(5,7)); //���� �����
		c.add(new JButton("Center"), BorderLayout.CENTER);
		c.add(new JButton("North"), BorderLayout.NORTH);
		c.add(new JButton("South"), BorderLayout.SOUTH);
		c.add(new JButton("East"), BorderLayout.EAST);
		c.add(new JButton("West"), BorderLayout.WEST);
		
		setSize(400, 200); //������ ũ�� 400x200
		setVisible(true); //�������� ȭ�鿡 ���
	}
	
	public static void main(String[] args) {
		new BorderLayoutTest();
	}

}
