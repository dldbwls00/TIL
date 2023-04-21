// 이유진 (2016133)
// 2021-11-12
// Lab09 - 실습 3. 마우스이벤트 Love Java 출력
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MouseEventFrame extends JFrame{
	JLabel la = new JLabel("Love Java");
	public MouseEventFrame() {
		setTitle("마우스 올리기 내리기"); //타이틀
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		c.add(la);
		la.addMouseListener(new MouseAdapter() { // 익명 클래스로 어댑터 작성
			public void mouseEntered(MouseEvent e) { //마우스 올릴 때
				la.setText("사랑해");
			}
			public void mouseExited(MouseEvent e) { //마우스 내릴 때
				la.setText("Love Java");
			}});
		setSize(300,200); //프레임 크기
		setVisible(true); //프레임을 화면에 출력
	}
	
	public static void main(String[] args) {
		new MouseEventFrame();
	}
}
