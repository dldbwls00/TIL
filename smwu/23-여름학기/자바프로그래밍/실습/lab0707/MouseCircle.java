// 이유진 (2016133)
// 2023-07-09
// Lab0707-4: 마우스로 원 그리기 - 마우스로 중심을 찍어 드래깅하여 놓으면 원을 그리는 프로그램

import java.awt.*;
import java.awt.event.*;
import java.util.*; //ArrayList
import javax.swing.*;


public class MouseCircle extends JFrame {
	double x, y, w, h; // 원이 외접하는 정사각형의 시작점, width, height
	double cx, cy; // mouse pressed point -> 원그리기 시작점
	double dx, dy; // mouse released point
	double radius;

	class Circle {
		double cx, cy, radius; //중심점(cx, cy), radius

		public Circle(double cx, double cy, double radius) {
			super();
			this.cx = cx;
			this.cy = cy;
			this.radius = radius;
		}

		public double getCx() {
			return cx;
		}

		public void setCx(double cx) {
			this.cx = cx;
		}

		public double getCy() {
			return cy;
		}

		public void setCy(double cy) {
			this.cy = cy;
		}

		public double getRadius() {
			return radius;
		}

		public void setRadius(double radius) {
			this.radius = radius;
		}

	}

	ArrayList<Circle> circleList = new ArrayList<>(); // 원을 담는 ArrayList

	class MyPanel extends JPanel {
		class MyListener extends MouseAdapter{
			@Override
			public void mousePressed(MouseEvent e) { // 마우스가 눌러질 때 cx, cy 좌표 저장
				cx = e.getX();
				cy = e.getY();
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				dx = e.getX(); // 마우스가 떼질 때 dx, dy 좌표 저장
				dy = e.getY();
				calc();
				circleList.add(new Circle(x, y, radius)); // ArrayList에 Circle 객체를 만들어 넣음
				repaint();
			}

			@Override
			public void mouseDragged(MouseEvent e) {
				dx = e.getX(); // 마우스가 떼질 때 dx, dy 좌표 저장
				dy = e.getY();
				calc();
				repaint();
			}

			void calc() { // 두 좌표로 radius 계산
				radius = Math.sqrt(Math.pow(dx - cx, 2) + Math.pow(dy - cy, 2)); // 반지름

				x = cx - radius; // 원 그리기 시작 좌표 저장(원이 외접하는 정사각형의 좌상단점)
				y = cy - radius;
				w = h = radius * 2;
			}
		}
		public MyPanel() {
			MyListener ml = new MyListener();
			addMouseListener(ml);
			addMouseMotionListener(ml); //mouseDragged
		}

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);

			g.setColor(Color.magenta);
			for (Circle c : circleList) // 누적해서 그림
				g.drawOval((int) c.cx, (int) c.cy, (int) c.radius * 2, (int) c.radius * 2);

			g.drawOval((int) x, (int) y, (int) w, (int) h); // 현재 drag 중인 도형에 대해
		}
	}

	public MouseCircle() {
		setTitle("마우스로 원 그리기");
		setSize(1000, 600);

		add(new MyPanel());

		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new MouseCircle();
	}
}