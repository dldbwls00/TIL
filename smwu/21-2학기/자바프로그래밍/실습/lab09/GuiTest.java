// 이유진 (2016133)
// 2021-11-12
// Lab09 - 실습 1. GUI 작성
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GuiTest extends JFrame{
	JTextField tf1 = new JTextField(20); //텍스트
	JTextField tf2 = new JTextField(20);
	JTextField tf3 = new JTextField(20);
	JTextField tf4 = new JTextField(20);
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
		textfields.add(tf1);
		textfields.add(tf2);
		textfields.add(tf3);
		textfields.add(tf4);
		
		JPanel buttons = new JPanel();
		JButton btn1 = new JButton("확인");//버튼
		JButton btn2 = new JButton("취소");
		buttons.add(btn1); 
		buttons.add(btn2);
		btn1.addActionListener(new MyActionListener()); //리스너 달기
		btn2.addActionListener(new MyActionListener());
		
		JPanel north = new JPanel(); //위쪽 공백
		north.add(new JLabel(""));
		
		c.add(north, BorderLayout.NORTH); //컨테이너에 저장
		c.add(labels, BorderLayout.WEST);
		c.add(textfields, BorderLayout.CENTER);
		c.add(buttons, BorderLayout.SOUTH);
		
		setSize(300,200); //프레임 크기
		setVisible(true); //프레임을 화면에 출력
	}
	private class MyActionListener implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton)e.getSource();
		if (b.getText().equals("확인")) { //"확인"을 누르면 콘솔에 출력
			System.out.println(tf1.getText()+"\t"+tf2.getText()+"\t"+tf3.getText()+"\t"+tf4.getText());
		}
		else { //"취소"를 누르면 초기화
			tf1.setText("");
			tf2.setText("");
			tf3.setText("");
			tf4.setText("");
		}
	}
}
	public static void main(String[] args) {
		new GuiTest();
	}

}




