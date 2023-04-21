// 이유진 (2016133)
// 2021-11-19
// Lab10 - 실습 5. 레이블 클릭 게임 실습
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LabelClick extends JFrame{
	JLabel [] lb = new JLabel[10];
	int idx = 0;
	
	public LabelClick() {
		setTitle("Ten 레이블 클릭"); //타이틀
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(null); //레이아웃 삭제
		MyMouseAdapter m = new MyMouseAdapter(0); //리스너
		
		for (int i=0; i<lb.length; i++) {
			int x = (int)(Math.random()*250)+20; //랜덤정수로 위치 좌표 설정
			int y = (int)(Math.random()*250)+20;
			
			lb[i] = new JLabel(Integer.toString(i));
			lb[i].setForeground(Color.MAGENTA); //글씨 색상
			lb[i].setLocation(x, y); //위치
			lb[i].setSize(25, 25); //크기
			lb[i].addMouseListener(m);
			c.add(lb[i]); //컨테이너에 붙이기
		}
		setSize(300, 300); //프레임 크기
		setVisible(true); //프레임을 화면에 출력
	}
	class MyMouseAdapter extends MouseAdapter{
		int idx;
		public MyMouseAdapter(int idx) { //생성자로 초기화
			this.idx = idx;
		}
		public void mouseClicked(MouseEvent e) {
	    	JLabel temp = (JLabel)e.getSource();
	        if(Integer.parseInt(temp.getText()) == this.idx){
	            temp.setVisible(false);
	            this.idx++;
	        }
	        if(this.idx == lb.length){
	            this.idx = 0;
	            new LabelClick();
	        }
		}
	}
	public static void main(String[] args) {
		new LabelClick();
	}
}
