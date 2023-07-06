//이유진 (2016133)
//2023-07-07
//Lab0706-4: slider 실습 - 금액을 입력하고 팁을 설정하면 팁을 포함한 총 금액이 화면에 출력됨

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class TipTest extends JFrame {

	JTextField price, total;
	JSlider slider;

	public TipTest() {
		setTitle("Tip Test");
		setSize(500, 300);
		setLayout(new GridLayout(0, 1));

		JLabel label = new JLabel("TIP 계산기");
		label.setHorizontalAlignment(JLabel.CENTER); // 가운데 정렬
		label.setFont(new Font("굴림", Font.PLAIN, 15));
		add(label);

		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		JPanel west = new JPanel();
		JPanel center = new JPanel();
		west.setLayout(new GridLayout(0, 1));
		center.setLayout(new GridLayout(0, 1));

		JLabel l1 = new JLabel("금액");
		JLabel l2 = new JLabel("팁");
		JLabel l3 = new JLabel("출력");
		west.add(l1);
		west.add(l2);
		west.add(l3);
		
		price = new JTextField("0"); //초기화
		slider = new JSlider(0, 30, 0);
		total = new JTextField("0");
		
		price.addKeyListener(new KeyListener() { // 리스너 붙이기
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) { //슬라이더 설정한 상태에서 금액 입력 후 엔터를 치면 총 금액에 표시되도록
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					int initial = Integer.parseInt(price.getText()); // 금액
					int percent = slider.getValue(); // 팁 퍼센트
					int totalprice = (int) (initial * (1 + 0.01 * percent)); // 팁을 포함한 총금액
					total.setText(totalprice + ""); // 총액 필드에 반영
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}
		});
		slider.setMajorTickSpacing(10); // 큰 눈금 간격
		slider.setMinorTickSpacing(1); // 작은 눈금 간격
		slider.setPaintTicks(true); // 눈금 표시

		slider.setPaintLabels(true); // 값 레벨 표시
		slider.addChangeListener(new ChangeListener() { // 리스너 붙이기
			@Override
			public void stateChanged(ChangeEvent e) {
				int initial = Integer.parseInt(price.getText()); // 금액
				int percent = slider.getValue(); // 팁 퍼센트
				int totalprice = (int) (initial * (1 + 0.01 * percent)); // 팁을 포함한 총금액
				total.setText(totalprice + ""); // 총액 필드에 반영
			}
		});
		center.add(price);
		center.add(slider);
		center.add(total);
		panel.add(west, BorderLayout.WEST);
		panel.add(center, BorderLayout.CENTER);
		add(panel);

		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new TipTest();
	}

}
