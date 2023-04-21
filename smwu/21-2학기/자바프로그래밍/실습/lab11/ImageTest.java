// 이유진 (2016133)
// 2021-11-26
// Lab11 - 실습 5. 이미지 그리기
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ImageTest extends JFrame{
	private MyPanel panel = new MyPanel();
	
	public ImageTest() {
		setTitle("그래픽 이미지 연습"); //타이틀
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel); //내가 만든 도화지(판넬)을 기본으로 설정
		setSize(300, 300); //프레임 크기
		setVisible(true); //프레임을 화면에 출력
	}
	class MyPanel extends JPanel{//별도 클래스로 판넬의 속성 표현
		private ImageIcon icon = new ImageIcon("back.jpg"); //이미지 불러오기
		private Image img = icon.getImage();
		public void paintComponent(Graphics g) { //재정의
			super.paintComponent(g);
			//이미지의 getWidth, getHeight의 매개변수로 들어갈 image observer는 this로 설정
			g.drawImage(img, 0, 0, getWidth()/2-5, getHeight()/2-5, //왼쪽 위
					0, 0, img.getWidth(this)/2, img.getHeight(this)/2, this);
			g.drawImage(img, getWidth()/2+5, 0, getWidth(), getHeight()/2-5, //오른쪽 위
					img.getWidth(this)/2, 0, img.getWidth(this), img.getHeight(this)/2, this);
			g.drawImage(img, 0, getHeight()/2+5, getWidth()/2-5, getHeight(), //왼쪽 아래
					0, img.getHeight(this)/2, img.getWidth(this)/2, img.getHeight(this), this);
			g.drawImage(img, getWidth()/2+5, getHeight()/2+5, getWidth(), getHeight(), //오른쪽 아래
					img.getWidth(this)/2, img.getHeight(this)/2, img.getWidth(this), img.getHeight(this), this);
		}	
	}
	public static void main(String[] args) {
		new ImageTest();
	}

}
