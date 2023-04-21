// 이유진 (2016133)
// 2021-11-19
// Lab10 - 실습 1. font 설정 화면
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;

public class FontTest extends JFrame{
	JRadioButton gul, dod, gung; //폰트
	JCheckBox bold, italic; //스타일
	JTextField size, content; //사이즈, 내용
	JLabel result; //결과

	int fsize=15, fstyle=Font.PLAIN;
	String ffont="";
	Font f = new Font(ffont, fstyle, fsize); //기본 설정;
	
	public FontTest() {
		setTitle("Font 설정"); //타이틀
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		
		JPanel west = new JPanel();
		GridLayout grid = new GridLayout(4, 1); 
		grid.setVgap(2); //행 간격
		west.setLayout(grid);
		west.add(new JLabel("Font 설정")); //west판넬에 붙이기
		west.add(new JLabel("Style 설정"));
		west.add(new JLabel("Size 설정"));
		west.add(new JLabel("Text 내용"));
		
		JPanel center = new JPanel();
		center.setLayout(grid);
		
		JPanel font = new JPanel();
		ButtonGroup g = new ButtonGroup(); //라디오버튼그룹
		gul = new JRadioButton("굴림"); //라디오버튼
		dod = new JRadioButton("돋움"); 
		gung = new JRadioButton("궁서");
		g.add(gul);	g.add(dod); g.add(gung); //라디오버튼그룹으로 묶기
		font.add(gul); font.add(dod); font.add(gung); //font판넬에 붙이기
		center.add(font); //center판넬에 붙이기
		gul.addItemListener(new listener1()); dod.addItemListener(new listener1());
		gung.addItemListener(new listener1()); //리스너붙이기
		
		JPanel style = new JPanel();
		bold = new JCheckBox("BOLD"); //체크박스
		italic = new JCheckBox("ITALIC");
		style.add(bold); style.add(italic); //style판넬에 붙이기
		center.add(style); //center판넬에 붙이기
		bold.addItemListener(new listener2());//리스너 달기
		italic.addItemListener(new listener2()); 
		
		size = new JTextField("15"); //텍스트필드
		center.add(size); //center판넬에 붙이기 
		size.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { //리스너 달기
				fsize = Integer.parseInt(size.getText());
				result.setFont(new Font(ffont, fstyle, fsize));
			}});
		
		content = new JTextField("Hello World"); //텍스트필드, 초기 설정
		center.add(content);//center판넬에 붙이기
		content.addActionListener(new ActionListener() { //리스너 달기
			public void actionPerformed(ActionEvent e) {
				result.setText(content.getText());
				result.setFont(new Font(ffont, fstyle, fsize));
			}});
		
		JPanel south = new JPanel();
		Border resultBorder = BorderFactory.createTitledBorder("Font 설정 결과"); //제목이 붙여진 경계 생성 
		result = new JLabel(content.getText());
		result.setFont(f);
		south.setBorder(resultBorder); //south판넬에 붙이기
		south.add(result);
		
		c.add(west, BorderLayout.WEST); // 컨테이너에 저장
		c.add(center, BorderLayout.CENTER);
		c.add(south, BorderLayout.SOUTH);
		
		setSize(300, 250); //프레임 크기
		setVisible(true); //프레임을 화면에 출력
	}
	class listener1 implements ItemListener{
		public void itemStateChanged(ItemEvent e) {
			if (e.getStateChange() == ItemEvent.DESELECTED)	return; //해제된 상태라면 빠져나가기
			if (gul.isSelected())
				ffont = "굴림체";
			else if (dod.isSelected())
				ffont = "돋움체";
			else if (gung.isSelected())
				ffont = "궁서체";
			result.setFont(new Font(ffont, fstyle, fsize));
		}
	}
	class listener2 implements ItemListener{
		public void itemStateChanged(ItemEvent e) {
			if (bold.isSelected() && !italic.isSelected())
				fstyle = Font.BOLD;
			else if (italic.isSelected() &&!bold.isSelected())
				fstyle = Font.ITALIC;
			else if (bold.isSelected() && italic.isSelected())
				fstyle = Font.BOLD + Font.ITALIC;
			else if (!bold.isSelected() && !italic.isSelected())
				fstyle = Font.PLAIN;
			result.setFont(new Font(ffont, fstyle, fsize));
		}
	}
	public static void main(String[] args) {
		new FontTest();
	}

}
