//이유진 (2016133)
//2023-07-07
//Lab0706-3: textArea 실습 - 회원 정보를 입력하고 등록버튼을 누르면 텍스트 영역에 추가됨

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ProfileTest extends JFrame {

	JTextField name, phone;
	JComboBox major;
	JButton btn;
	JTextArea textarea;

	public ProfileTest() {
		setTitle("Profile Test");
		setSize(300, 400);
		setLayout(new GridLayout(0, 1));

		JPanel member = new JPanel(); // 회원 정보 입력 패널
		member.setLayout(new BorderLayout());

		JPanel north = new JPanel();
		north.add(new JLabel("회원 정보 추가"));
		member.add(north, BorderLayout.NORTH); // 패널에 붙이기

		JPanel west = new JPanel();
		west.setLayout(new GridLayout(0, 1));
		west.add(new JLabel("이름"));
		west.add(new JLabel("학과"));
		west.add(new JLabel("연락처"));
		member.add(west, BorderLayout.WEST); // 패널에 붙이기

		JPanel center = new JPanel();
		center.setLayout(new GridLayout(0, 1));
		name = new JTextField(10);
		String[] majors = {"소프트웨어학부", "경영학과", "IT공학과", "문헌정보학과"}; //콤보박스가 들고갈 전공 배열
		major = new JComboBox(majors);
		major.setSelectedIndex(0); // 초기 선택 인덱스 설정
		phone = new JTextField(20);
		center.add(name);
		center.add(major);
		center.add(phone);
		member.add(center, BorderLayout.CENTER); // 패널에 붙이기

		JPanel south = new JPanel();
		btn = new JButton("추가");
		btn.addActionListener(new ActionListener() { // 리스너 달기
			@Override
			public void actionPerformed(ActionEvent e) {
				String text = name.getText() + ", " + major.getSelectedItem().toString() + ", " + phone.getText();
				textarea.append(text + "\n"); // 텍스트영역에 붙이기
				
				name.setText(""); //초기화
				major.setSelectedIndex(0);
				phone.setText("");
			}
		});
		south.add(btn);
		member.add(south, BorderLayout.SOUTH);

		add(member);

		JPanel print = new JPanel(); // 입력한 정보 출력창 패널
		textarea = new JTextArea(10, 25);
		print.add(new JScrollPane(textarea));
		add(print);

		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new ProfileTest();
	}

}
