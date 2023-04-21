// ������ (2016133)
// 2021-11-26
// Lab11 - �ǽ� 6. ��ȣ�� ����
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TrafficTest extends JFrame{
	int mode = 0; //���°� ���� : �ʱ���� red
	
	private MyPanel panel = new MyPanel();
	public TrafficTest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		
		c.add(new MyPanel(), BorderLayout.CENTER);//�����̳ʿ� ���̱�
	
		JButton btn = new JButton("traffic light turn on");
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mode++;
				mode %= 3;
				repaint();
			}
		});
		c.add(btn, BorderLayout.SOUTH);
		
		setSize(300, 600); //������ ũ��
		setVisible(true); //�������� ȭ�鿡 ���
	}
	class MyPanel extends JPanel{//���� Ŭ������ �ǳ��� �Ӽ� ǥ��
		public void paintComponent(Graphics g) { //������
			super.paintComponent(g);
			if (mode == 0){//���ǿ� ���� (mode) ��ĥ�ϱ� - fillOval
				g.setColor(Color.RED);
				g.fillOval(70, 50, 150, 150);
			}
			else if (mode == 1) {
				g.setColor(Color.YELLOW);
				g.fillOval(70, 200, 150, 150);
			}
			else {
				g.setColor(Color.GREEN);
				g.fillOval(70, 350, 150, 150);
			}
			g.setColor(Color.BLACK);
			g.drawOval(70, 50, 150, 150);//�� 3�� �׸��� drawOval
			g.drawOval(70, 200, 150, 150);
			g.drawOval(70, 350, 150, 150);
			}
	}
	public static void main(String[] args) {
		new TrafficTest();
	}

}
