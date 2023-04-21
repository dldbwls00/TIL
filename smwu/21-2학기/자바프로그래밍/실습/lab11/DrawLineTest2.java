// 이유진 (2016133)
// 2021-11-26
// Lab11 - 실습 2. DrawLine 실습 - 컨텐트팬에 꽉차는 마름모 10개 그리기
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DrawLineTest2 extends JFrame{
	private MyPanel panel = new MyPanel();
	
	public DrawLineTest2() {
		setTitle("그래픽 다각형 연습"); //타이틀
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel); //내가 만든 도화지(판넬)을 기본으로 설정
		setSize(300, 300); //프레임 크기
		setVisible(true); //프레임을 화면에 출력
	}
	class MyPanel extends JPanel{ //별도 클래스로 판넬의 속성 표현
		public void paintComponent(Graphics g) { //재정의
			super.paintComponent(g);
			for (int i=0; i<10; i++) { //마름모 그리기
				int []x = {getWidth()/2, getWidth()-i*10, getWidth()/2, i*10};
				int []y = {i*10, getHeight()/2, getHeight()-i*10, getHeight()/2};
				g.drawPolygon(x, y, 4);
			}
		}
	}
	public static void main(String[] args) {
		new DrawLineTest2();
	}

}
