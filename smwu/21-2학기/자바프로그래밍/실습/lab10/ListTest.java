// 이유진 (2016133)
// 2021-11-19
// Lab10 - 실습 2. 리스트 추가 및 삭제
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;

public class ListTest extends JFrame {
	JTextField input = new JTextField(34);
	JTextField selected;
	Vector<String> v = new Vector<String>(); //벡터
	JList<String> list = new JList<String>(v); //리스트
	JButton btn1, btn2;
	
	public ListTest() {
		setTitle("리스트 테스트"); //타이틀
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		
		JPanel north = new JPanel();
		north.add(input);
		input.addActionListener(new ActionListener() {//익명 리스너 달기
			public void actionPerformed(ActionEvent e) {
				JTextField t = (JTextField)e.getSource();
				v.add(t.getText()); //추가하기
				t.setText(""); //초기화
				list.setListData(v); //덮어씌우기 -> 변경사항 반영
			}}); 
		
		JPanel center = new JPanel();
		list.setFixedCellHeight(20); //높이고정
		list.setFixedCellWidth(365); //너비고정
		center.add(new JScrollPane(list)); //스크롤 지원
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.addListSelectionListener(new ListListener()); //리스너달기
		
		JPanel south = new JPanel();
		south.setLayout(new GridLayout(1, 3));
		selected = new JTextField("");
		btn1 = new JButton("수정");
		btn2 = new JButton("삭제");
		south.add(selected); south.add(btn1); south.add(btn2);
		btn1.addActionListener(new listener()); //리스너 달기
		btn2.addActionListener(new listener());
		
		c.add(north, BorderLayout.NORTH); // 컨테이너에 저장
		c.add(center, BorderLayout.CENTER);
		c.add(south, BorderLayout.SOUTH);
		
		setSize(400,300); //프레임 크기
		setVisible(true); //프레임을 화면에 출력
	}
	class ListListener implements ListSelectionListener{ //리스트 항목 클릭 리스너
		public void valueChanged(ListSelectionEvent e) {
			String name = (String)list.getSelectedValue(); //선택된 값
			
			int index = list.getSelectedIndex(); //선택된 인덱스
			if (index != -1) //리스트중 선택한 경우
				selected.setText(name); //아래 텍스트필드에 해당 값 표시
			else//리스트 선택되지 않은 경우 공백으로
				selected.setText("");
		}
	}
	private class listener implements ActionListener{ //버튼 리스너
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton)e.getSource();
			if (b.getText().equals("수정")) //"수정"을 누르면 선택된 항목 수정
				v.set(list.getSelectedIndex(), selected.getText());
			else //"삭제"를 누르면 삭제
				v.remove(list.getSelectedIndex());
			list.setListData(v); //덮어씌우기		
		}
	}
	public static void main(String[] args) {
		new ListTest();
	}

}
