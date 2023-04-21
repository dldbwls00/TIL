// 이유진 (2016133)
// 2021-11-26
// Lab11 - 실습 4. 마우스로 원 그리기
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

class Circle{
	double x, y, w, h;
	public Circle(double x, double y, double w, double h) { //생성자 초기화
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}
	public double getX() {return x;} //접근자
	public double getY() {return y;}
	public double getW() {return w;}
	public double getH() {return h;}
}
public class MouseCircle extends JFrame{
	public MouseCircle() {
		setTitle("마우스로 원 그리기"); //타이틀
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(new MyPanel()); //내가 만든 도화지(판넬)을 기본으로 설정
		setSize(1000, 600); //프레임 크기
		setVisible(true); //프레임을 화면에 출력
	}
	
	class MyPanel extends JPanel{
		private Vector<Circle> vCircle = new Vector<Circle>(); //Circle을 담는 배열
		double sx, sy, ex, ey; //좌표
		double x, y; //원그리기 시작점
		double w, h, r; //원그리기 너비와 높이, 반지름
		public MyPanel() {
			addMouseListener(new MouseAdapter() { //익명클래스로 작성
				public void mousePressed(MouseEvent e) { //마우스 눌렀을 때
					Point startP = e.getPoint(); 
					sx = startP.getX(); //중심좌표 저장
					sy = startP.getY();
				}
				public void mouseReleased(MouseEvent e) { //마우스 뗐을 때
					Point endP = e.getPoint();
					ex = endP.getX(); //좌표 저장
					ey = endP.getY();

					r = Math.sqrt(Math.pow(ex-sx,2) + Math.pow(ey-sy,2)); //반지름
					x = sx - r; //원그리기 시작 좌표
					y = sy - r;
					w = h = 2*r;
					
					Circle circle = new Circle(x, y, w, h); //Circle객체 생성
					vCircle.add(circle);// 벡터에 저장
					repaint(); //새로 그리면 기존의 것이 사라지므로 모든 것을 처음부터 다시 그림
				}});
		}
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.MAGENTA);
		
			for (int i=0; i<vCircle.size(); i++) {
				int x = (int)vCircle.elementAt(i).getX(); //벡터로부터 Circle객체 읽어오기
				int y = (int)vCircle.elementAt(i).getY();
				int w = (int)vCircle.elementAt(i).getW();
				int h = (int)vCircle.elementAt(i).getH();
				g.drawOval(x, y, w, h); //원그리기
			}
		}
	}
	public static void main(String[] args) {
		new MouseCircle();
	}
}
