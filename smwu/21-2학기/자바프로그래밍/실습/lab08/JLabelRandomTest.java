// ������ (2016133)
// 2021-11-05
// Lab08 - �ǽ� 3. JLabel ���� ����
import javax.swing.*;
import java.awt.*;

public class JLabelRandomTest extends JFrame{
	public JLabelRandomTest() {
		setTitle("Random Labels");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(null); //������ ��ġ�̹Ƿ� ��ġ������ ���� 
		for (int i=0; i<20; i++) {
			JLabel label = new JLabel(); //�� ����
			
			int x = (int)(Math.random()*200) + 50; //��ġ �����ϰ�
			int y = (int)(Math.random()*200) + 50;
			label.setLocation(x,y);
			label.setSize(10,10);
			
			label.setBackground(Color.blue);//���� ����
			label.setOpaque(true);
			
			c.add(label); //����
		}
		setSize(300,300); //������ ũ�� 
		setVisible(true); //�������� ȭ�鿡 ���
	}
	
	public static void main(String[] args) {
		new JLabelRandomTest();
	}

}
