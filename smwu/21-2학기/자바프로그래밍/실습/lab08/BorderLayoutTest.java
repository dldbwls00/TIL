// 이유진 (2016133)
// 2021-11-05
// Lab08 - 실습 1. Border Layout 예제
import javax.swing.*;
import java.awt.*;

public class BorderLayoutTest extends JFrame {
	public BorderLayoutTest() {
		setTitle("BorderLayout Practice"); //타이틀
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new BorderLayout(5,7)); //간격 만들기
		c.add(new JButton("Center"), BorderLayout.CENTER);
		c.add(new JButton("North"), BorderLayout.NORTH);
		c.add(new JButton("South"), BorderLayout.SOUTH);
		c.add(new JButton("East"), BorderLayout.EAST);
		c.add(new JButton("West"), BorderLayout.WEST);
		
		setSize(400, 200); //프레임 크기 400x200
		setVisible(true); //프레임을 화면에 출력
	}
	
	public static void main(String[] args) {
		new BorderLayoutTest();
	}

}
