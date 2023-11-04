//컴퓨터과학과 2016133 이유진
//기말프로젝트
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.*;

public class MyNotes extends JFrame{
	JLabel now = new JLabel(); //오른쪽 상단 시계
	private Addinput dialog; //모달다이얼로그

	public MyNotes() {
		dialog = new Addinput(this, "입력");
//창 정보
		setTitle("JAVA 004 2016133 이유진"); //타이틀
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new BorderLayout());

//north패널, 제목과 앱을 실행하는 동안 현재 시간을 보여줌
		JPanel north = new JPanel(); 
		north.setLayout(new BorderLayout(150,0));
		JLabel mynotes = new JLabel("My Notes"); //왼쪽 상단 제목 My Notes
		mynotes.setFont(new Font("고딕", Font.ITALIC+Font.BOLD, 30));
		mynotes.setForeground(Color.BLUE);
		now.setFont(new Font("굴림", Font.ITALIC, 20)); //오른쪽 상단 시계 폰트 조정
		JLabel blank = new JLabel(""); //왼쪽 공백을 위한 빈 패널
		
//west패널, 탭팬과 '추가'버튼, 객체배열과 리스트 이용	
		JPanel west = new JPanel(); 
		west.setLayout(new BorderLayout());
		JTabbedPane pane = new JTabbedPane(JTabbedPane.TOP); //탭팬

		JScrollPane all = new JScrollPane(new JTextArea(30, 30)); //'전체' 탭팬
		pane.addTab("전체", all);
		String [] allofthem = {};
		
		JScrollPane movie = new JScrollPane(new JTextArea(30, 30)); //'영화' 탭팬
		pane.addTab("영화", movie);
		String [] movies = {};
		
		JScrollPane book = new JScrollPane(new JTextArea(30, 30)); //'도서'탭팬
		pane.addTab("도서", book);
		String [] books = {};
		
		JPanel searchpan = new JPanel(); //'검색' 탭팬
		searchpan.setLayout(new BorderLayout());
		JPanel searchbar = new JPanel();
		String [] searches = {"제목", "별점"};
		JComboBox<String> searchcombo = new JComboBox<String>(searches);
		JTextArea searchinput = new JTextArea(1, 20);
		JButton searchclick = new JButton("검색");
		searchbar.add(searchcombo); searchbar.add(searchinput); searchbar.add(searchclick);
		JScrollPane search = new JScrollPane(new JTextArea(30, 30));
		searchpan.add(searchbar, BorderLayout.NORTH);
		searchpan.add(search, BorderLayout.CENTER);
		pane.addTab("검색", searchpan);
		
		JPanel onebutton = new JPanel(); //추가 버튼을 붙이기 위한 패널
		JButton addition = new JButton("추가");
		addition.addActionListener(new ActionListener() { //리스너
			public void actionPerformed(ActionEvent e) {
				dialog.setVisible(true);
			}});
//center패널, 상세보기, 줄거리, 감상평		
		JPanel center = new JPanel(); 
		center.setLayout(new BorderLayout());
		
		JPanel contents = new JPanel();
		contents.setLayout(new GridLayout(3,1));
		Border viewdetails = BorderFactory.createTitledBorder("상세 보기"); //제목이 붙여진 경계 생성
		contents.setBorder(viewdetails);
		
		JPanel content1 = new JPanel(); //이미지+상세정보
		content1.setLayout(new BorderLayout());
		JLabel image = new JLabel(); //이미지
		JPanel detailinfo = new JPanel(); //상세정보
		
		JPanel content2 = new JPanel(); //줄거리
		content2.setLayout(new GridLayout());
		Border summary = BorderFactory.createTitledBorder("줄거리"); //제목이 붙여진 경계 생성
		JTextField summarytext = new JTextField("");
		
		JPanel content3 = new JPanel(); //감상평
		content3.setLayout(new GridLayout());
		Border review = BorderFactory.createTitledBorder("감상평"); //제목이 붙여진 경계 생성
		JTextField reviewtext = new JTextField("");
		
		JPanel twobuttons = new JPanel();//수정, 삭제 버튼을 붙이기 위한 패널
		twobuttons.setLayout(new FlowLayout()); 
		JButton correction = new JButton("수정");
		JButton delete = new JButton("삭제");
		
		//붙이기
		content1.add(image, BorderLayout.WEST); content1.add(detailinfo, BorderLayout.CENTER);
		content2.setBorder(summary); content2.add(summarytext);
		content3.setBorder(review); content3.add(reviewtext);
		contents.add(content1); contents.add(content2); contents.add(content3);
		onebutton.add(addition);
		twobuttons.add(correction); twobuttons.add(delete);
		north.add(mynotes, BorderLayout.CENTER); north.add(now, BorderLayout.EAST); north.add(blank, BorderLayout.WEST);
		west.add(pane, BorderLayout.CENTER); west.add(onebutton, BorderLayout.SOUTH);
		center.add(twobuttons, BorderLayout.SOUTH); center.add(contents, BorderLayout.CENTER);
		c.add(north, BorderLayout.NORTH); c.add(west, BorderLayout.WEST);
		c.add(center, BorderLayout.CENTER);
		
		createMenu(); //메뉴만들기
		
		setSize(1000, 800); setVisible(true);
		Timethread th = new Timethread();
		th.start();
	}
//메뉴만들기 메서드
	private void createMenu() { 
		JMenuBar mb = new JMenuBar();
		JMenu file = new JMenu("파일");
		JMenu help = new JMenu("도움말");
		
		JMenuItem get = new JMenuItem("불러오기"); //메뉴-파일-불러오기
		get.addActionListener(new openAction()); //리스너
		
		JMenuItem save = new JMenuItem("저장하기"); //메뉴-파일-저장하기
		save.addActionListener(new saveAction());//리스너
		
		JMenuItem exit = new JMenuItem("종료"); //메뉴-파일-종료
		exit.addActionListener(new ActionListener() { //리스너
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "종료하시겠습니까?",
						"종료 확인", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION) //"예"버튼을 누른 경우
					System.exit(0); //프로그램 종료
			}});
		
		JMenuItem systeminfo = new JMenuItem("시스템 정보"); //메뉴-도움말-시스템정보
		systeminfo.addActionListener(new ActionListener() { //리스너
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,  "MyNotes 시스템 v 1.0 입니다.", "Message",
						JOptionPane.INFORMATION_MESSAGE);
			}});
		
		file.add(get); file.add(save); file.add(exit); help.add(systeminfo);
		mb.add(file); mb.add(help);
		setJMenuBar(mb);
	}
	
//오른쪽 상단 시계, 스레드로 작성	
	public class Timethread extends Thread{ 
		public void run() {
			while(true) {
				Calendar calendar = Calendar.getInstance();
				int year = calendar.get(Calendar.YEAR);
				int month = calendar.get(Calendar.MONTH)+1; //0부터 시작하기 때문
				int date = calendar.get(Calendar.DATE);
				int hour = calendar.get(Calendar.HOUR_OF_DAY);
				int min = calendar.get(Calendar.MINUTE);
				int sec = calendar.get(Calendar.SECOND);
				String st = year+"년 "+month+"월 "+date+"일 "+hour+":"+min+":"+sec;
				now.setText(st);
				try {Thread.sleep(1000);}
				catch(InterruptedException e) {return;}
			}
		}
	}
	
//파일 다이얼로그 메뉴-파일-불러오기
	class openAction implements ActionListener{
		private JFileChooser chooser;
		public openAction() {chooser = new JFileChooser();}
		public void actionPerformed(ActionEvent e) {
			int ret = chooser.showOpenDialog(null);
			if (ret != JFileChooser.APPROVE_OPTION) { //파일을 선택하지 않은 경우
				JOptionPane.showMessageDialog(null,  "파일을 선택하지 않았습니다", "경고",
						JOptionPane.WARNING_MESSAGE);
			}
		}
	}
	
//파일 다이얼로그 메뉴-파일-저장하기	
	class saveAction implements ActionListener{
		private JFileChooser chooser;
		public saveAction() {chooser = new JFileChooser();}
		public void actionPerformed(ActionEvent e) {
			int ret = chooser.showSaveDialog(null);
			if (ret != JFileChooser.APPROVE_OPTION) { //파일을 선택하지 않은 경우
				JOptionPane.showMessageDialog(null,  "파일을 선택하지 않았습니다", "경고",
						JOptionPane.WARNING_MESSAGE);
			}
		}
	}
//'추가'버튼을 눌렀을 경우 뜨는 입력창: 모달 다이얼로그
	class Addinput extends JDialog{
		Border info; //제목이 붙여진 경계 생성
		Border info0;
		JPanel north = new JPanel(); //movie, book중 선택(라디오버튼)
		private JButton ok = new JButton("OK");
		private JButton ok0 = new JButton("OK");
		ButtonGroup group = new ButtonGroup();
		JRadioButton movie = new JRadioButton("Movie", true);
		JRadioButton book = new JRadioButton("Book");
		
	//movie를 선택했을 경우 이용하는 패널과 라벨들
		JPanel center = new JPanel();
		JPanel centertotal = new JPanel();
		JPanel center1 = new JPanel(); //제목~별점
		JPanel center1_1 = new JPanel();
		JPanel center1_2 = new JPanel();
		JPanel center2 = new JPanel(); //줄거리~감상평
		JPanel center2_1 = new JPanel();
		JPanel center2_2 = new JPanel();
		JPanel center3 = new JPanel(); //ok버튼
		
		JLabel a1 = new JLabel("제목"); JLabel a2 = new JLabel("감독");
		JLabel a3 = new JLabel("배우"); JLabel a4 = new JLabel("장르");
		JLabel a5 = new JLabel("등급"); JLabel a6 = new JLabel("개봉년도");
		JLabel a7 = new JLabel("포스터"); JLabel a8 = new JLabel("별점");
		JLabel a9 = new JLabel("줄거리"); JLabel a10 = new JLabel("감상평");
		JTextField mvtitle = new JTextField(""); //제목
		JTextField director = new JTextField(""); //감독
		JTextField actor = new JTextField(""); //배우
		String[] genres = {"드라마", "미스터리, 스릴러", "코미디", "공포", "전쟁", "SF", "스포츠"}; //장르
		JComboBox<String> genre = new JComboBox<String>(genres);
		String[] ratings = {"전체", "12세 이상", "15세 이상", "청소년 관람 불가"}; //등급
		JComboBox<String> rating = new JComboBox<String>(ratings);
		JPanel pp = new JPanel(); //포스터
		JTextArea imglink = new JTextArea(1, 10);
		JButton getimg = new JButton("불러오기");
		JSlider slider = new JSlider(JSlider.HORIZONTAL, 1, 10, 5); //별점
		JScrollPane summary = new JScrollPane(new JTextArea(5, 30)); //줄거리
		JScrollPane review = new JScrollPane(new JTextArea(5, 30)); //감상평

	//book을 선택했을 경우 이용하는 패널과 라벨들
		JPanel center0 = new JPanel();
		JPanel centertotal0 = new JPanel();
		JPanel center01 = new JPanel(); //제목~별점
		JPanel center01_1 = new JPanel();
		JPanel center01_2 = new JPanel();
		JPanel center02 = new JPanel(); //책소개~감상평
		JPanel center02_1 = new JPanel();
		JPanel center02_2 = new JPanel();
		JPanel center03 = new JPanel(); //ok버튼
		
		JLabel b1 = new JLabel("제목"); JLabel b2 = new JLabel("저자");
		JLabel b3 = new JLabel("출판사"); JLabel b4 = new JLabel("출판년도");
		JLabel b5 = new JLabel("책이미지"); JLabel b6 = new JLabel("별점");
		JLabel b7 = new JLabel("책소개"); JLabel b8 = new JLabel("감상평");
		JTextField booktitle = new JTextField(""); //제목
		JTextField author = new JTextField(""); //저자
		JTextField publisher = new JTextField(""); //출판사
		JPanel bp = new JPanel(); //책이미지
		JTextArea bimglink = new JTextArea(1, 10);
		JButton bgetimg = new JButton("불러오기");
		JSlider bslider = new JSlider(JSlider.HORIZONTAL, 1, 10, 5); //별점
		JTextArea introducing = new JTextArea(5, 30); //책소개
		JTextArea bookreview = new JTextArea(5, 30); //감상평
	
		public Addinput(JFrame frame, String title) {
			super(frame, title, true); //모달 다이얼로그로 설정
			setLayout(new BorderLayout());
			movie.addItemListener(new AddinputListener()); //리스너
			book.addItemListener(new AddinputListener());
			group.add(movie); group.add(book); north.add(movie); north.add(book);
			
			ok.addActionListener(new ActionListener() { //리스너
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
				}});
			ok0.addActionListener(new ActionListener() { //리스너
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
				}});
			getimg.addActionListener(new ActionListener() { //리스너
				JFileChooser chooser = new JFileChooser();
				public void actionPerformed(ActionEvent e) {
					int ret = chooser.showOpenDialog(null);
					if (ret == JFileChooser.APPROVE_OPTION) {
						String pathName = chooser.getSelectedFile().getPath();
						imglink.setText(pathName);
					}
				}});
			imglink.setEditable(false); //편집불가능
			bgetimg.addActionListener(new ActionListener() { //리스너
				JFileChooser chooser = new JFileChooser();
				public void actionPerformed(ActionEvent e) {
					int ret = chooser.showOpenDialog(null);
					if (ret == JFileChooser.APPROVE_OPTION) {
						String pathName = chooser.getSelectedFile().getPath();
						bimglink.setText(pathName);
					}
				}});
			bimglink.setEditable(false); //편집불가능
			int releases[] = new int[32]; //개봉년도
			for (int i=0; i<32; i++)	releases[i] = 2021-i;
			JComboBox<Integer> release = new JComboBox<Integer>();
			for (int i=0; i<32; i++)	release.addItem(releases[i]);
			slider.setPaintLabels(true); slider.setPaintTrack(true); slider.setMajorTickSpacing(1);
			
			int breleases[] = new int[32]; //출판년도
			for (int i=0; i<32; i++)	breleases[i] = 2021-i;
			JComboBox<Integer> brelease = new JComboBox<Integer>();
			for (int i=0; i<32; i++)	brelease.addItem(breleases[i]);
			bslider.setPaintLabels(true); bslider.setPaintTrack(true); bslider.setMajorTickSpacing(1);
		
			center.setLayout(new BorderLayout());
	//movie를 선택했을 경우 이용하는 패널	
			center1.setLayout(new BorderLayout());
			center1_1.setLayout(new GridLayout(8, 1, 5, 5));
			center1_2.setLayout(new GridLayout(8, 1, 5, 5));
			center2.setLayout(new BorderLayout());
			center2_1.setLayout(new GridLayout(2, 1, 5, 5));
			center2_2.setLayout(new GridLayout(2, 1, 5, 5));
	
	//book을 선택했을 경우 이용하는 패널
			center0.setLayout(new BorderLayout());
			center01.setLayout(new BorderLayout());
			center01_1.setLayout(new GridLayout(6, 1, 5, 5));
			center01_2.setLayout(new GridLayout(6, 1, 5, 5));
			center02.setLayout(new BorderLayout());
			center02_1.setLayout(new GridLayout(2, 1, 5, 5));
			center02_2.setLayout(new GridLayout(2, 1, 5, 5));
			
			//붙이기
			add(north, BorderLayout.NORTH);
			
			center3.add(ok);
			center.add(center3, BorderLayout.SOUTH);
			center.setBorder(info);
			center1_1.add(a1); center1_2.add(mvtitle); center1_1.add(a2); center1_2.add(director);
			center1_1.add(a3); center1_2.add(actor); center1_1.add(a4); center1_2.add(genre);
			center1_1.add(a5); center1_2.add(rating); center1_1.add(a6); center1_2.add(release);
			center1_1.add(a7); center1_2.add(pp); center1_1.add(a8); center1_2.add(slider);
			pp.add(imglink); pp.add(getimg);
			center1.add(center1_1, BorderLayout.WEST); center1.add(center1_2, BorderLayout.CENTER);
			center2_1.add(a9); center2_1.add(a10); center2_2.add(summary); center2_2.add(review);
			center2.add(center2_1, BorderLayout.WEST); center2.add(center2_2, BorderLayout.CENTER);
			centertotal.add(center1); centertotal.add(center2);
			center.add(centertotal, BorderLayout.CENTER);
			add(center, BorderLayout.CENTER);
			info = BorderFactory.createTitledBorder("영화 정보"); center.setBorder(info);
			
			center03.add(ok0); center0.add(center03, BorderLayout.SOUTH);
			center01_1.add(b1); center01_1.add(b2); center01_1.add(b3); 
			center01_1.add(b4); center01_1.add(b5); center01_1.add(b6);
			center01_2.add(booktitle); center01_2.add(author); center01_2.add(publisher);
			center01_2.add(brelease); center01_2.add(bp); center01_2.add(bslider);
			bp.add(bimglink); bp.add(bgetimg);
			center01.add(center01_1, BorderLayout.WEST); center01.add(center01_2, BorderLayout.CENTER);
			center02_1.add(b7); center02_1.add(b8); center02_2.add(introducing); center02_2.add(bookreview);
			center02.add(center02_1, BorderLayout.WEST); center02.add(center02_2, BorderLayout.CENTER);
			centertotal0.add(center01); centertotal0.add(center02);
			center0.add(centertotal0, BorderLayout.CENTER);	

			center.setVisible(true);
			center0.setVisible(false);
			setSize(450, 700);
			setVisible(false);
		}
		class AddinputListener implements ItemListener{ //모달다이얼로그 라디오버튼 리스너
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.DESELECTED)	return;
				if (movie.isSelected()) { //movie를 선택한 경우
					add(center, BorderLayout.CENTER);
					info = BorderFactory.createTitledBorder("영화 정보"); center.setBorder(info);
					center0.setVisible(false);
					center.setVisible(true);
				}
				else { //book을 선택한 경우
					add(center0, BorderLayout.CENTER);
					info0 = BorderFactory.createTitledBorder("도서 정보"); center0.setBorder(info0);
					center.setVisible(false);
					center0.setVisible(true);
				}
			}
		}
	}
	abstract class Item{ //추상 클래스
		String text;
		int value;
		String title, release, imglink, slider, summary, review;
		
		public void getText(String text) {this.text = text;};
		public void getValue(int value) {this.value = value;};
		
		public abstract void setTitle(String title);
		public abstract void setRelease(String release);
		public abstract void setImgLink(String imglink);
		public abstract void setSlider(String slider);
		public abstract void setSummary(String summary);
		public abstract void setReview(String review);
		
		public abstract void setDirector(String director);
		public abstract void setActor(String actor);
		public abstract void setGenre(String genre);
		public abstract void setRating(String rating);
		public abstract void setAuthor(String author);
		public abstract void setPublisher(String publisher);
	}
	class Movie extends Item{
		String string;
		int integer;
		String mvtitle, director, actor, genre, rating, release, imglink, slider, summary, review;
	
		public void setTitle(String title) {
			this.mvtitle = title;
			
		}
		public void setDirector(String director) {
			this.director = director;
		}
		public void setActor(String actor) {
			this.actor = actor;
		}
		public void setGenre(String genre) {
			this.genre = genre;
		}
		public void setRating(String rating) {
			this.rating = rating;
		}
		public void setRelease(String release) {
			this.release = release;
		}
		public void setImgLink(String imglink) {
			this.imglink = imglink;
		}
		public void setSlider(String slider) {
			this.slider = slider;
		}
		public void setSummary(String summary) {
			this.summary = summary;
		}
		public void setReview(String review) {
			this.review = review;
		}
		
		public void setAuthor(String author) {}
		public void setPublisher(String publisher) {}
		
	}
	class Book extends Item{
		String booktitle, author, publisher, brelease, bimglink, bslider, introducing, bookreview;
		public void setTitle(String title) {
			this.booktitle = title;
		}
		public void setAuthor(String author) {
			this.author = author;
		}
		public void setPublisher(String publisher) {
			this.publisher = publisher;
		}
		public void setRelease(String release) {
			this.brelease = release;
		}
		public void setImgLink(String imglink) {
			this.bimglink = imglink;
		}
		public void setSlider(String slider) {
			this.bslider = slider;
		}
		public void setSummary(String summary) {
			this.introducing = summary;
		}
		public void setReview(String review) {
			this.bookreview = review;
		}

		public void setDirector(String director) {}
		public void setActor(String actor) {}
		public void setGenre(String genre) {}
		public void setRating(String rating) {}
	}
	class ItemCollections{ //Vector 또는 ArrayList로 Item 정의
		//Item을 등록, 수정, 삭제, 검색하는 등의 메소드를 작성
	}
	public static void main(String[] args) {
		new MyNotes();
	}
}
