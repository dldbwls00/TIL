//이유진 (2016133)
//2023-07-05
//Lab0704-3: 난수를 발생해서 30개의 레이블을 불규칙하게 배치

import javax.swing.*;
import java.awt.*;

public class JLabelRandom extends JFrame {
	public JLabelRandom() {
		setTitle("My Frame");
		setSize(600, 300); // 프레임 크기

		Container c = getContentPane();
		c.setLayout(null); // 랜덤한 위치이므로 배치관리자 제거, 절대위치 사용
		for (int i = 0; i < 30; i++) {
			int num = (int) (Math.random() * 100) % 30; // 출력할 값
			JLabel label = new JLabel(num + ""); // 라벨 생성
			//출력하는 값이 난수가 아닌 그냥 0~29 범위의 정수인 경우 JLabel label = new JLabel(i + "");로 작성하면 됨

			int x = (int) (Math.random() * 550); // 위치 좌표 랜덤하게 (적정값 임의지정함)
			int y = (int) (Math.random() * 250);
			label.setLocation(x, y); //위치 설정
			label.setSize(20, 20); //리벨 크기 설정
			label.setForeground(Color.MAGENTA);
			c.add(label); // 부착
		}
		setVisible(true); // 프레임을 화면에 출력
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		JLabelRandom r = new JLabelRandom();
	}

}
