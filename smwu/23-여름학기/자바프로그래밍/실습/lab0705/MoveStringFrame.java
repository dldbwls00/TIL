//이유진 (2016133)
//2023-07-05
//Lab0705-5: 왼쪽 화살표 키를 입력할 때마다 문자열 "Love Java"가 회전하는 프로그램

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MoveStringFrame extends JFrame implements KeyListener {
	JLabel label = new JLabel("Love Java"); // 초기 상태
	String s = "Love Java";

	public MoveStringFrame() {
		setTitle("Left키로 문자열 회전하기"); // 타이틀
		setSize(300, 200); // 프레임 크기
		setLayout(new FlowLayout());

		addKeyListener(this);

		add(label);

		setVisible(true);
		setFocusable(true); // 컴포넌트가 키 이벤트를 받기 위함
		requestFocus(); // 컴포넌트가 키 이벤트를 받기 위함
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		String first = s.substring(0, 1); // 왼쪽 한 글자
		String last = s.substring(1); // 나머지
		if (e.getKeyCode() == KeyEvent.VK_LEFT) { // <Left>키를 입력할 때마다
			s = last + first;
			label.setText(s);
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	public static void main(String[] args) {
		new MoveStringFrame();
	}

}
