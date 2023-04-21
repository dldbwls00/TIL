// 이유진 (2016133)
// 2021-11-26
// Lab11 - 실습 6. 신호등 예제
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TrafficTest extends JFrame{
	int mode = 0; //상태값 변수 : 초기상태 red
	
	private MyPanel panel = new MyPanel();
	public TrafficTest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		
		c.add(new MyPanel(), BorderLayout.CENTER);//컨테이너에 붙이기
	
		JButton btn = new JButton("traffic light turn on");
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mode++;
				mode %= 3;
				repaint();
			}
		});
		c.add(btn, BorderLayout.SOUTH);
		
		setSize(300, 600); //프레임 크기
		setVisible(true); //프레임을 화면에 출력
	}
	class MyPanel extends JPanel{//별도 클래스로 판넬의 속성 표현
		public void paintComponent(Graphics g) { //재정의
			super.paintComponent(g);
			if (mode == 0){//조건에 따라 (mode) 색칠하기 - fillOval
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
			g.drawOval(70, 50, 150, 150);//원 3개 그리기 drawOval
			g.drawOval(70, 200, 150, 150);
			g.drawOval(70, 350, 150, 150);
			}
	}
	public static void main(String[] args) {
		new TrafficTest();
	}

}
