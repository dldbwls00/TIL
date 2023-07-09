// 이유진 (2016133)
// 2023-07-09
// Lab0707-2: 컨텐트팬을 10x10으로 나누는 격자 그리기

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DrawLineTest1 extends JFrame{
	
	private MyPanel panel = new MyPanel();
	
	class MyPanel extends JPanel {
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			for (int i = 1; i < 10; i++) { // 가로선
				int x1 = 0, y1 = getHeight() / 10 * i, x2 = getWidth(), y2 = getHeight() / 10 * i;
				g.drawLine(x1, y1, x2, y2);
			}
			for (int i = 1; i < 10; i++) { // 세로선
				int x1 = getWidth() / 10 * i, y1 = 0, x2 = getWidth() / 10 * i, y2 = getHeight();
				g.drawLine(x1, y1, x2, y2);
			}
		}
	}

	public DrawLineTest1() {
		setTitle("격자 그리기");
		setSize(300, 300);

		setContentPane(panel);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new DrawLineTest1();
	}

}
