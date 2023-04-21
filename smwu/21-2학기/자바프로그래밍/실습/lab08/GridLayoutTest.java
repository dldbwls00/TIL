// ������ (2016133)
// 2021-11-05
// Lab08 - �ǽ� 2. Grid Layout ����
import javax.swing.*;
import java.awt.*;

public class GridLayoutTest extends JFrame{

	public GridLayoutTest() {
		setTitle("Ten Buttons Frame"); //Ÿ��Ʋ
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		GridLayout grid = new GridLayout(1,10);
		Container c = getContentPane();
		c.setLayout(grid);
		
		JButton [] btns = new JButton[10]; //�ε��� �迭
		Color [] colors = {Color.red, Color.orange, Color.yellow, Color.green,
				Color.cyan,Color.blue, Color.magenta, Color.gray,
				Color.pink,Color.lightGray }; //�÷� �迭
		for (int i=0; i<10; i++) {
			btns[i] = new JButton(i+""); //���ڿ��� �� �� �ֱ� ������ 
			btns[i].setBackground(colors[i]);
			c.add(btns[i]);
		}
		
		setSize(300,200); //������ ũ��
		setVisible(true); //�������� ȭ�鿡 ��� 
	}
	public static void main(String[] args) {
		new GridLayoutTest();
	}

}
