// ������ (2016133)
// 2021-11-19
// Lab10 - �ǽ� 1. font ���� ȭ��
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;

public class FontTest extends JFrame{
	JRadioButton gul, dod, gung; //��Ʈ
	JCheckBox bold, italic; //��Ÿ��
	JTextField size, content; //������, ����
	JLabel result; //���

	int fsize=15, fstyle=Font.PLAIN;
	String ffont="";
	Font f = new Font(ffont, fstyle, fsize); //�⺻ ����;
	
	public FontTest() {
		setTitle("Font ����"); //Ÿ��Ʋ
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		
		JPanel west = new JPanel();
		GridLayout grid = new GridLayout(4, 1); 
		grid.setVgap(2); //�� ����
		west.setLayout(grid);
		west.add(new JLabel("Font ����")); //west�ǳڿ� ���̱�
		west.add(new JLabel("Style ����"));
		west.add(new JLabel("Size ����"));
		west.add(new JLabel("Text ����"));
		
		JPanel center = new JPanel();
		center.setLayout(grid);
		
		JPanel font = new JPanel();
		ButtonGroup g = new ButtonGroup(); //������ư�׷�
		gul = new JRadioButton("����"); //������ư
		dod = new JRadioButton("����"); 
		gung = new JRadioButton("�ü�");
		g.add(gul);	g.add(dod); g.add(gung); //������ư�׷����� ����
		font.add(gul); font.add(dod); font.add(gung); //font�ǳڿ� ���̱�
		center.add(font); //center�ǳڿ� ���̱�
		gul.addItemListener(new listener1()); dod.addItemListener(new listener1());
		gung.addItemListener(new listener1()); //�����ʺ��̱�
		
		JPanel style = new JPanel();
		bold = new JCheckBox("BOLD"); //üũ�ڽ�
		italic = new JCheckBox("ITALIC");
		style.add(bold); style.add(italic); //style�ǳڿ� ���̱�
		center.add(style); //center�ǳڿ� ���̱�
		bold.addItemListener(new listener2());//������ �ޱ�
		italic.addItemListener(new listener2()); 
		
		size = new JTextField("15"); //�ؽ�Ʈ�ʵ�
		center.add(size); //center�ǳڿ� ���̱� 
		size.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { //������ �ޱ�
				fsize = Integer.parseInt(size.getText());
				result.setFont(new Font(ffont, fstyle, fsize));
			}});
		
		content = new JTextField("Hello World"); //�ؽ�Ʈ�ʵ�, �ʱ� ����
		center.add(content);//center�ǳڿ� ���̱�
		content.addActionListener(new ActionListener() { //������ �ޱ�
			public void actionPerformed(ActionEvent e) {
				result.setText(content.getText());
				result.setFont(new Font(ffont, fstyle, fsize));
			}});
		
		JPanel south = new JPanel();
		Border resultBorder = BorderFactory.createTitledBorder("Font ���� ���"); //������ �ٿ��� ��� ���� 
		result = new JLabel(content.getText());
		result.setFont(f);
		south.setBorder(resultBorder); //south�ǳڿ� ���̱�
		south.add(result);
		
		c.add(west, BorderLayout.WEST); // �����̳ʿ� ����
		c.add(center, BorderLayout.CENTER);
		c.add(south, BorderLayout.SOUTH);
		
		setSize(300, 250); //������ ũ��
		setVisible(true); //�������� ȭ�鿡 ���
	}
	class listener1 implements ItemListener{
		public void itemStateChanged(ItemEvent e) {
			if (e.getStateChange() == ItemEvent.DESELECTED)	return; //������ ���¶�� ����������
			if (gul.isSelected())
				ffont = "����ü";
			else if (dod.isSelected())
				ffont = "����ü";
			else if (gung.isSelected())
				ffont = "�ü�ü";
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
