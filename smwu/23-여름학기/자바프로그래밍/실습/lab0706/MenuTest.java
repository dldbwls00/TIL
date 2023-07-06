//이유진 (2016133)
//2023-07-07
//Lab0706-5: menu 실습 - 선택한 메뉴가 화면에 출력됨

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MenuTest extends JFrame implements ActionListener {

	JMenuBar menuBar;
	JMenu file;
	JMenuItem open, save, saveAnother;
	JMenu print;
	JMenuItem printer, pdf;
	JLabel label;

	@Override
	public void actionPerformed(ActionEvent e) {
		String string = e.getActionCommand(); //선택한 메뉴 이름 불러오기
		label.setText("[" + string + "]" + " 메뉴 선택"); //라벨 갱신
	}

	public MenuTest() {
		setTitle("Menu Example");
		setSize(500, 400);

		menuBar = new JMenuBar();
		file = new JMenu("파일");
		menuBar.add(file); // 메뉴바에 붙이기

		open = new JMenuItem("열기");
		save = new JMenuItem("저장하기");
		saveAnother = new JMenuItem("다른 이름으로 저장하기");
		print = new JMenu("출력");
		printer = new JMenuItem("프린터로 출력하기");
		pdf = new JMenuItem("pdf로 출력하기");

		print.add(printer); // 프린터 메뉴에 붙이기
		print.add(pdf);
		file.add(open); // 파일 메뉴에 붙이기
		file.add(save);
		file.add(saveAnother);
		file.add(print);

		open.addActionListener(this); // 리스너 달기
		save.addActionListener(this);
		saveAnother.addActionListener(this);
		printer.addActionListener(this);
		pdf.addActionListener(this);

		label = new JLabel("메뉴 선택 결과는 여기에");

		setJMenuBar(menuBar); // 메뉴바 붙이기
		add(label);

		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new MenuTest();
	}

}
