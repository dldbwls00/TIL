// 이유진 (2016133)
// 2021-11-26
// Lab11 - 실습 1. Color, Font 실습
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ColorFontTest extends JFrame{
	private MyPanel panel = new MyPanel();
	
	public ColorFontTest() {
		setTitle("Color, Font 사용 예제"); //타이틀
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel); //내가 만든 도화지(판넬)을 기본으로 설정
		setSize(600, 250); //프레임 크기
		setVisible(true); //프레임을 화면에 출력
	}
	class MyPanel extends JPanel{ //별도 클래스로 판넬의 속성 표현
		public void paintComponent(Graphics g) { //재정의
			super.paintComponent(g);
			g.setColor(Color.BLUE); //컬러 변경
			g.setFont(new Font("궁서", Font.BOLD, 25)); //폰트 변경
			g.drawString("국적: 대한민국(궁서 폰트)", 30, 50); //문자열 작성
			
			g.setColor(Color.RED);
			g.setFont(new Font("양재깨비체B", Font.ITALIC, 30));
			g.drawString("주소: 서울시 마포구(양재깨비체B 폰트)", 30, 100);
			
			g.setColor(Color.ORANGE);
			g.setFont(new Font("휴먼매직체", Font.ITALIC, 45));
			g.drawString("성명: 홍길동(휴먼매직체 폰트)", 30, 150);
			
			g.setColor(Color.BLACK);
			g.setFont(new Font("HY나무B", Font.PLAIN, 17));
			g.drawString("학번: 2016133(HY나무B 폰트)", 30, 200);
		}
	}
	
	public static void main(String[] args) {
		new ColorFontTest();
	}

}
