// 이유진 (2016133)
// 2021-11-19
// Lab10 - 실습 3. 슬라이더 테스트
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SliderTest extends JFrame{
	JTextArea ta = new JTextArea(5,30);
	JSlider sl = new JSlider(JSlider.HORIZONTAL, 0, 100, 0); //수평슬라이더, 초기값 0
	
	public SliderTest() {
		setTitle("TextArea Practice Frame"); //타이틀
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		
		sl.setMajorTickSpacing(20); //큰 눈금
		sl.setMinorTickSpacing(5); //작은 눈금
		sl.setPaintTicks(true); //tick 보이기
		sl.setPaintTrack(true); //track 보이기
		sl.setPaintLabels(true); //label 보이기
		sl.addChangeListener(new MyChangeListener()); //리스너 달기
		
		ta.addKeyListener(new KeyAdapter() { //익명 어댑터 붙이기
			public void keyTyped(KeyEvent e) {
				sl.setValue(ta.getText().length()); //글자수만큼 슬라이드
				
				if(ta.getText().length()>=100) //100자 이상 입력할 경우
					ta.setText(ta.getText().substring(0,99)); //뒷부분을 자른다		 
			}
		});
		
		c.add(ta, BorderLayout.NORTH); //컨테이너에 붙이기
		c.add(sl, BorderLayout.SOUTH);
		
		setSize(350, 200); //프레임 크기
		setVisible(true); //프레임을 화면에 출력
	}
	class MyChangeListener implements ChangeListener{
		public void stateChanged(ChangeEvent e) {
			if (ta.getText().length() >= sl.getValue()) //슬라이드를 줄이면 텍스트가 잘림
				ta.setText(ta.getText().substring(0, sl.getValue()));
			else
				sl.setValue(ta.getText().length()); //슬라이드는 글자수보다 클 수 없음
		}
	}
	public static void main(String[] args) {
		new SliderTest();
	}

}
