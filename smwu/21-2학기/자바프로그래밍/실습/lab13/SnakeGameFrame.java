import java.awt.*;
import java.awt.event.*;
import java.util.Vector;
import javax.swing.*;

public class SnakeGameFrame extends JFrame {
	private Thread snakeThread;
	private GroundPanel p;
	public SnakeGameFrame() {
		super("������ũ �����̱�");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		p = new GroundPanel();
		setContentPane(p);
		setSize(400,400);
		setVisible(true);
		
		p.setFocusable(true);
		p.requestFocus();
		
		snakeThread = new Thread(p);
		snakeThread.start();
	}

	class GroundPanel extends JPanel implements Runnable{
		private static final int LEFT = 0;
		private static final int RIGHT = 1;
		private static final int UP = 2;
		private static final int DOWN = 3;
		private int direction;
		private Image img;
		private SnakeBody snakeBody;
		private final int delay = 200;
		
		public GroundPanel() {
			setLayout(null);
			snakeBody = new SnakeBody();
			snakeBody.addIn(this);
			direction = LEFT;
			this.addKeyListener(new MyKeyListener());
			ImageIcon icon = new ImageIcon("images/bg.jpg");
			img = icon.getImage();
			
			this.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					GroundPanel.this.requestFocus(); // ���콺�� Ŭ���ϸ� �ڵ����� ��Ŀ���� ������ ��
				}
			});
		}
		
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(img, 0,0,getWidth(), getHeight(), null);
		}
		
		@Override
		public void run() {
			while(true) {
				try {
					Thread.sleep(delay);				
					snakeBody.move(direction);
				}catch(InterruptedException e) {
					return;
				}
			}
		}
				
		class MyKeyListener extends KeyAdapter {
			@Override
			public void keyPressed(KeyEvent e) {
				switch(e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					direction = LEFT;
					break;
				case KeyEvent.VK_RIGHT:
					direction = RIGHT;
					break;
				case KeyEvent.VK_UP:
					direction = UP;
					break;
				case KeyEvent.VK_DOWN:
					direction = DOWN;
					break;
				}
			}
		}
	}
	
	class SnakeBody {
		private Vector<JLabel> v = new Vector<JLabel>();
		
		public SnakeBody() {
			ImageIcon head = new ImageIcon("images/head.jpg");
			JLabel la = new JLabel(head);
			la.setSize(head.getIconWidth(), head.getIconHeight());
			la.setLocation(100, 100);
			v.add(la);

			ImageIcon body = new ImageIcon("images/body.jpg");		
			for(int i=1; i<10; i++) {
				la = new JLabel(body);
				la.setSize(body.getIconWidth(), body.getIconHeight());
				la.setLocation(100+i*20, 100);
				v.add(la);
			}
		}
		
		public void addIn(JPanel p) {
			for(int i=0; i<v.size(); i++)
				p.add(v.get(i));
		}
		
		public void move(int direction) {
			for(int i=v.size()-1; i>0; i--) {
				JLabel b = v.get(i);
				JLabel a = v.get(i-1);
				b.setLocation(a.getX(), a.getY());
			}
			JLabel head = v.get(0);
			switch(direction) {
			case GroundPanel.LEFT :
				head.setLocation(head.getX()-20, head.getY());
				break;
			case GroundPanel.RIGHT :
				head.setLocation(head.getX()+20, head.getY());
				break;
			case GroundPanel.UP :
				head.setLocation(head.getX(), head.getY()-20);
				break;
			case GroundPanel.DOWN :
				head.setLocation(head.getX(), head.getY()+20);
				break;
			}
		} 
	}

	public static void main(String[] args) {
		new SnakeGameFrame();
	}
}

