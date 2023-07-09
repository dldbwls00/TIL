// 이유진 (2016133)
// 2023-07-09
// Lab0707-1: 명함 그리기 - 텍스트, 그림, 도형을 이용해 명함을 출력하는 프로그램

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DrawCard extends JFrame {

	class Panel extends JPanel {

		@Override
		protected void paintComponent(Graphics g) { // paint 컴포넌트 사용
			super.paintComponent(g);

			// 위, 아래 선 두 개
			g.setColor(Color.black);
			g.drawLine(20, 20, 460, 20);
			g.drawLine(20, 190, 460, 190);

			// 도형
			g.setColor(Color.blue);
			g.fillRoundRect(40, 40, 130, 130, 30, 30);

			// 그림
			ImageIcon icon = new ImageIcon("pig.png");
			Image img = icon.getImage();
			g.drawImage(img, 60, 60, 90, 90, null);

			// 텍스트
			g.setColor(Color.black);
			g.setFont(new Font("돋움", Font.BOLD, 20));
			g.drawString("홍길동", 200, 80);
			g.drawString("프로젝트 매니저", 200, 110);
			g.drawString("자바주식회사", 200, 140);
		}
	}

	public DrawCard() {
		setTitle("나의 명함");
		setSize(500, 250);

		add(new Panel()); // 패널 붙이기

		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new DrawCard();
	}
}
