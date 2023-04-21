// 이유진 (2016133)
// 2021-12-03
// Lab12 - 실습 3~5. 메뉴, 툴팁, 다이얼로그 실습
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SwingTest extends JFrame{
	private JLabel lb = new JLabel("Text");
	
	public SwingTest() {
		setTitle("Menu 만들기 예제"); //타이틀
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		c.add(lb);
		
		createMenu(); //메뉴 생성, 프레임에 삽입(별도 메소드로)
		setSize(400,300);
		setVisible(true);
	}
	private void createMenu() { //메뉴 생성 메서드
		lb.setToolTipText("편집에 따라 변경될 영역입니다"); //툴팁
		JMenuBar mb = new JMenuBar();
		
		JMenu filemenu = new JMenu("파일");
		JMenuItem open = new JMenuItem("열기");
		filemenu.add(open);
		open.addActionListener(new openAction()); //리스너
		JMenuItem save = new JMenuItem("저장");
		filemenu.add(save);
		save.addActionListener(new saveAction()); //리스너
		filemenu.addSeparator(); //분리선 삽입
		JMenuItem exit = new JMenuItem("종료");
		filemenu.add(exit);
		exit.addActionListener(new showConfirmDialog()); //리스너
		mb.add(filemenu);
		
		JMenu editmenu = new JMenu("편집");
		JMenuItem choosecolor = new JMenuItem("색 선택");
		editmenu.add(choosecolor);
		choosecolor.addActionListener(new chooseColor()); //리스너
		JMenuItem choosefont = new JMenuItem("폰트");
		editmenu.add(choosefont);
		choosefont.addActionListener(new chooseFont()); //리스너
		JMenuItem changetext = new JMenuItem("텍스트 변경");
		editmenu.add(changetext);
		changetext.addActionListener(new showInputDialog()); //리스너
		mb.add(editmenu);
		
		JMenu helpmenu = new JMenu("도움말");
		JMenuItem versioninfo = new JMenuItem("버전 정보");
		helpmenu.add(versioninfo);
		versioninfo.addActionListener(new showMessageDialog()); //리스너
		mb.add(helpmenu);

		setJMenuBar(mb);
	}
//실습3
	class showConfirmDialog implements ActionListener{ //팝업 다이얼로그 "종료" 메뉴
		public void actionPerformed(ActionEvent e) {
			int result = JOptionPane.showConfirmDialog(null, "종료하시겠습니까?",
					"종료 확인", JOptionPane.YES_NO_OPTION);
			if (result == JOptionPane.YES_OPTION) //"예"버튼을 누른 경우
				System.exit(0); //프로그램 종료
		}
	}
	class showInputDialog implements ActionListener{ //팝업 다이얼로그 "텍스트 변경" 메뉴
		public void actionPerformed(ActionEvent e) {
			String text = JOptionPane.showInputDialog("변경할 텍스트를 입력하세요");
			if (text != null)
				lb.setText(text);
		}
	}
	class showMessageDialog implements ActionListener{//팝업 다이얼로그 "버전 정보" 메뉴
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null, "테스트 v1.0", "버전 정보",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}
//실습4
	class openAction implements ActionListener{//파일 다이얼로그 "열기" 메뉴
		private JFileChooser chooser;
		public openAction() {
			chooser = new JFileChooser();
		}
		public void actionPerformed(ActionEvent e) {
			int ret = chooser.showOpenDialog(null);
			if (ret != JFileChooser.APPROVE_OPTION) { //파일을 선택하지 않은 경우
				JOptionPane.showMessageDialog(null,  "파일을 선택하지 않았습니다", "경고",
						JOptionPane.WARNING_MESSAGE);
			}
			String filepath = chooser.getSelectedFile().getPath(); //경로 가져오기
			lb.setText(filepath+"파일이 선택되었습니다");
		}
		
	}
	class saveAction implements ActionListener{//파일 다이얼로그 "저장" 메뉴
		private JFileChooser chooser;
		public saveAction() {
			chooser = new JFileChooser();
		}
		public void actionPerformed(ActionEvent e) {
			int ret = chooser.showSaveDialog(null);
			if (ret != JFileChooser.APPROVE_OPTION) { //파일을 선택하지 않은 경우
				JOptionPane.showMessageDialog(null,  "파일을 선택하지 않았습니다", "경고",
						JOptionPane.WARNING_MESSAGE);
			}
			String filepath = chooser.getSelectedFile().getPath(); //경로 가져오기
			lb.setText(filepath+"파일에 저장되었습니다");
		}
	}
	class chooseColor implements ActionListener{//컬러 다이얼로그 "색 선택" 메뉴
		public void actionPerformed(ActionEvent e) {
			Color selected = JColorChooser.showDialog(null, "Color", Color.RED);
			if (selected != null)
				lb.setForeground(selected);
	}
}
//실습5
	class FontTest extends JDialog{ //모달다이얼로그
		JRadioButton gul, dod, gung; //폰트
		JCheckBox bold, italic; //스타일
		JTextField size, content; //사이즈, 내용
		JButton set; //설정 버튼
		
		int fsize, fstyle;
		String ffont;
		Font f = new Font(ffont, fstyle, fsize); //기본 설정;
		
		private String[] fonts = {"굴림", "돋움", "고딕", "명조"}; //폰트 배열
		
		public FontTest(JFrame frame, String title) {
			super(frame, title, true); //모달 다이얼로그로 설정
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			Container c = getContentPane();
			c.setLayout(new BorderLayout());
			
			JPanel west = new JPanel();
			GridLayout grid = new GridLayout(3, 1); 
			grid.setVgap(2); //행 간격
			west.setLayout(grid);
			west.add(new JLabel("폰트 종류")); //west판넬에 붙이기
			west.add(new JLabel("폰트 스타일"));
			west.add(new JLabel("폰트 크기"));
		
			JPanel center = new JPanel();
			center.setLayout(grid);
			
			JPanel font = new JPanel();
			JComboBox<String> fontCombo = new JComboBox<String>(fonts);
			for (int i=0; i<fonts.length; i++)
				fontCombo.addItem(fonts[i]);
			font.add(fontCombo);
			fontCombo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JComboBox<String> cb = (JComboBox<String>)e.getSource();
					int index = cb.getSelectedIndex();
			
					if (index == 0)	ffont = "굴림";
					else if (index == 1)	ffont = "돋움";
					else if (index == 2)	ffont = "고딕";
					else if (index == 3)	ffont = "명조";
				}});
			center.add(font); //center판넬에 붙이기

			
			JPanel style = new JPanel();
			bold = new JCheckBox("bold"); //체크박스
			italic = new JCheckBox("italic");
			style.add(bold); style.add(italic); //style판넬에 붙이기
			center.add(style); //center판넬에 붙이기
			bold.addItemListener(new myitemlistener());//리스너 달기
			italic.addItemListener(new myitemlistener()); 
			
			size = new JTextField(""); //텍스트필드
			center.add(size); //center판넬에 붙이기 
			size.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) { //리스너 달기
					fsize = Integer.parseInt(size.getText());
				}});
			
			JPanel south = new JPanel();
			set = new JButton("설정");
			south.add(set);
			set.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					lb.setFont(new Font(ffont, fstyle, fsize));
				}
			});
			
			c.add(west, BorderLayout.WEST); // 컨테이너에 저장
			c.add(center, BorderLayout.CENTER);
			c.add(south, BorderLayout.SOUTH);
			
			setSize(300, 250); //프레임 크기
			setVisible(false); //프레임을 화면에 출력
		}
		class myitemlistener implements ItemListener{
			public void itemStateChanged(ItemEvent e) {
				if (bold.isSelected() && !italic.isSelected())
					fstyle = Font.BOLD;
				else if (italic.isSelected() &&!bold.isSelected())
					fstyle = Font.ITALIC;
				else if (bold.isSelected() && italic.isSelected())
					fstyle = Font.BOLD + Font.ITALIC;
				else if (!bold.isSelected() && !italic.isSelected())
					fstyle = Font.PLAIN;
			}
		}
	}
	class chooseFont implements ActionListener{//다이얼로그 "폰트" 메뉴
		public void actionPerformed(ActionEvent e) {
			dialog.setVisible(true);
		}
	}
	public static void main(String[] args) {
		new SwingTest();
	}

}
