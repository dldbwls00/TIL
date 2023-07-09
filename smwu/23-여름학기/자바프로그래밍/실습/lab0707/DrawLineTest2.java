// 이유진 (2016133)
// 2023-07-09
// Lab0707-2: 컨텐트팬에 꽉차는 마름모 10개 그리기

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DrawLineTest2 extends JFrame {

	private MyPanel panel = new MyPanel();

	class MyPanel extends JPanel {
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			for (int i = 0; i < 10; i++) { // 마름모 그리기
				int[] x = { getWidth() / 2, getWidth() - i * 10, getWidth() / 2, i * 10 };
				int[] y = { i * 10, getHeight() / 2, getHeight() - i * 10, getHeight() / 2 };
				g.drawPolygon(x, y, 4);
			}
		}
	}

	public DrawLineTest2() {
		setTitle("그래픽 다각형 연습");
		setSize(300, 300);

		setContentPane(panel);

		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new DrawLineTest2();
	}

}