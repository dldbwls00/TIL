// ������ (2016133)
// 2021-12-03
// Lab12 - �ǽ� 2. Ÿ�� �׸���
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ThreadEx extends JFrame {
	private mythread th;
	private mypanel panel = new mypanel();

	public ThreadEx() {
		setTitle("Make Drawing"); //Ÿ��Ʋ
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);
		setSize(500, 500);
		setVisible(true);
		
		th = new mythread(panel);
		th.start();

		addMouseListener(new MouseAdapter() { //�͸�����
			public void mouseEntered(MouseEvent e) {
				th.setFlag(true);
				th.play();
				setTitle("Make Drawing to Start");
			}
			public void mouseExited(MouseEvent e) {
				th.setFlag(false);
				setTitle("Make Drawing to Pause");
		}});
	}

	public static void main(String[] args) {
		new ThreadEx();
	}
}
class mythread extends Thread {//������ : �׸��׸��� �۾�
	mypanel panel;
	private boolean flag;

	public mythread(mypanel panel) {
		this.panel = panel;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	synchronized public void play() {
		notify();
	}
	public void run() {
		try { 
			synchronized (this) {
				wait();
			}
		} catch (InterruptedException ex) {
			return;
		}
		while (true) {
			try {
				if (flag) {
					panel.repaint();
					panel.randomOval();
				}
				Thread.sleep(300); //0.3�� ����
			} catch (InterruptedException e) {
				return;
			}
		}
	}
}

class mypanel extends JPanel {
	private int x, y, w, h;
	public void randomOval() { //�����ϰ� Ÿ���� �׸��� �޼���
		x = (int) (Math.random() * (getWidth() - getWidth() / 2));
		y = (int) (Math.random() * (getHeight() - getHeight() / 2));
		w = (int) (Math.random() * 300);
		h = (int) (Math.random() * 300);
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		randomOval();//�����ϰ� Ÿ���� �׸��� �޼���
		g.setColor(Color.MAGENTA); //���󺯰�
		g.fillOval(x, y, w, h); //Ÿ�� �׸���
	}
}