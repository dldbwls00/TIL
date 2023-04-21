// ������ (2016133)
// 2021-11-05
// Lab08 - �ǽ� 5. ��ġ ������ ȥ�� ��� �ǽ�
import javax.swing.*;
import java.awt.*;

public class GridTest extends JFrame{
	public GridTest() {
		setTitle("Ten Buttons Frame"); //Ÿ��Ʋ
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		
		JPanel title = new JPanel(); //����
		title.add(new JLabel("�л� ���� �Է�"));
		
		JPanel info = new JPanel(); //����
		GridLayout grid = new GridLayout(5, 4); 
		grid.setVgap(2); //�� ����
		info.setLayout(grid);
		info.add(new JLabel("�̸�"));
		info.add(new JLabel("�й�"));
		info.add(new JLabel("�а�"));
		info.add(new JLabel("����ó"));
		for (int i=0; i<16; i++)
			info.add(new JTextField(""));
		
		JPanel buttons = new JPanel(); //��ư
		buttons.add(new JButton("�߰�"));
		buttons.add(new JButton("���"));
		
		c.add(title, BorderLayout.NORTH); //�����̳ʿ� ����
		c.add(info, BorderLayout.CENTER);
		c.add(buttons, BorderLayout.SOUTH);
		
		setSize(300,200); //������ ũ��
		setVisible(true); //�������� ȭ�鿡 ���
	}
	public static void main(String[] args) {
		new GridTest();
	}

}
