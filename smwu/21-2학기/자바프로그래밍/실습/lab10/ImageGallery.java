// 이유진 (2016133)
// 2021-11-19
// Lab10 - 실습 4. 이미지 갤러리 만들기
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.*;

import javax.swing.*;

public class ImageGallery extends JFrame{
	JRadioButton left, right;
	int next = -1; //계속 더해주는 변수, left가 초기화 상태이므로 -1
	int now = 0;
	
	public ImageGallery() {
		setTitle("Image Gallery Practice Frame"); //타이틀
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		
		JPanel north = new JPanel();
		ButtonGroup g = new ButtonGroup(); //라디오버튼그룹
		left = new JRadioButton("left", true); //라디오버튼, 선택된 상태로 초기화
		right = new JRadioButton("right"); 
		g.add(left); g.add(right); //라디오버튼그룹으로 묶기
		north.add(left); north.add(right); //north판넬에 붙이기
		left.addItemListener(new MyItemListener()); //리스너 달기
	    right.addItemListener(new MyItemListener());

		File f = new File("images");
		File files[] = f.listFiles(); //파일리스트 얻기
		Vector<ImageIcon> imgicon = new Vector<ImageIcon>();
		for (int i=0; i<files.length; i++) {
			ImageIcon img = new ImageIcon(files[i].getPath()); //로딩
			imgicon.add(img); //벡터컬렉션에 저장
		}
		
		JPanel center = new JPanel();
		JLabel lb = new JLabel();
		lb.setIcon(imgicon.get(0)); //초기화면 설정
		center.add(lb); //center판넬에 붙이기
		lb.addMouseListener(new MouseAdapter() { //익명 어댑터 달기 -> 클릭
			public void mouseClicked(MouseEvent e) {
				now += next; //다음인덱스로 넘기기
				if (now >= 0)
					lb.setIcon(imgicon.get(now % imgicon.size())); //나머지연산 이용
				else {
					now = imgicon.size()-1; //회전하도록 초기화
					lb.setIcon(imgicon.get(now));
				}
			}
		});
		
		c.add(north, BorderLayout.NORTH); //컨테이너에 저장
		c.add(center, BorderLayout.CENTER);
		
		setSize(500, 470); //프레임 크기
		setVisible(true); //프레임을 화면에 출력
	}
	class MyItemListener implements ItemListener{
		@Override
		public void itemStateChanged(ItemEvent e) {
			 if(e.getStateChange() == ItemEvent.DESELECTED)	return; //선택 해제한 경우
			 if (left.isSelected())	next = -1; //left가 선택됐을 경우
			 else	next = 1; //right가 선택됐을 경우
		}
	}
	public static void main(String[] args) {
		new ImageGallery();
	}

}
