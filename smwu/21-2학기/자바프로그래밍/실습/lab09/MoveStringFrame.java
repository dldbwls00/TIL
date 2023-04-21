// ������ (2016133)
// 2021-11-12
// Lab09 - �ǽ� 6. �ؽ�Ʈ ȸ��
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MoveStringFrame extends JFrame{
	JLabel la = new JLabel("Love Java");
	String s = "Love Java";
	public MoveStringFrame() {
		setTitle("LeftŰ�� ���ڿ� ȸ���ϱ�"); //Ÿ��Ʋ
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		c.addKeyListener(new MyKeyListener());
		c.add(la);
		
		setSize(300,200); //������ ũ��
		setVisible(true); //�������� ȭ�鿡 ���
		c.setFocusable(true);
		c.requestFocus();
	}
	class MyKeyListener	extends KeyAdapter{
		public void keyPressed(KeyEvent e) {
			String first = s.substring(0,1);
			String last = s.substring(1);
			if (e.getKeyCode() == KeyEvent.VK_LEFT) { //<Left>Ű�� �Է��� ������
				s = last + first;
				la.setText(s);
			}
		}
	}
	public static void main(String[] args) {
		new MoveStringFrame();
	}

}
