// ������ (2016133)
// 2021-11-12
// Lab09 - �ǽ� 5. �巡�� ����
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MouseDraggingFrame extends JFrame{

	public MouseDraggingFrame () {
		setTitle("�巡�뵿�� YELLOW"); //Ÿ��Ʋ
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
		Container c = getContentPane();
		c.addMouseListener(new MyMouseListener());//������ �ޱ�
		c.addMouseMotionListener(new MyMouseListener()); 
		c.setBackground(Color.GREEN); //���� �ʷϻ�����
		
		setSize(300,200); //������ ũ��
		setVisible(true); //�������� ȭ�鿡 ���
	}
	class MyMouseListener implements MouseListener, MouseMotionListener{
		@Override
		public void mouseClicked(MouseEvent e) {
		}
		@Override
		public void mousePressed(MouseEvent e) {
		}
		@Override
		public void mouseReleased(MouseEvent e) { //�巡�������ʴ°��
			Component c = (Component)e.getSource();
			c.setBackground(Color.GREEN); //���� �ʷϻ�����
		}
		@Override
		public void mouseEntered(MouseEvent e) {
		}
		@Override
		public void mouseExited(MouseEvent e) {
		}
		@Override
		public void mouseDragged(MouseEvent e) { //�巡���Ҷ�
			Component c = (Component)e.getSource();
			c.setBackground(Color.YELLOW); //���� ���������
		}
		@Override
		public void mouseMoved(MouseEvent e) {
		}
	}
	public static void main(String[] args) {
		new MouseDraggingFrame();
	}

}
