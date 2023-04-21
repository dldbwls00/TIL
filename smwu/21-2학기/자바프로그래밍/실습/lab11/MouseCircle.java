// ������ (2016133)
// 2021-11-26
// Lab11 - �ǽ� 4. ���콺�� �� �׸���
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

class Circle{
	double x, y, w, h;
	public Circle(double x, double y, double w, double h) { //������ �ʱ�ȭ
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}
	public double getX() {return x;} //������
	public double getY() {return y;}
	public double getW() {return w;}
	public double getH() {return h;}
}
public class MouseCircle extends JFrame{
	public MouseCircle() {
		setTitle("���콺�� �� �׸���"); //Ÿ��Ʋ
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(new MyPanel()); //���� ���� ��ȭ��(�ǳ�)�� �⺻���� ����
		setSize(1000, 600); //������ ũ��
		setVisible(true); //�������� ȭ�鿡 ���
	}
	
	class MyPanel extends JPanel{
		private Vector<Circle> vCircle = new Vector<Circle>(); //Circle�� ��� �迭
		double sx, sy, ex, ey; //��ǥ
		double x, y; //���׸��� ������
		double w, h, r; //���׸��� �ʺ�� ����, ������
		public MyPanel() {
			addMouseListener(new MouseAdapter() { //�͸�Ŭ������ �ۼ�
				public void mousePressed(MouseEvent e) { //���콺 ������ ��
					Point startP = e.getPoint(); 
					sx = startP.getX(); //�߽���ǥ ����
					sy = startP.getY();
				}
				public void mouseReleased(MouseEvent e) { //���콺 ���� ��
					Point endP = e.getPoint();
					ex = endP.getX(); //��ǥ ����
					ey = endP.getY();

					r = Math.sqrt(Math.pow(ex-sx,2) + Math.pow(ey-sy,2)); //������
					x = sx - r; //���׸��� ���� ��ǥ
					y = sy - r;
					w = h = 2*r;
					
					Circle circle = new Circle(x, y, w, h); //Circle��ü ����
					vCircle.add(circle);// ���Ϳ� ����
					repaint(); //���� �׸��� ������ ���� ������Ƿ� ��� ���� ó������ �ٽ� �׸�
				}});
		}
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.MAGENTA);
		
			for (int i=0; i<vCircle.size(); i++) {
				int x = (int)vCircle.elementAt(i).getX(); //���ͷκ��� Circle��ü �о����
				int y = (int)vCircle.elementAt(i).getY();
				int w = (int)vCircle.elementAt(i).getW();
				int h = (int)vCircle.elementAt(i).getH();
				g.drawOval(x, y, w, h); //���׸���
			}
		}
	}
	public static void main(String[] args) {
		new MouseCircle();
	}
}
