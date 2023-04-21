// 이유진 (2016133)
// 2021-11-26
// Lab11 - 실습 2. DrawLine 실습 - 컨텐트팬을 10x10으로 나누는 격자 그리기
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DrawLineTest1 extends JFrame{
	private MyPanel panel = new MyPanel();
	
	public DrawLineTest1() {
		setTitle("격자 그리기"); //타이틀
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel); //내가 만든 도화지(판넬)을 기본으로 설정
		setSize(300, 300); //프레임 크기
		setVisible(true); //프레임을 화면에 출력
	}
	class MyPanel extends JPanel{ //별도 클래스로 판넬의 속성 표현
		public void paintComponent(Graphics g) { //재정의
			super.paintComponent(g);
			for (int i=1; i<10; i++) { //가로선
				int x1 = 0, y1 = getHeight()/10*i, x2 = getWidth(), y2 = getHeight()/10*i;
				g.drawLine(x1, y1, x2, y2);
			}
			for (int i=1; i<10; i++) { //세로선
				int x1 = getWidth()/10*i, y1 = 0, x2 = getWidth()/10*i, y2 = getHeight();
				g.drawLine(x1, y1, x2, y2);
			}
		}
	}
	public static void main(String[] args) {
		new DrawLineTest1();
	}

}
