// ������ (2016133)
// 2021-11-05
// Lab08 - �ǽ� 6. ��ġ������ ���� ��ġ�ϴ� �ǽ�
import javax.swing.*;
import java.awt.*;

public class StoryTest extends JFrame{
	public StoryTest() {
		setTitle("SM Story"); //Ÿ��Ʋ
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(null); //��ġ������ ����

		JLabel sm = new JLabel("SM Story"); //��
		sm.setLocation(20,20); //��ġ
		sm.setSize(80,20); //ũ��
		
		JLabel fall = new JLabel("������");
		fall.setLocation(80,50);
		fall.setSize(80,20);
		
		JTextField blank = new JTextField(""); //�ؽ�Ʈ�ʵ�
		blank.setLocation(120,80); //��ġ
		blank.setSize(80,20); //ũ��
		
		JLabel is = new JLabel("�̴�");
		is.setLocation(220,100);
		is.setSize(80,20);
		
		c.add(sm); //�����̳ʿ� ����
		c.add(fall);
		c.add(blank);
		c.add(is);
		
		setSize(300,200); //������ ũ�� 
		setVisible(true); //�������� ȭ�鿡 ���
	}
	public static void main(String[] args) {
		new StoryTest();
	}

}
