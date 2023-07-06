//이유진 (2016133)
//2023-07-07
//Lab0706-1: 체크박스 실습 - 체크박스를 선택하면 자동차 정비소의 요금표가 갱신됨

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CarshopTest extends JFrame {

	JCheckBox engineOil, transOil, filter, tire;
	JLabel label;
	int cost = 0; // 요금

	class MyListener implements ItemListener {

		@Override
		public void itemStateChanged(ItemEvent e) {
			if (e.getStateChange() == 1) { // 체크박스가 선택된 경우
				if (e.getSource() == engineOil)
					cost += 45000;
				if (e.getSource() == transOil)
					cost += 80000;
				if (e.getSource() == filter)
					cost += 30000;
				if (e.getSource() == tire)
					cost += 100000;
			} else { // 체크박스가 선택 취소된 경우
				if (e.getSource() == engineOil)
					cost -= 45000;
				if (e.getSource() == transOil)
					cost -= 80000;
				if (e.getSource() == filter)
					cost -= 30000;
				if (e.getSource() == tire)
					cost -= 100000;
			}
			label.setText("현재까지의 가격은 " + cost + "입니다."); // 요금표 라벨 갱신
		}

	}

	public CarshopTest() {
		setTitle("CheckBoxDemo");
		setSize(500, 300);
		setLayout(new BorderLayout());

		JPanel north = new JPanel();
		JPanel center = new JPanel();

		engineOil = new JCheckBox("엔진오일 교환");
		transOil = new JCheckBox("자동변속기오일 교환");
		filter = new JCheckBox("에어컨필터 교환");
		tire = new JCheckBox("타이어 교환");
		engineOil.addItemListener(new MyListener());
		transOil.addItemListener(new MyListener());
		filter.addItemListener(new MyListener());
		tire.addItemListener(new MyListener());
		north.add(engineOil); // 패널에 체크박스 붙이기
		north.add(transOil);
		north.add(filter);
		north.add(tire);
		add(north, BorderLayout.NORTH); // 캔버스에 패널 붙이기

		label = new JLabel();
		label.setText("현재까지의 가격은 " + cost + "입니다."); // 라벨 텍스트 설정
		label.setFont(new Font("Serif", Font.ITALIC, 30)); // 라벨 폰트 설정
		label.setHorizontalAlignment(JLabel.CENTER); // 라벨 가운데 정렬
		center.add(label); // 패널에 라벨 붙이기
		add(label, BorderLayout.CENTER); // 캔버스에 패널 붙이기

		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new CarshopTest();
	}

}
