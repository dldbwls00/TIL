// ������ (2016133)
// 2021-11-12
// Lab09 - �ǽ� 2. ����
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CalcFrame extends JFrame{
	JTextField tf1 = new JTextField(20);
	JTextField tf2 = new JTextField(20);
	JTextField tf3 = new JTextField(20);
	
	public CalcFrame(){
		setTitle("����"); //Ÿ��Ʋ
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container c = getContentPane();
		c.setLayout(null); //��ġ������ ����
		
		tf1.setLocation(20, 20);
		tf1.setSize(80,20);
		
		JLabel lb1 = new JLabel("X");
		lb1.setLocation(120, 20);
		lb1.setSize(20,20);
		
		tf2.setLocation(150, 20);
		tf2.setSize(80,20);
		
		JButton btn1 = new JButton("=");
		btn1.setLocation(250, 20);
		btn1.setSize(50,20);
		btn1.addActionListener(new MyActionListener()); //������ �ޱ�
	
		tf3.setLocation(320, 20);
		tf3.setSize(80,20);
		
		c.add(tf1); //�����̳ʿ� ����
		c.add(tf2);
		c.add(lb1);
		c.add(tf3);
		c.add(btn1);
	
		setSize(500,100); //������ ũ��
		setVisible(true); //�������� ȭ�鿡 ���
	}
	private class MyActionListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton)e.getSource();
			if (b.getText().equals("=")) { //"="�� ������ ��� 
				tf3.setText(""+Integer.parseInt(tf1.getText())*Integer.parseInt(tf2.getText()));
			}
		}
	}
	public static void main(String[] args) {
		new CalcFrame();
	}
	
}
