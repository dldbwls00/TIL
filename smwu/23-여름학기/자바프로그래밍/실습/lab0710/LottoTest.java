// 이유진(2016133)
// 2023-07-11
// Lab0710-2: HashSet 활용 - 로또 번호 뽑기

import java.util.*;
import javax.swing.*;
import java.awt.*;

class Lotto {

	HashSet<Integer> set = new HashSet<Integer>(); //HashSet 선언

	public void make() { // 로또 번호 생성 메소드
		while (set.size() < 6) { // set에 숫자 6개가 찰 때까지 반복한다
			int n = (int) (Math.random() * 45 + 1); // 1~45 정수
			set.add(n);
		}
	}

	@Override
	public String toString() { // 로또 번호 결과 문자열로 반환
		return "Lotto [" + set + "]";
	}
}

public class LottoTest extends JFrame {

	public LottoTest() {

		Lotto lotto = new Lotto();

		JButton btn = new JButton("로또 번호 생성");
		JTextField tf = new JTextField(30);
		btn.addActionListener(e -> {
			lotto.make(); // 버튼이 눌려지면 로또 번호 생성 메서드 호출
			tf.setText(lotto.toString()); // 결과 문자열을 tf에 설정
		});

		add(btn, "North"); // 캔버스에 붙이기
		add(tf, "Center");
		pack(); // 화면에 적절히 잘 차게

		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new LottoTest();
	}
}
