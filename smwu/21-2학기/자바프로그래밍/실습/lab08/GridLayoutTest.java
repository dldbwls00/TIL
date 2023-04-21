// 이유진 (2016133)
// 2021-11-05
// Lab08 - 실습 2. Grid Layout 예제
import javax.swing.*;
import java.awt.*;

public class GridLayoutTest extends JFrame{

	public GridLayoutTest() {
		setTitle("Ten Buttons Frame"); //타이틀
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		GridLayout grid = new GridLayout(1,10);
		Container c = getContentPane();
		c.setLayout(grid);
		
		JButton [] btns = new JButton[10]; //인덱스 배열
		Color [] colors = {Color.red, Color.orange, Color.yellow, Color.green,
				Color.cyan,Color.blue, Color.magenta, Color.gray,
				Color.pink,Color.lightGray }; //컬러 배열
		for (int i=0; i<10; i++) {
			btns[i] = new JButton(i+""); //문자열만 들어갈 수 있기 때문에 
			btns[i].setBackground(colors[i]);
			c.add(btns[i]);
		}
		
		setSize(300,200); //프레임 크기
		setVisible(true); //프레임을 화면에 출력 
	}
	public static void main(String[] args) {
		new GridLayoutTest();
	}

}
