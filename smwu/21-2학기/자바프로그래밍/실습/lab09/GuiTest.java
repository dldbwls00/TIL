// ������ (2016133)
// 2021-11-12
// Lab09 - �ǽ� 1. GUI �ۼ�
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GuiTest extends JFrame{
	JTextField tf1 = new JTextField(20); //�ؽ�Ʈ
	JTextField tf2 = new JTextField(20);
	JTextField tf3 = new JTextField(20);
	JTextField tf4 = new JTextField(20);
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
		textfields.add(tf1);
		textfields.add(tf2);
		textfields.add(tf3);
		textfields.add(tf4);
		
		JPanel buttons = new JPanel();
		JButton btn1 = new JButton("Ȯ��");//��ư
		JButton btn2 = new JButton("���");
		buttons.add(btn1); 
		buttons.add(btn2);
		btn1.addActionListener(new MyActionListener()); //������ �ޱ�
		btn2.addActionListener(new MyActionListener());
		
		JPanel north = new JPanel(); //���� ����
		north.add(new JLabel(""));
		
		c.add(north, BorderLayout.NORTH); //�����̳ʿ� ����
		c.add(labels, BorderLayout.WEST);
		c.add(textfields, BorderLayout.CENTER);
		c.add(buttons, BorderLayout.SOUTH);
		
		setSize(300,200); //������ ũ��
		setVisible(true); //�������� ȭ�鿡 ���
	}
	private class MyActionListener implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton)e.getSource();
		if (b.getText().equals("Ȯ��")) { //"Ȯ��"�� ������ �ֿܼ� ���
			System.out.println(tf1.getText()+"\t"+tf2.getText()+"\t"+tf3.getText()+"\t"+tf4.getText());
		}
		else { //"���"�� ������ �ʱ�ȭ
			tf1.setText("");
			tf2.setText("");
			tf3.setText("");
			tf4.setText("");
		}
	}
}
	public static void main(String[] args) {
		new GuiTest();
	}

}




