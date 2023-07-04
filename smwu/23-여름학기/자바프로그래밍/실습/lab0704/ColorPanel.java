//이유진 (2016133)
//2023-07-04
//Lab0704-1: 배경색이 다른 패널을 출력하는 화면 구성

import javax.swing.*;
import java.awt.*;

public class ColorPanel extends JFrame {

	public ColorPanel() {
		setSize(500, 250);
		setTitle("JPanel Color Test");

		Container c = getContentPane(); // 캔버스
		c.setLayout(new GridLayout(0, 1));

		JPanel labels = new JPanel();
		labels.setLayout(new GridLayout(0, 4));
		String[] lName = { "Red", "Yellow", "Green", "Blue" }; // 라벨 이름 배열
		JLabel[] label = new JLabel[lName.length]; // 라벨 배열
		for (int i = 0; i < lName.length; i++) {
			label[i] = new JLabel(lName[i]);
			label[i].setFont(new Font("Courier", Font.BOLD, 20)); // 폰트 지정
			label[i].setHorizontalAlignment(JLabel.CENTER); // 가운데정렬
			labels.add(label[i]); // 패널에 붙이기
		}

		JPanel colors = new JPanel();
		colors.setLayout(new GridLayout(0, 4, 10, 0));
		Color[] color = { Color.RED, Color.YELLOW, Color.GREEN, Color.BLUE }; // 컬러 타입 배열
		JPanel[] panel = new JPanel[color.length]; // 패널 배열
		for (int i = 0; i < color.length; i++) {
			panel[i] = new JPanel();
			panel[i].setBackground(color[i]);
			colors.add(panel[i]); // 패널에 붙이기
		}

		c.add(labels); // 프레임에 패널 붙이기
		c.add(colors); // 프레임에 패널 붙이기

		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		ColorPanel p = new ColorPanel();
	}

}
