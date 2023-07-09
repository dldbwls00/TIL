// 이유진 (2016133)
// 2023-07-09
// Lab0707-3: 도형 그리기, 칠하기 - 막대그래프, 파이차트, 별모양

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DrawFillTest extends JFrame {

	class MyPanel1 extends JPanel { // 막대그래프 : fillRect 4개
		public void paintComponent(Graphics g) {
			super.paintComponent(g);

			g.setColor(Color.BLACK);
			g.drawRoundRect(20, 20, 220, 220, 40, 40); // 둥근 사각형 테두리

			g.setColor(Color.RED);
			g.drawRect(45, 45, 30, 180); // 빨간 사각형
			g.fillRect(45, 45, 30, 180);

			g.setColor(Color.BLUE);
			g.drawRect(90, 90, 30, 135); // 파란 사각형
			g.fillRect(90, 90, 30, 135);

			g.setColor(Color.ORANGE);
			g.drawRect(135, 135, 30, 90); // 주황색 사각형
			g.fillRect(135, 135, 30, 90);
			g.setColor(Color.GREEN);

			g.drawRect(180, 90, 30, 135); // 초록색 사각형
			g.fillRect(180, 90, 30, 135);
		}
	}

	class MyPanel2 extends JPanel { // 파이차트 : fillArc 4개
		public void paintComponent(Graphics g) {
			super.paintComponent(g);

			g.setColor(Color.BLACK);
			g.drawRoundRect(20, 20, 220, 220, 40, 40); // 둥근 사각형 테두리

			g.setColor(Color.RED);
			g.fillArc(40, 40, 180, 180, 70, 140); // 빨간 원호

			g.setColor(Color.BLUE);
			g.fillArc(40, 40, 180, 180, 210, 30); // 파란 원호

			g.setColor(Color.YELLOW);
			g.fillArc(40, 40, 180, 180, 240, 80); // 노란 원호

			g.setColor(Color.GREEN);
			g.fillArc(40, 40, 180, 180, 320, 110); // 초록색 원호
		}
	}

	class MyPanel3 extends JPanel { // 별 : fillPolygon, 10 크기의 x,y 배열
		public void paintComponent(Graphics g) {
			super.paintComponent(g);

			g.setColor(Color.BLACK);
			g.drawRoundRect(20, 20, 220, 220, 40, 40); // 둥근 사각형 테두리

			g.setColor(Color.MAGENTA);
			int[] x = { 230, 155, 130, 105, 30, 90, 70, 130, 190, 170 }; // 별 배열
			int[] y = { 110, 108, 35, 108, 110, 150, 220, 180, 220, 150 };
			g.fillPolygon(x, y, 10); // 별
		}
	}

	public DrawFillTest() {
		setTitle("Draw Fill 사용 예제"); // 타이틀
		setSize(800, 300); // 프레임 크기
		setLayout(new GridLayout(0, 3));

		add(new MyPanel1());// 3개의 사용자 정의 JPanel을 각각 따로 생성
		add(new MyPanel2());
		add(new MyPanel3());

		setVisible(true); // 프레임을 화면에 출력
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new DrawFillTest();
	}

}
