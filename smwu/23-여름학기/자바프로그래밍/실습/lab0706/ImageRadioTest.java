//이유진 (2016133)
//2023-07-07
//Lab0706-2: 라디오버튼 실습 - 선택한 라디오버튼에 해당하는 사진 띄우기

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;

public class ImageRadioTest extends JFrame implements ActionListener {

	String[] animalName = { "bird", "cat", "dog", "rabbit", "pig" }; //라디오버튼 이름 배열
	JRadioButton[] radio = new JRadioButton[animalName.length]; //라디오버튼 배열
	JLabel img; // 이미지가 출력될 라벨

	@Override
	public void actionPerformed(ActionEvent e) {
		if (radio[0].isSelected())
			img.setIcon(new ImageIcon(animalName[0] + ".png")); //라벨에 ImageIcon 넣기
		else if (radio[1].isSelected())
			img.setIcon(new ImageIcon(animalName[1] + ".png"));
		else if (radio[2].isSelected())
			img.setIcon(new ImageIcon(animalName[2] + ".png"));
		else if (radio[3].isSelected())
			img.setIcon(new ImageIcon(animalName[3] + ".png"));
		else
			img.setIcon(new ImageIcon(animalName[4] + ".png"));
	}

	public ImageRadioTest() {
		setTitle("RadioButtonDemo");
		setSize(400, 300);
		setLayout(null);

		JPanel west = new JPanel();
		JPanel center = new JPanel();

		west.setLayout(new GridLayout(0, 1));
		west.setBounds(30, 30, 60, 200); // 패널 위치, 사이즈 조정

		ButtonGroup animal = new ButtonGroup(); // 라디오버튼그룹
		for (int i = 0; i < animalName.length; i++) {
			radio[i] = new JRadioButton(animalName[i]); // 라디오버튼 만들기
			animal.add(radio[i]); // 라디오버튼그룹에 달기
			radio[i].addActionListener(this); // 리스너 달기
			west.add(radio[i]); // 패널에 달기
		}
		add(west); // 캔버스에 달기

		center.setLayout(null); // 레이아웃 없애기
		center.setBounds(90, 30, 270, 200); // 패널 위치, 사이즈 조정
		img = new JLabel();
		img.setBounds(0,0, 270, 200); // 라벨 위치, 사이즈 조정

		center.add(img); // 패널에 달기
		add(center); // 캔버스에 달기

		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new ImageRadioTest();
	}

}
