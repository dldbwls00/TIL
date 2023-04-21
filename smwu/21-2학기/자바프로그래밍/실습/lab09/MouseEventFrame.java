// ������ (2016133)
// 2021-11-12
// Lab09 - �ǽ� 3. ���콺�̺�Ʈ Love Java ���
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MouseEventFrame extends JFrame{
	JLabel la = new JLabel("Love Java");
	public MouseEventFrame() {
		setTitle("���콺 �ø��� ������"); //Ÿ��Ʋ
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		c.add(la);
		la.addMouseListener(new MouseAdapter() { // �͸� Ŭ������ ����� �ۼ�
			public void mouseEntered(MouseEvent e) { //���콺 �ø� ��
				la.setText("�����");
			}
			public void mouseExited(MouseEvent e) { //���콺 ���� ��
				la.setText("Love Java");
			}});
		setSize(300,200); //������ ũ��
		setVisible(true); //�������� ȭ�鿡 ���
	}
	
	public static void main(String[] args) {
		new MouseEventFrame();
	}
}
