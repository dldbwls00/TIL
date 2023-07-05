//이유진 (2016133)
//2023-07-05
//Lab0705-2: 마우스 이벤트 실습: 라벨에 마우스를 올리면 "Love Java", 내리면 "사랑해"가 출력되도록 함

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MouseEventFrame extends JFrame {

	JLabel label = new JLabel("사랑해");

	public MouseEventFrame() {
		setTitle("마우스 올리기 내리기"); // 타이틀
		setSize(300, 200); // 프레임 크기
		setLayout(new FlowLayout());

		label.addMouseListener(new MouseAdapter() { // 익명 클래스로 어댑터 작성
			public void mouseEntered(MouseEvent e) { // 마우스 올릴 때
				label.setText("Love Java");
			}

			public void mouseExited(MouseEvent e) { // 마우스 내릴 때
				label.setText("사랑해");
			}
		});

		add(label); // 붙이기
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new MouseEventFrame();
	}
}
