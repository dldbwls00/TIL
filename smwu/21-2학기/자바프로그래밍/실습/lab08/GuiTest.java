// ������ (2016133)
// 2021-11-05
// Lab08 - �ǽ� 4. JLabel ���� ����
import javax.swing.*;
import java.awt.*;

public class GuiTest extends JFrame{
	public GuiTest() {
		setTitle("GUI TEST"); //Ÿ��Ʋ
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		
		JPanel labels = new JPanel(); //���� ��
		labels.setLayout(new GridLayout(4,1)); //�׸��� ���̾ƿ�
		labels.add(new JLabel("�� ��"));
		labels.add(new JLabel("�� ��"));
		labels.add(new JLabel("�� ��"));
		labels.add(new JLabel("����ó"));
		
		JPanel textfields = new JPanel(); //�ؽ�Ʈ�ʵ�
		textfields.setLayout(new GridLayout(4,1));
		for (int i=0; i<4; i++)
			textfields.add(new JTextField(20));
		
		JPanel buttons = new JPanel(); //��ư
		buttons.add(new JButton("Ȯ��"));
		buttons.add(new JButton("���"));
		
		JPanel north = new JPanel(); //���� ����
		north.add(new JLabel(""));
		
		c.add(north, BorderLayout.NORTH); //�����̳ʿ� ����
		c.add(labels, BorderLayout.WEST);
		c.add(textfields, BorderLayout.CENTER);
		c.add(buttons, BorderLayout.SOUTH);
		
		setSize(300,200); //������ ũ��
		setVisible(true); //�������� ȭ�鿡 ���
	}
	public static void main(String[] args) {
		new GuiTest();
	}

}
