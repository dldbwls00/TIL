// 이유진 (2016133)
// 2021-11-05
// Lab08 - 실습 4. JLabel 랜덤 예제
import javax.swing.*;
import java.awt.*;

public class GuiTest extends JFrame{
	public GuiTest() {
		setTitle("GUI TEST"); //타이틀
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		
		JPanel labels = new JPanel(); //왼쪽 라벨
		labels.setLayout(new GridLayout(4,1)); //그리드 레이아웃
		labels.add(new JLabel("이 름"));
		labels.add(new JLabel("학 번"));
		labels.add(new JLabel("전 공"));
		labels.add(new JLabel("연락처"));
		
		JPanel textfields = new JPanel(); //텍스트필드
		textfields.setLayout(new GridLayout(4,1));
		for (int i=0; i<4; i++)
			textfields.add(new JTextField(20));
		
		JPanel buttons = new JPanel(); //버튼
		buttons.add(new JButton("확인"));
		buttons.add(new JButton("취소"));
		
		JPanel north = new JPanel(); //위쪽 공백
		north.add(new JLabel(""));
		
		c.add(north, BorderLayout.NORTH); //컨테이너에 저장
		c.add(labels, BorderLayout.WEST);
		c.add(textfields, BorderLayout.CENTER);
		c.add(buttons, BorderLayout.SOUTH);
		
		setSize(300,200); //프레임 크기
		setVisible(true); //프레임을 화면에 출력
	}
	public static void main(String[] args) {
		new GuiTest();
	}

}
