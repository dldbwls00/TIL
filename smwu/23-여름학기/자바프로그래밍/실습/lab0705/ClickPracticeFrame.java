//이유진 (2016133)
//2023-07-05
//Lab0705-3: 클릭 연습용 프로그램: "C"를 클릭할 때마다 랜덤한 위치로 옮겨짐

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ClickPracticeFrame extends JFrame {

	public ClickPracticeFrame() {
		setTitle("클릭 연습용 응용 프로그램"); // 타이틀
		setSize(300, 300);
		setLayout(null); // 배치관리자 삭제
		
		JLabel label = new JLabel("C");
		label.setLocation(100, 100); // 초기 위치 설정
		label.setSize(10, 10); // 크기 설정

		label.addMouseListener(new MouseAdapter() { // 익명 클래스로 어댑터 구현
			public void mouseClicked(MouseEvent e) {
				int x = (int) (Math.random() * getWidth()); // 위치 랜덤하게, 창 범위 내에서
				int y = (int) (Math.random() * getHeight());
				label.setLocation(x, y);
			}
		});

		add(label);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new ClickPracticeFrame();
	}

}
