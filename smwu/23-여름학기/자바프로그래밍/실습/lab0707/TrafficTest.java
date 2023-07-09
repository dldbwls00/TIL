// 이유진 (2016133)
// 2023-07-09
// Lab0707-5: 신호등 그리기 - 버튼을 누를 때마다 신호등이 켜지는 위치와 색깔이 달라지도록 하는 프로그램

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TrafficTest extends JFrame {

	int mode = 0; // 상태값: 초기상태 red

	private MyPanel panel = new MyPanel();

	class MyPanel extends JPanel {// 별도 클래스로 판넬의 속성 표현
		
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			if (mode == 0) { // 조건에 따라 (mode) 색칠하기
				g.setColor(Color.red);
				g.fillOval(80, 50, 120, 120);
			} else if (mode == 1) {
				g.setColor(Color.green);
				g.fillOval(80, 170, 120, 120);
			} else {
				g.setColor(Color.yellow);
				g.fillOval(80, 290, 120, 120);
			}
			
			g.setColor(Color.black);
			g.drawOval(80, 50, 120, 120); // 원 테두리 3개 그리기
			g.drawOval(80, 170, 120, 120);
			g.drawOval(80, 290, 120, 120);
		}
	}

	public TrafficTest() {
		setTitle("Traffic Test");
		setSize(300, 600);
		setLayout(new BorderLayout());

		add(new MyPanel(), BorderLayout.CENTER); // 캔버스에 패널 붙이기

		JButton btn = new JButton("traffic light turn on");
		btn.addActionListener(new ActionListener() { // 리스너 붙이기: 버튼을 누를 때마다
			public void actionPerformed(ActionEvent e) {
				mode++;
				mode %= 3;
				repaint();
			}
		});
		add(btn, BorderLayout.SOUTH);

		setVisible(true); // 프레임을 화면에 출력
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new TrafficTest();
	}

}