//이유진 (2016133)
//2023-07-05
//Lab0705-1: 계산기 프로그램: 숫자 두 개를 입력하고 버튼을 누르면 결과가 출력됨
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalcFrame extends JFrame {

	JTextField num1, num2, result;
	JLabel label;
	JButton btn;

	public CalcFrame() {
		setTitle("계산기");
		setSize(500, 100);
		setLayout(null); // 배치관리자 삭제

		num1 = new JTextField(20);
		num1.setLocation(20, 20);
		num1.setSize(80, 20);

		label = new JLabel("X");
		label.setLocation(120, 20);
		label.setSize(20, 20);

		num2 = new JTextField(20);
		num2.setLocation(150, 20);
		num2.setSize(80, 20);

		btn = new JButton("=");
		btn.setLocation(250, 20);
		btn.setSize(50, 20);
		btn.addActionListener(new ActionListener() {// 익명 클래스 리스너 달기
			@Override
			public void actionPerformed(ActionEvent e) { //버튼을 눌렀을 때
				result.setText(Integer.parseInt(num1.getText()) * Integer.parseInt(num2.getText()) + "");
			}
		});

		result = new JTextField(20);
		result.setLocation(320, 20);
		result.setSize(80, 20);

		add(num1);
		add(label);
		add(num2);
		add(btn);
		add(result);

		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new CalcFrame();
	}

}
