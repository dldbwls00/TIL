// 이유진 (2016133)
// 2021-11-05
// Lab08 - 실습 5. 배치 관리자 혼합 사용 실습
import javax.swing.*;
import java.awt.*;

public class GridTest extends JFrame{
	public GridTest() {
		setTitle("Ten Buttons Frame"); //타이틀
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		
		JPanel title = new JPanel(); //제목
		title.add(new JLabel("학생 정보 입력"));
		
		JPanel info = new JPanel(); //내용
		GridLayout grid = new GridLayout(5, 4); 
		grid.setVgap(2); //행 간격
		info.setLayout(grid);
		info.add(new JLabel("이름"));
		info.add(new JLabel("학번"));
		info.add(new JLabel("학과"));
		info.add(new JLabel("연락처"));
		for (int i=0; i<16; i++)
			info.add(new JTextField(""));
		
		JPanel buttons = new JPanel(); //버튼
		buttons.add(new JButton("추가"));
		buttons.add(new JButton("취소"));
		
		c.add(title, BorderLayout.NORTH); //컨테이너에 저장
		c.add(info, BorderLayout.CENTER);
		c.add(buttons, BorderLayout.SOUTH);
		
		setSize(300,200); //프레임 크기
		setVisible(true); //프레임을 화면에 출력
	}
	public static void main(String[] args) {
		new GridTest();
	}

}
