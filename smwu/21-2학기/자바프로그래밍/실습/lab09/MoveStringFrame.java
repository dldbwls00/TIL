// 이유진 (2016133)
// 2021-11-12
// Lab09 - 실습 6. 텍스트 회전
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MoveStringFrame extends JFrame{
	JLabel la = new JLabel("Love Java");
	String s = "Love Java";
	public MoveStringFrame() {
		setTitle("Left키로 문자열 회전하기"); //타이틀
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		c.addKeyListener(new MyKeyListener());
		c.add(la);
		
		setSize(300,200); //프레임 크기
		setVisible(true); //프레임을 화면에 출력
		c.setFocusable(true);
		c.requestFocus();
	}
	class MyKeyListener	extends KeyAdapter{
		public void keyPressed(KeyEvent e) {
			String first = s.substring(0,1);
			String last = s.substring(1);
			if (e.getKeyCode() == KeyEvent.VK_LEFT) { //<Left>키를 입력할 때마다
				s = last + first;
				la.setText(s);
			}
		}
	}
	public static void main(String[] args) {
		new MoveStringFrame();
	}

}
