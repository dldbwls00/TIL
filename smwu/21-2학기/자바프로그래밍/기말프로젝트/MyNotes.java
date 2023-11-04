//��ǻ�Ͱ��а� 2016133 ������
//�⸻������Ʈ
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.*;

public class MyNotes extends JFrame{
	JLabel now = new JLabel(); //������ ��� �ð�
	private Addinput dialog; //��޴��̾�α�

	public MyNotes() {
		dialog = new Addinput(this, "�Է�");
//â ����
		setTitle("JAVA 004 2016133 ������"); //Ÿ��Ʋ
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new BorderLayout());

//north�г�, ����� ���� �����ϴ� ���� ���� �ð��� ������
		JPanel north = new JPanel(); 
		north.setLayout(new BorderLayout(150,0));
		JLabel mynotes = new JLabel("My Notes"); //���� ��� ���� My Notes
		mynotes.setFont(new Font("���", Font.ITALIC+Font.BOLD, 30));
		mynotes.setForeground(Color.BLUE);
		now.setFont(new Font("����", Font.ITALIC, 20)); //������ ��� �ð� ��Ʈ ����
		JLabel blank = new JLabel(""); //���� ������ ���� �� �г�
		
//west�г�, ���Ұ� '�߰�'��ư, ��ü�迭�� ����Ʈ �̿�	
		JPanel west = new JPanel(); 
		west.setLayout(new BorderLayout());
		JTabbedPane pane = new JTabbedPane(JTabbedPane.TOP); //����

		JScrollPane all = new JScrollPane(new JTextArea(30, 30)); //'��ü' ����
		pane.addTab("��ü", all);
		String [] allofthem = {};
		
		JScrollPane movie = new JScrollPane(new JTextArea(30, 30)); //'��ȭ' ����
		pane.addTab("��ȭ", movie);
		String [] movies = {};
		
		JScrollPane book = new JScrollPane(new JTextArea(30, 30)); //'����'����
		pane.addTab("����", book);
		String [] books = {};
		
		JPanel searchpan = new JPanel(); //'�˻�' ����
		searchpan.setLayout(new BorderLayout());
		JPanel searchbar = new JPanel();
		String [] searches = {"����", "����"};
		JComboBox<String> searchcombo = new JComboBox<String>(searches);
		JTextArea searchinput = new JTextArea(1, 20);
		JButton searchclick = new JButton("�˻�");
		searchbar.add(searchcombo); searchbar.add(searchinput); searchbar.add(searchclick);
		JScrollPane search = new JScrollPane(new JTextArea(30, 30));
		searchpan.add(searchbar, BorderLayout.NORTH);
		searchpan.add(search, BorderLayout.CENTER);
		pane.addTab("�˻�", searchpan);
		
		JPanel onebutton = new JPanel(); //�߰� ��ư�� ���̱� ���� �г�
		JButton addition = new JButton("�߰�");
		addition.addActionListener(new ActionListener() { //������
			public void actionPerformed(ActionEvent e) {
				dialog.setVisible(true);
			}});
//center�г�, �󼼺���, �ٰŸ�, ������		
		JPanel center = new JPanel(); 
		center.setLayout(new BorderLayout());
		
		JPanel contents = new JPanel();
		contents.setLayout(new GridLayout(3,1));
		Border viewdetails = BorderFactory.createTitledBorder("�� ����"); //������ �ٿ��� ��� ����
		contents.setBorder(viewdetails);
		
		JPanel content1 = new JPanel(); //�̹���+������
		content1.setLayout(new BorderLayout());
		JLabel image = new JLabel(); //�̹���
		JPanel detailinfo = new JPanel(); //������
		
		JPanel content2 = new JPanel(); //�ٰŸ�
		content2.setLayout(new GridLayout());
		Border summary = BorderFactory.createTitledBorder("�ٰŸ�"); //������ �ٿ��� ��� ����
		JTextField summarytext = new JTextField("");
		
		JPanel content3 = new JPanel(); //������
		content3.setLayout(new GridLayout());
		Border review = BorderFactory.createTitledBorder("������"); //������ �ٿ��� ��� ����
		JTextField reviewtext = new JTextField("");
		
		JPanel twobuttons = new JPanel();//����, ���� ��ư�� ���̱� ���� �г�
		twobuttons.setLayout(new FlowLayout()); 
		JButton correction = new JButton("����");
		JButton delete = new JButton("����");
		
		//���̱�
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
		
		createMenu(); //�޴������
		
		setSize(1000, 800); setVisible(true);
		Timethread th = new Timethread();
		th.start();
	}
//�޴������ �޼���
	private void createMenu() { 
		JMenuBar mb = new JMenuBar();
		JMenu file = new JMenu("����");
		JMenu help = new JMenu("����");
		
		JMenuItem get = new JMenuItem("�ҷ�����"); //�޴�-����-�ҷ�����
		get.addActionListener(new openAction()); //������
		
		JMenuItem save = new JMenuItem("�����ϱ�"); //�޴�-����-�����ϱ�
		save.addActionListener(new saveAction());//������
		
		JMenuItem exit = new JMenuItem("����"); //�޴�-����-����
		exit.addActionListener(new ActionListener() { //������
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "�����Ͻðڽ��ϱ�?",
						"���� Ȯ��", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION) //"��"��ư�� ���� ���
					System.exit(0); //���α׷� ����
			}});
		
		JMenuItem systeminfo = new JMenuItem("�ý��� ����"); //�޴�-����-�ý�������
		systeminfo.addActionListener(new ActionListener() { //������
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,  "MyNotes �ý��� v 1.0 �Դϴ�.", "Message",
						JOptionPane.INFORMATION_MESSAGE);
			}});
		
		file.add(get); file.add(save); file.add(exit); help.add(systeminfo);
		mb.add(file); mb.add(help);
		setJMenuBar(mb);
	}
	
//������ ��� �ð�, ������� �ۼ�	
	public class Timethread extends Thread{ 
		public void run() {
			while(true) {
				Calendar calendar = Calendar.getInstance();
				int year = calendar.get(Calendar.YEAR);
				int month = calendar.get(Calendar.MONTH)+1; //0���� �����ϱ� ����
				int date = calendar.get(Calendar.DATE);
				int hour = calendar.get(Calendar.HOUR_OF_DAY);
				int min = calendar.get(Calendar.MINUTE);
				int sec = calendar.get(Calendar.SECOND);
				String st = year+"�� "+month+"�� "+date+"�� "+hour+":"+min+":"+sec;
				now.setText(st);
				try {Thread.sleep(1000);}
				catch(InterruptedException e) {return;}
			}
		}
	}
	
//���� ���̾�α� �޴�-����-�ҷ�����
	class openAction implements ActionListener{
		private JFileChooser chooser;
		public openAction() {chooser = new JFileChooser();}
		public void actionPerformed(ActionEvent e) {
			int ret = chooser.showOpenDialog(null);
			if (ret != JFileChooser.APPROVE_OPTION) { //������ �������� ���� ���
				JOptionPane.showMessageDialog(null,  "������ �������� �ʾҽ��ϴ�", "���",
						JOptionPane.WARNING_MESSAGE);
			}
		}
	}
	
//���� ���̾�α� �޴�-����-�����ϱ�	
	class saveAction implements ActionListener{
		private JFileChooser chooser;
		public saveAction() {chooser = new JFileChooser();}
		public void actionPerformed(ActionEvent e) {
			int ret = chooser.showSaveDialog(null);
			if (ret != JFileChooser.APPROVE_OPTION) { //������ �������� ���� ���
				JOptionPane.showMessageDialog(null,  "������ �������� �ʾҽ��ϴ�", "���",
						JOptionPane.WARNING_MESSAGE);
			}
		}
	}
//'�߰�'��ư�� ������ ��� �ߴ� �Է�â: ��� ���̾�α�
	class Addinput extends JDialog{
		Border info; //������ �ٿ��� ��� ����
		Border info0;
		JPanel north = new JPanel(); //movie, book�� ����(������ư)
		private JButton ok = new JButton("OK");
		private JButton ok0 = new JButton("OK");
		ButtonGroup group = new ButtonGroup();
		JRadioButton movie = new JRadioButton("Movie", true);
		JRadioButton book = new JRadioButton("Book");
		
	//movie�� �������� ��� �̿��ϴ� �гΰ� �󺧵�
		JPanel center = new JPanel();
		JPanel centertotal = new JPanel();
		JPanel center1 = new JPanel(); //����~����
		JPanel center1_1 = new JPanel();
		JPanel center1_2 = new JPanel();
		JPanel center2 = new JPanel(); //�ٰŸ�~������
		JPanel center2_1 = new JPanel();
		JPanel center2_2 = new JPanel();
		JPanel center3 = new JPanel(); //ok��ư
		
		JLabel a1 = new JLabel("����"); JLabel a2 = new JLabel("����");
		JLabel a3 = new JLabel("���"); JLabel a4 = new JLabel("�帣");
		JLabel a5 = new JLabel("���"); JLabel a6 = new JLabel("�����⵵");
		JLabel a7 = new JLabel("������"); JLabel a8 = new JLabel("����");
		JLabel a9 = new JLabel("�ٰŸ�"); JLabel a10 = new JLabel("������");
		JTextField mvtitle = new JTextField(""); //����
		JTextField director = new JTextField(""); //����
		JTextField actor = new JTextField(""); //���
		String[] genres = {"���", "�̽��͸�, ������", "�ڹ̵�", "����", "����", "SF", "������"}; //�帣
		JComboBox<String> genre = new JComboBox<String>(genres);
		String[] ratings = {"��ü", "12�� �̻�", "15�� �̻�", "û�ҳ� ���� �Ұ�"}; //���
		JComboBox<String> rating = new JComboBox<String>(ratings);
		JPanel pp = new JPanel(); //������
		JTextArea imglink = new JTextArea(1, 10);
		JButton getimg = new JButton("�ҷ�����");
		JSlider slider = new JSlider(JSlider.HORIZONTAL, 1, 10, 5); //����
		JScrollPane summary = new JScrollPane(new JTextArea(5, 30)); //�ٰŸ�
		JScrollPane review = new JScrollPane(new JTextArea(5, 30)); //������

	//book�� �������� ��� �̿��ϴ� �гΰ� �󺧵�
		JPanel center0 = new JPanel();
		JPanel centertotal0 = new JPanel();
		JPanel center01 = new JPanel(); //����~����
		JPanel center01_1 = new JPanel();
		JPanel center01_2 = new JPanel();
		JPanel center02 = new JPanel(); //å�Ұ�~������
		JPanel center02_1 = new JPanel();
		JPanel center02_2 = new JPanel();
		JPanel center03 = new JPanel(); //ok��ư
		
		JLabel b1 = new JLabel("����"); JLabel b2 = new JLabel("����");
		JLabel b3 = new JLabel("���ǻ�"); JLabel b4 = new JLabel("���ǳ⵵");
		JLabel b5 = new JLabel("å�̹���"); JLabel b6 = new JLabel("����");
		JLabel b7 = new JLabel("å�Ұ�"); JLabel b8 = new JLabel("������");
		JTextField booktitle = new JTextField(""); //����
		JTextField author = new JTextField(""); //����
		JTextField publisher = new JTextField(""); //���ǻ�
		JPanel bp = new JPanel(); //å�̹���
		JTextArea bimglink = new JTextArea(1, 10);
		JButton bgetimg = new JButton("�ҷ�����");
		JSlider bslider = new JSlider(JSlider.HORIZONTAL, 1, 10, 5); //����
		JTextArea introducing = new JTextArea(5, 30); //å�Ұ�
		JTextArea bookreview = new JTextArea(5, 30); //������
	
		public Addinput(JFrame frame, String title) {
			super(frame, title, true); //��� ���̾�α׷� ����
			setLayout(new BorderLayout());
			movie.addItemListener(new AddinputListener()); //������
			book.addItemListener(new AddinputListener());
			group.add(movie); group.add(book); north.add(movie); north.add(book);
			
			ok.addActionListener(new ActionListener() { //������
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
				}});
			ok0.addActionListener(new ActionListener() { //������
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
				}});
			getimg.addActionListener(new ActionListener() { //������
				JFileChooser chooser = new JFileChooser();
				public void actionPerformed(ActionEvent e) {
					int ret = chooser.showOpenDialog(null);
					if (ret == JFileChooser.APPROVE_OPTION) {
						String pathName = chooser.getSelectedFile().getPath();
						imglink.setText(pathName);
					}
				}});
			imglink.setEditable(false); //�����Ұ���
			bgetimg.addActionListener(new ActionListener() { //������
				JFileChooser chooser = new JFileChooser();
				public void actionPerformed(ActionEvent e) {
					int ret = chooser.showOpenDialog(null);
					if (ret == JFileChooser.APPROVE_OPTION) {
						String pathName = chooser.getSelectedFile().getPath();
						bimglink.setText(pathName);
					}
				}});
			bimglink.setEditable(false); //�����Ұ���
			int releases[] = new int[32]; //�����⵵
			for (int i=0; i<32; i++)	releases[i] = 2021-i;
			JComboBox<Integer> release = new JComboBox<Integer>();
			for (int i=0; i<32; i++)	release.addItem(releases[i]);
			slider.setPaintLabels(true); slider.setPaintTrack(true); slider.setMajorTickSpacing(1);
			
			int breleases[] = new int[32]; //���ǳ⵵
			for (int i=0; i<32; i++)	breleases[i] = 2021-i;
			JComboBox<Integer> brelease = new JComboBox<Integer>();
			for (int i=0; i<32; i++)	brelease.addItem(breleases[i]);
			bslider.setPaintLabels(true); bslider.setPaintTrack(true); bslider.setMajorTickSpacing(1);
		
			center.setLayout(new BorderLayout());
	//movie�� �������� ��� �̿��ϴ� �г�	
			center1.setLayout(new BorderLayout());
			center1_1.setLayout(new GridLayout(8, 1, 5, 5));
			center1_2.setLayout(new GridLayout(8, 1, 5, 5));
			center2.setLayout(new BorderLayout());
			center2_1.setLayout(new GridLayout(2, 1, 5, 5));
			center2_2.setLayout(new GridLayout(2, 1, 5, 5));
	
	//book�� �������� ��� �̿��ϴ� �г�
			center0.setLayout(new BorderLayout());
			center01.setLayout(new BorderLayout());
			center01_1.setLayout(new GridLayout(6, 1, 5, 5));
			center01_2.setLayout(new GridLayout(6, 1, 5, 5));
			center02.setLayout(new BorderLayout());
			center02_1.setLayout(new GridLayout(2, 1, 5, 5));
			center02_2.setLayout(new GridLayout(2, 1, 5, 5));
			
			//���̱�
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
			info = BorderFactory.createTitledBorder("��ȭ ����"); center.setBorder(info);
			
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
		class AddinputListener implements ItemListener{ //��޴��̾�α� ������ư ������
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.DESELECTED)	return;
				if (movie.isSelected()) { //movie�� ������ ���
					add(center, BorderLayout.CENTER);
					info = BorderFactory.createTitledBorder("��ȭ ����"); center.setBorder(info);
					center0.setVisible(false);
					center.setVisible(true);
				}
				else { //book�� ������ ���
					add(center0, BorderLayout.CENTER);
					info0 = BorderFactory.createTitledBorder("���� ����"); center0.setBorder(info0);
					center.setVisible(false);
					center0.setVisible(true);
				}
			}
		}
	}
	abstract class Item{ //�߻� Ŭ����
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
	class ItemCollections{ //Vector �Ǵ� ArrayList�� Item ����
		//Item�� ���, ����, ����, �˻��ϴ� ���� �޼ҵ带 �ۼ�
	}
	public static void main(String[] args) {
		new MyNotes();
	}
}
