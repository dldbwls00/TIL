// ������ (2016133)
// 2021-12-03
// Lab12 - �ǽ� 3~5. �޴�, ����, ���̾�α� �ǽ�
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SwingTest extends JFrame{
	private JLabel lb = new JLabel("Text");
	
	public SwingTest() {
		setTitle("Menu ����� ����"); //Ÿ��Ʋ
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		c.add(lb);
		
		createMenu(); //�޴� ����, �����ӿ� ����(���� �޼ҵ��)
		setSize(400,300);
		setVisible(true);
	}
	private void createMenu() { //�޴� ���� �޼���
		lb.setToolTipText("������ ���� ����� �����Դϴ�"); //����
		JMenuBar mb = new JMenuBar();
		
		JMenu filemenu = new JMenu("����");
		JMenuItem open = new JMenuItem("����");
		filemenu.add(open);
		open.addActionListener(new openAction()); //������
		JMenuItem save = new JMenuItem("����");
		filemenu.add(save);
		save.addActionListener(new saveAction()); //������
		filemenu.addSeparator(); //�и��� ����
		JMenuItem exit = new JMenuItem("����");
		filemenu.add(exit);
		exit.addActionListener(new showConfirmDialog()); //������
		mb.add(filemenu);
		
		JMenu editmenu = new JMenu("����");
		JMenuItem choosecolor = new JMenuItem("�� ����");
		editmenu.add(choosecolor);
		choosecolor.addActionListener(new chooseColor()); //������
		JMenuItem choosefont = new JMenuItem("��Ʈ");
		editmenu.add(choosefont);
		choosefont.addActionListener(new chooseFont()); //������
		JMenuItem changetext = new JMenuItem("�ؽ�Ʈ ����");
		editmenu.add(changetext);
		changetext.addActionListener(new showInputDialog()); //������
		mb.add(editmenu);
		
		JMenu helpmenu = new JMenu("����");
		JMenuItem versioninfo = new JMenuItem("���� ����");
		helpmenu.add(versioninfo);
		versioninfo.addActionListener(new showMessageDialog()); //������
		mb.add(helpmenu);

		setJMenuBar(mb);
	}
//�ǽ�3
	class showConfirmDialog implements ActionListener{ //�˾� ���̾�α� "����" �޴�
		public void actionPerformed(ActionEvent e) {
			int result = JOptionPane.showConfirmDialog(null, "�����Ͻðڽ��ϱ�?",
					"���� Ȯ��", JOptionPane.YES_NO_OPTION);
			if (result == JOptionPane.YES_OPTION) //"��"��ư�� ���� ���
				System.exit(0); //���α׷� ����
		}
	}
	class showInputDialog implements ActionListener{ //�˾� ���̾�α� "�ؽ�Ʈ ����" �޴�
		public void actionPerformed(ActionEvent e) {
			String text = JOptionPane.showInputDialog("������ �ؽ�Ʈ�� �Է��ϼ���");
			if (text != null)
				lb.setText(text);
		}
	}
	class showMessageDialog implements ActionListener{//�˾� ���̾�α� "���� ����" �޴�
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null, "�׽�Ʈ v1.0", "���� ����",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}
//�ǽ�4
	class openAction implements ActionListener{//���� ���̾�α� "����" �޴�
		private JFileChooser chooser;
		public openAction() {
			chooser = new JFileChooser();
		}
		public void actionPerformed(ActionEvent e) {
			int ret = chooser.showOpenDialog(null);
			if (ret != JFileChooser.APPROVE_OPTION) { //������ �������� ���� ���
				JOptionPane.showMessageDialog(null,  "������ �������� �ʾҽ��ϴ�", "���",
						JOptionPane.WARNING_MESSAGE);
			}
			String filepath = chooser.getSelectedFile().getPath(); //��� ��������
			lb.setText(filepath+"������ ���õǾ����ϴ�");
		}
		
	}
	class saveAction implements ActionListener{//���� ���̾�α� "����" �޴�
		private JFileChooser chooser;
		public saveAction() {
			chooser = new JFileChooser();
		}
		public void actionPerformed(ActionEvent e) {
			int ret = chooser.showSaveDialog(null);
			if (ret != JFileChooser.APPROVE_OPTION) { //������ �������� ���� ���
				JOptionPane.showMessageDialog(null,  "������ �������� �ʾҽ��ϴ�", "���",
						JOptionPane.WARNING_MESSAGE);
			}
			String filepath = chooser.getSelectedFile().getPath(); //��� ��������
			lb.setText(filepath+"���Ͽ� ����Ǿ����ϴ�");
		}
	}
	class chooseColor implements ActionListener{//�÷� ���̾�α� "�� ����" �޴�
		public void actionPerformed(ActionEvent e) {
			Color selected = JColorChooser.showDialog(null, "Color", Color.RED);
			if (selected != null)
				lb.setForeground(selected);
	}
}
//�ǽ�5
	class FontTest extends JDialog{ //��޴��̾�α�
		JRadioButton gul, dod, gung; //��Ʈ
		JCheckBox bold, italic; //��Ÿ��
		JTextField size, content; //������, ����
		JButton set; //���� ��ư
		
		int fsize, fstyle;
		String ffont;
		Font f = new Font(ffont, fstyle, fsize); //�⺻ ����;
		
		private String[] fonts = {"����", "����", "���", "����"}; //��Ʈ �迭
		
		public FontTest(JFrame frame, String title) {
			super(frame, title, true); //��� ���̾�α׷� ����
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			Container c = getContentPane();
			c.setLayout(new BorderLayout());
			
			JPanel west = new JPanel();
			GridLayout grid = new GridLayout(3, 1); 
			grid.setVgap(2); //�� ����
			west.setLayout(grid);
			west.add(new JLabel("��Ʈ ����")); //west�ǳڿ� ���̱�
			west.add(new JLabel("��Ʈ ��Ÿ��"));
			west.add(new JLabel("��Ʈ ũ��"));
		
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
			
					if (index == 0)	ffont = "����";
					else if (index == 1)	ffont = "����";
					else if (index == 2)	ffont = "���";
					else if (index == 3)	ffont = "����";
				}});
			center.add(font); //center�ǳڿ� ���̱�

			
			JPanel style = new JPanel();
			bold = new JCheckBox("bold"); //üũ�ڽ�
			italic = new JCheckBox("italic");
			style.add(bold); style.add(italic); //style�ǳڿ� ���̱�
			center.add(style); //center�ǳڿ� ���̱�
			bold.addItemListener(new myitemlistener());//������ �ޱ�
			italic.addItemListener(new myitemlistener()); 
			
			size = new JTextField(""); //�ؽ�Ʈ�ʵ�
			center.add(size); //center�ǳڿ� ���̱� 
			size.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) { //������ �ޱ�
					fsize = Integer.parseInt(size.getText());
				}});
			
			JPanel south = new JPanel();
			set = new JButton("����");
			south.add(set);
			set.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					lb.setFont(new Font(ffont, fstyle, fsize));
				}
			});
			
			c.add(west, BorderLayout.WEST); // �����̳ʿ� ����
			c.add(center, BorderLayout.CENTER);
			c.add(south, BorderLayout.SOUTH);
			
			setSize(300, 250); //������ ũ��
			setVisible(false); //�������� ȭ�鿡 ���
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
	class chooseFont implements ActionListener{//���̾�α� "��Ʈ" �޴�
		public void actionPerformed(ActionEvent e) {
			dialog.setVisible(true);
		}
	}
	public static void main(String[] args) {
		new SwingTest();
	}

}
