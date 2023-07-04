//이유진 (2016133)
//2023-07-05
//Lab0704-2: 회원의 정보를 받아서 데이터베이스에 저장하는 프로그램 화면

import javax.swing.*;
import java.awt.*;

public class MemberGui extends JFrame {
	public MemberGui() {
		setTitle("회원 정보 등록 화면");
		setSize(400, 300);

		Container c = getContentPane(); // 캔버스
		c.setLayout(new BorderLayout());

		JPanel labels = new JPanel(); // 중앙 좌측 라벨 패널
		labels.setLayout(new GridLayout(4, 1));
		labels.add(new JLabel("이름"));
		labels.add(new JLabel("패스워드"));
		labels.add(new JLabel("이메일 주소"));
		labels.add(new JLabel("전화번호"));

		JPanel textfields = new JPanel(); // 중앙 우측(center) 입력 필드 패널
		textfields.setLayout(new GridLayout(4, 1));
		textfields.add(new JTextField(20)); // 패널에 붙이기
		textfields.add(new JPasswordField(20)); // 패스워드 필드 사용
		textfields.add(new JTextField(20));
		textfields.add(new JTextField(20));

		JPanel buttons = new JPanel(); // 하단부 버튼 패널
		buttons.add(new JButton("등록하기")); // 패널에 붙이기
		buttons.add(new JButton("취소"));

		JPanel north = new JPanel();
		north.add(new JLabel("회원 등록")); // 패널에 붙이기

		c.add(north, BorderLayout.NORTH); // 캔버스에 붙이기
		c.add(labels, BorderLayout.WEST);
		c.add(textfields, BorderLayout.CENTER);
		c.add(buttons, BorderLayout.SOUTH);

		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		MemberGui m = new MemberGui();
	}

}