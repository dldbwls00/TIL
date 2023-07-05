//이유진 (2016133)
//2023-07-05 
//Lab0705-4: 배경색이 초록색에서 드래깅하는 동안만 노란색으로 바뀌는 프로그램
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MouseDraggingFrame extends JFrame {

	public MouseDraggingFrame() {
		setTitle("드래깅동안 YELLOW"); // 타이틀
		setSize(300, 200);

		JPanel panel = new JPanel();
		panel.addMouseListener(new MyMouseListener());// 리스너 달기
		panel.addMouseMotionListener(new MyMouseListener());
		panel.setBackground(Color.GREEN); // 배경색 초록색으로
		
		add(panel);
		setVisible(true); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	class MyMouseListener implements MouseListener, MouseMotionListener {
		@Override
		public void mouseClicked(MouseEvent e) {
		}

		@Override
		public void mousePressed(MouseEvent e) {
		}

		@Override
		public void mouseReleased(MouseEvent e) { // 드래그 하지 않는 경우
			JPanel panel = (JPanel) e.getSource();
			panel.setBackground(Color.GREEN); // 배경색 초록색으로
		}

		@Override
		public void mouseEntered(MouseEvent e) {
		}

		@Override
		public void mouseExited(MouseEvent e) {
		}

		@Override
		public void mouseDragged(MouseEvent e) { // 드래그 할 때
			JPanel panel = (JPanel) e.getSource();
			panel.setBackground(Color.YELLOW); // 배경색 노란색으로
		}

		@Override
		public void mouseMoved(MouseEvent e) {
		}
	}

	public static void main(String[] args) {
		new MouseDraggingFrame();
	}

}
