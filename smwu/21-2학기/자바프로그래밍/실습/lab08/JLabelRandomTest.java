// 이유진 (2016133)
// 2021-11-05
// Lab08 - 실습 3. JLabel 랜덤 예제
import javax.swing.*;
import java.awt.*;

public class JLabelRandomTest extends JFrame{
	public JLabelRandomTest() {
		setTitle("Random Labels");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(null); //랜덤한 위치이므로 배치관리자 제거 
		for (int i=0; i<20; i++) {
			JLabel label = new JLabel(); //라벨 생성
			
			int x = (int)(Math.random()*200) + 50; //위치 랜덤하게
			int y = (int)(Math.random()*200) + 50;
			label.setLocation(x,y);
			label.setSize(10,10);
			
			label.setBackground(Color.blue);//배경색 설정
			label.setOpaque(true);
			
			c.add(label); //부착
		}
		setSize(300,300); //프레임 크기 
		setVisible(true); //프레임을 화면에 출력
	}
	
	public static void main(String[] args) {
		new JLabelRandomTest();
	}

}
