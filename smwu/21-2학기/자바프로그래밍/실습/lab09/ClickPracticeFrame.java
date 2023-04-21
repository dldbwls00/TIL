// 이유진 (2016133)
// 2021-11-12
// Lab09 - 실습 4. 클릭 연습용 응용 프로그램
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ClickPracticeFrame extends JFrame{

	public ClickPracticeFrame() {
		setTitle("클릭 연습용 응용 프로그램"); //타이틀
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(null); //배치관리자 삭제
		JLabel la = new JLabel("C");
		la.setLocation(100, 100); //초기 위치 설정
		la.setSize(10, 10);
		c.add(la);
		
		la.addMouseListener(new MouseAdapter() { //익명 클래스로 어댑터 구현
			public void mouseClicked(MouseEvent e) {
				int x = (int)(Math.random()*getWidth()); //위치 랜덤하게, 창 범위 내에서
				int y = (int)(Math.random()*getHeight());
				la.setLocation(x,y);
			}
		});
		setSize(300,300); //프레임 크기
		setVisible(true); //프레임을 화면에 출력
	}
	public static void main(String[] args) {
		new ClickPracticeFrame();
	}

}
