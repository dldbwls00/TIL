// 이유진 (2016133)
// 2021-11-05
// Lab08 - 실습 6. 배치관리자 없이 배치하는 실습
import javax.swing.*;
import java.awt.*;

public class StoryTest extends JFrame{
	public StoryTest() {
		setTitle("SM Story"); //타이틀
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(null); //배치관리자 삭제

		JLabel sm = new JLabel("SM Story"); //라벨
		sm.setLocation(20,20); //위치
		sm.setSize(80,20); //크기
		
		JLabel fall = new JLabel("가을은");
		fall.setLocation(80,50);
		fall.setSize(80,20);
		
		JTextField blank = new JTextField(""); //텍스트필드
		blank.setLocation(120,80); //위치
		blank.setSize(80,20); //크기
		
		JLabel is = new JLabel("이다");
		is.setLocation(220,100);
		is.setSize(80,20);
		
		c.add(sm); //컨테이너에 저장
		c.add(fall);
		c.add(blank);
		c.add(is);
		
		setSize(300,200); //프레임 크기 
		setVisible(true); //프레임을 화면에 출력
	}
	public static void main(String[] args) {
		new StoryTest();
	}

}
