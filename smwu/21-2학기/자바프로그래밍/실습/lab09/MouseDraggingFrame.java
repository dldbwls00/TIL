// 이유진 (2016133)
// 2021-11-12
// Lab09 - 실습 5. 드래그 배경색
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MouseDraggingFrame extends JFrame{

	public MouseDraggingFrame () {
		setTitle("드래깅동안 YELLOW"); //타이틀
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
		Container c = getContentPane();
		c.addMouseListener(new MyMouseListener());//리스너 달기
		c.addMouseMotionListener(new MyMouseListener()); 
		c.setBackground(Color.GREEN); //배경색 초록색으로
		
		setSize(300,200); //프레임 크기
		setVisible(true); //프레임을 화면에 출력
	}
	class MyMouseListener implements MouseListener, MouseMotionListener{
		@Override
		public void mouseClicked(MouseEvent e) {
		}
		@Override
		public void mousePressed(MouseEvent e) {
		}
		@Override
		public void mouseReleased(MouseEvent e) { //드래그하지않는경우
			Component c = (Component)e.getSource();
			c.setBackground(Color.GREEN); //배경색 초록색으로
		}
		@Override
		public void mouseEntered(MouseEvent e) {
		}
		@Override
		public void mouseExited(MouseEvent e) {
		}
		@Override
		public void mouseDragged(MouseEvent e) { //드래그할때
			Component c = (Component)e.getSource();
			c.setBackground(Color.YELLOW); //배경색 노란색으로
		}
		@Override
		public void mouseMoved(MouseEvent e) {
		}
	}
	public static void main(String[] args) {
		new MouseDraggingFrame();
	}

}
